/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.model.Activity;
import java.util.List;
import javax.net.ssl.SSLEngineResult;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import jdk.net.SocketFlow;

/**
 *
 * @author linzhang
 */
public class ActivityClient {
    
    private Client client;
    
    public ActivityClient () {
        client = ClientBuilder.newClient();
    }
    
    public Activity get(String id) {
        
        //http://localhost:8080/zRESTFulWebServices/webresources/activities/1234
        WebTarget target = client.target("http://localhost:8080/zRESTFulWebServices/webresources/");
        Response response= target.path("activities/" + id).request().get(Response.class);
        
        if (response.getStatus() != 200) {
            
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }
        
        return response.readEntity(Activity.class);
    }
    
    public List<Activity> get() {
        
        WebTarget target = client.target("http://localhost:8080/zRESTFulWebServices/webresources/");
        
        List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
        
        return response;
    }

    Activity create(Activity activity) {
        
        //http://localhost:8080/zRESTFulWebServices/webresources/activities/activity
        WebTarget target = client.target("http://localhost:8080/zRESTFulWebServices/webresources/");
        
        Response response= target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
        
        if (response.getStatus() != 200) {
            
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }
        
        return response.readEntity(Activity.class);
    }
}
