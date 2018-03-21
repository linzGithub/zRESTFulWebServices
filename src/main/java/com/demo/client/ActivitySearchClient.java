/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.model.Activity;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author linzhang
 */
public class ActivitySearchClient {
 
    private Client client;
    
    public ActivitySearchClient() {
        
        client = ClientBuilder.newClient();
    }
    
    public List<Activity> search (String param, List<String> searchValues) {
        
        URI uri = UriBuilder.fromUri("http://localhost:8080/zRESTFulWebServices/webresources")
                .path("search/activities")
                .queryParam(param, searchValues)
                .build();
        
        WebTarget target = client.target(uri);
        
        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>> () {});
        
        System.out.println(response);
        
        return response;
    }
    
   
    
    
}
