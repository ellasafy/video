package com.cstor.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.cstor.model.Account;

@Path("/hello")
public class HelloWorldService {
 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/plain")
    public String getMsg(@PathParam("param") String msg) {
 
        String output = "Jersey say : " + msg;
        
 
        return output;
 
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/account")
    public List<Account> getJson() {
        List<Account> lists = new ArrayList<Account>();
        for (int i = 0; i < 10; i++) {
            Account ac = new Account();
            ac.setId(i);
            ac.setName("id" + i);
            lists.add(ac);
        }
        
        return lists;
    }
 
}