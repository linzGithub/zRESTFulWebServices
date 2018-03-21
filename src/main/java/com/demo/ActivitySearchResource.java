/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.model.Activity;
import com.demo.model.ActivitySearch;
import com.demo.repository.ActivityRepository;
import com.demo.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author linzhang
 */
@Path("search/activities")
public class ActivitySearchResource {
    
    private ActivityRepository activityRepository = new ActivityRepositoryStub();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(@QueryParam(value = "description") List<String> description) {
        
        System.out.println(description);
        
        List<Activity> activities = activityRepository.findByDescription(description);
        
        if (activities == null || activities.size() <= 0) {
            
            return Response.status(Status.NOT_FOUND).build();
        }
        
        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(ActivitySearch search) {
        
        System.out.println(search.getDescriptions() + ", " + search.getDurationFrom());
        
        List<Activity> activities = activityRepository.findByConstraints(search);
        
        if (activities == null || activities.size() <= 0) {
            
            return Response.status(Status.NOT_FOUND).build();
        }
        
        return Response.ok().entity(new GenericEntity<List<Activity>> (activities) {}).build();
    }
    
    
}
