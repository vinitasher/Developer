package com.Viv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;

/**
 * @author priyanka
 *
 * @param <T>
 */
@Path("/ServiceManager")
public class ServiceManager<T> {
	private static ArrayList<String> serviceList = new ArrayList<String>();
	private static HashMap<String, ExecutorService> serviceThreadPoolAssociation = new HashMap();

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
	/*
	@GET
	//@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/getAllServices")
	public Response getAllRegisteredServices(){
		 List<String> list = Arrays.asList("");
		GenericEntity<List<String>> gm = new GenericEntity<List<String>>(list){};
		try{
			gm = new GenericEntity<List<String>>(serviceList) {};
		}catch(Exception ex){
			return Response.ok(gm).build();
		}
		return Response.ok(gm).build();
	}*/
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getAllServices")
	public Response getAllRegisteredServices(){
		StringList list = new StringList(serviceList);
		return Response.ok(list).build();
	}
	
	
	@GET
	@Path("/getResults")
	public void getResults() {
		getServiceConnection(serviceList.get(0));
	}
	
	/*
	@POST
	@Path("/getResults")
	public List<T> getResults(Map<String, Object> parameters) {
		List<ServiceEndpoint<T>> applicableResources = calculateApplicableResources(parameters.keySet());
		System.out.println("The list of applicable resource: " + Arrays.toString(applicableResources.toArray()));
		List<T> result = invokeApplicableResources(applicableResources, parameters);
		return result;
		
		getServiceConnection(serviceList.get(0));
	}*/
	/*
	private List<T> invokeApplicableResources(List<ServiceEndpoint<T>> applicableResources,
			Map<String, Object> parameters) {
		System.out.println("Entering invoke method in SM");
		ExecutorService executor;
		List<T> aggregatedResult = new ArrayList<T>();
		List<Future<List<T>>> futureList = new ArrayList<Future<List<T>>>();
		for (ServiceEndpoint<T> sed : applicableResources) {
			if (serviceThreadPoolAssociation.containsKey(sed)) {
				executor = serviceThreadPoolAssociation.get(sed);
			} else {
				executor = Executors.newFixedThreadPool(sed.getMaxConcurrentInvocations());
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
	}*/
	
	public String getServiceConnection(String applicationName){
		String output = null;
		try {
			URL url = new URL(applicationName+"/getMaxConcurrentInvocations");
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
				System.out.println(output);
			}
			conn.disconnect();
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		return output;
	}
/*
	private List<ServiceEndpoint<T>> calculateApplicableResources(Set<String> inputParameters) {
		List<ServiceEndpoint<T>> applicableResources = new ArrayList<>();
		for (String applicationName : serviceList) {
			Set<String> supportedParameters = sed.getSupportedParameters();
			if (supportedParameters.size() >= inputParameters.size()) {
				if (supportedParameters.containsAll(inputParameters)) {
					applicableResources.add(sed);
				}
			}
		}
		return applicableResources;
	}*/

}
