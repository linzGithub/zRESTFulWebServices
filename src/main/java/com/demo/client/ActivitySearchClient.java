/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.model.Activity;
import com.demo.model.ActivitySearch;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        
        //http://localhost:8080/zRESTFulWebServices/webresources/search/activities?description=Swimming&description=Running
        URI uri = UriBuilder.fromUri("http://localhost:8080/zRESTFulWebServices/webresources")
                .path("search/activities")
                .queryParam(param, searchValues)
                .build();
        
        WebTarget target = client.target(uri);
        
        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>> () {});
        
        System.out.println(response);
        
        return response;
    }

    public List<Activity> search(ActivitySearch search) {
        
        URI uri = UriBuilder.fromUri("http://localhost:8080/zRESTFulWebServices/webresources")
                .path("search/activities")
                .build();
        
        WebTarget target = client.target(uri);
        
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(search, MediaType.APPLICATION_JSON));
        
        
        if (response.getStatus() != 200) {
            
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
        
        return response.readEntity(new GenericType<List<Activity>> () {});
    }
    
    
}
