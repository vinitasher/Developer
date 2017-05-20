/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pigtail.pigtailmicroservice3;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 
@Path("/helloworld")
public class HelloWorldResource {
 
    @GET
    @Produces("text/plain")
    public String getMessage() {
        return "Hello World123";
    }
}