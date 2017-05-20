///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pigtail.pigtailmicroservice3;
//
//import com.sun.jersey.api.container.grizzly2.GrizzlyWebContainerFactory;
//import org.glassfish.grizzly.http.server.HttpServer;
// 
//import javax.ws.rs.core.UriBuilder;
//import java.io.IOException;
//import java.net.URI;
//import java.util.HashMap;
//import java.util.Map;
// 
//public class App {
//     
//    private static URI getBaseURI() {
//        return UriBuilder.fromUri("http://localhost/").port(8080).build();
//    }
// 
//    public static final URI BASE_URI = getBaseURI();
// 
//    protected static HttpServer startServer() throws IOException {
//        final Map<String, String> initParams = new HashMap<String, String>();
// 
//        initParams.put("com.sun.jersey.config.property.packages", 
//                "com.giantflyingsaucer.jerseyrestgrizzly");
// 
//        System.out.println("Starting grizzly...");
//        return GrizzlyWebContainerFactory.create(BASE_URI, initParams);
//    }
//     
//    public static void main(String[] args) throws IOException {
//        HttpServer httpServer = startServer();
//        System.out.println(String.format("Jersey app started with WADL available at "
//                + "%sapplication.wadl\nTry out %shelloworld\nHit enter to stop it...",
//                BASE_URI, BASE_URI));
//        System.in.read();
//        httpServer.stop();
//    }
//}
