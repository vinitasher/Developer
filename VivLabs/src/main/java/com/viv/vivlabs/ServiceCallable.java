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
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ServiceCallable<T> implements Callable {

    EndpointInfo serviceEndpoint;
    Map<String, Object> parameters;
    Long id = 0L;

    public ServiceCallable(EndpointInfo serviceEndpoint, Map<String, Object> parameters) {
        this.id = Thread.currentThread().getId();
        this.serviceEndpoint = serviceEndpoint;
        this.parameters = parameters;
    }

    @Override
    public List<T> call() throws Exception {
        System.out.println("Call method Thread: " + id + " ServiceEndpoint: " + serviceEndpoint.getClass());
        String output = null;
        try {
            URL url = new URL(serviceEndpoint.applicationLocation + "/invoke");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : parameters.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            String postdata = postData.toString();
            byte[] postDataBytes = postData.toString().getBytes();
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            while ((output = br.readLine()) != null) {
                System.out.println("Invoke:" + output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (List<T>) new ArrayList<String>();
    }

}
