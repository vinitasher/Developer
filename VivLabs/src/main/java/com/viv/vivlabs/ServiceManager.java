/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viv.vivlabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * @author priyanka
 *
 * @param <T>
 */
@Path("/ServiceManager")
public class ServiceManager<T> {

    private static ArrayList<String> serviceList = new ArrayList<String>();
    private static HashMap<String, ExecutorService> serviceThreadPoolAssociation = new HashMap();
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
          .withCache("preConfigured",
               CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, EndpointInfo.class,
                                              ResourcePoolsBuilder.heap(100))
               .build())
          .build(true);

      Cache<String, EndpointInfo> preConfigured
          = cacheManager.getCache("preConfigured", String.class, EndpointInfo.class);

      Cache<String, EndpointInfo> myCache = cacheManager.createCache("myCache",
          CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, EndpointInfo.class,
                                        ResourcePoolsBuilder.heap(100)).build());

    /**
     * @param sep
     */
    @POST
    @Path("/register")
    public Response register(String applicationName) {
        try {
            URL u = new URL(applicationName);
            u.toURI();
        } catch (MalformedURLException | URISyntaxException ex) {
            return Response.status(400).entity("Incorrect URL. Cannot be registered").build();
        }
        if (!serviceList.contains(applicationName)) {
            serviceList.add(applicationName);
            return Response.status(200).entity("This service is registered successfully").build();
        }
        return Response.status(302).entity("This service is already registered").build();
    }

    @POST
    @Path("/unregister")
    public Response unRegister(String applicationName) {
        if (serviceList.contains(applicationName)) {
            serviceList.remove(applicationName);
            return Response.status(200).entity("You have been successfully unregistered").build();
        }
        return Response.status(400).entity("This service was not registered").build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/getAllServices")
    public Response getAllRegisteredServices() {
        StringList list = new StringList(serviceList);
        return Response.ok(list).build();
    }

    @POST
    @Path("/getResults")
    public List<T> getResults(Map<String, Object> parameters) {
        System.out.println("Get Results");
        List<EndpointInfo> applicableResources = _calculateApplicableResources(parameters.keySet());
        //System.out.println("The list of applicable resource: " + Arrays.toString(applicableResources.toArray()));
        List<T> result = _invokeApplicableResources(applicableResources, parameters);
        return result;
    }

    private List<T> _invokeApplicableResources(List<EndpointInfo> applicableResources,
            Map<String, Object> parameters) {
        System.out.println("Entering invoke method in SM");
        ExecutorService executor;
        List<T> aggregatedResult = new ArrayList<T>();
        List<Future<List<T>>> futureList = new ArrayList<Future<List<T>>>();
        for (EndpointInfo sed : applicableResources) {
            if (serviceThreadPoolAssociation.containsKey(sed)) {
                executor = serviceThreadPoolAssociation.get(sed);
            } else {
                executor = Executors.newFixedThreadPool(sed.maxConcurrentInvocations);
            }
            ServiceCallable serviceCallable = new ServiceCallable(sed, parameters);
            Future<List<T>> futureResult = executor.submit(serviceCallable);
            futureList.add(futureResult);
        }

        List<T> result = null;
        for (Future<List<T>> futureResult : futureList) {
            try {
                result = futureResult.get(5000, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                System.out.println("Time out after 5 seconds");
                futureResult.cancel(true);
            } catch (InterruptedException ie) {
                System.out.println("Error: Interrupted");
            } catch (ExecutionException ee) {
                System.out.println("Error: Execution interrupted");
            } 
            aggregatedResult.addAll(result);
        }

        System.out.println("Exiting invoke method in SM");
        return aggregatedResult;
    }

//    public String getServiceConnection(String applicationName) {
//        String output = null;
//        try {
//            URL url = new URL(applicationName + "/getMaxConcurrentInvocations");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//            conn.disconnect();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return output;
//    }
    
    private static EndpointInfo _getEndpointInfo(String applicationName) {
        int max = _getMaxConcurrentInvocations(applicationName);
        Set<String> params = _getSupportedParameters(applicationName);
        EndpointInfo endpoint = new EndpointInfo(max, params, applicationName);
        return endpoint;
    }

    private static Set<String> _getSupportedParameters(String applicationName) {
        String output = null;
        try {
            URL url = new URL(applicationName + "/getSupportedParameters");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            while ((output = br.readLine()) != null) {
                System.out.println("Get Supported Parameters"+output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashSet<String>();
    }

    private static int _getMaxConcurrentInvocations(String applicationName) {
        String output = null;
        try {
            URL url = new URL(applicationName + "/getMaxConcurrentInvocations");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            while ((output = br.readLine()) != null) {
                return Integer.parseInt(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private List<EndpointInfo> _calculateApplicableResources(Set<String> inputParameters) {
        List<EndpointInfo> applicableResources = new ArrayList<>();
        for (String applicationName : serviceList) {
            EndpointInfo endpoint = null;
            if(myCache.containsKey(applicationName)){
                endpoint = myCache.get(applicationName);
            } else {
                endpoint = _getEndpointInfo(applicationName);
                myCache.put(applicationName, endpoint);
            }
            if(endpoint.supportsParameters(inputParameters)){
                applicableResources.add(endpoint);
            }
        }
        return applicableResources;
    }

}
