package com.cstor.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

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
    
    @POST
    public void setAccount(Account ac, @Context HttpServletRequest request) {
        System.out.println(ac);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String setAcount(InputStream is) {
        if (is != null) {
            System.out.println("not null");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readValue(is, Account.class); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "succes";
    }
 
}