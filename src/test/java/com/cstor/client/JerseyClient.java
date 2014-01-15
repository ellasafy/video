package com.cstor.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.cstor.model.Account;


public class JerseyClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:9013/video/rest/hello/plain")
                .request().get();
        System.out.println(response);
        String res = client.target("http://localhost:9013/video/rest/hello/account")
                .request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(res);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Account> acl = mapper.readValue(res, new TypeReference<List<Account>>() { });
            System.out.println(acl);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

}
