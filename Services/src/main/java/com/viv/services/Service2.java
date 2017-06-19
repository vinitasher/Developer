/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viv.services;

/**
 *
 * @author vasher
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Service2")
public class Service2 implements ServiceEndpoint<String>{

	@Override
	@GET
	@Path("/getMaxConcurrentInvocations")
	public int getMaxConcurrentInvocations() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*100);
	}

	@Override
        @GET
        @Produces({MediaType.APPLICATION_JSON})
	@Path("/getSupportedParameters")
	public Set<String> getSupportedParameters() {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		return set;
	}

	@Override
        @POST
        @Produces({MediaType.APPLICATION_JSON})
	@Path("/invoke")
	public List<String> invoke(Map<String, Object> parameters) {
                //System.out.println(parameters);
		List<String> list = new ArrayList<String>();
		list.add("California");
		list.add("WestCoast");
		list.add("1000");
		try {
			Thread.currentThread().sleep((long) Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}