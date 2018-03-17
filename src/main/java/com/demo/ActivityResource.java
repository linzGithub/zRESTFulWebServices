/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.model.Activity;
import com.demo.model.User;
import com.demo.repository.ActivityRepository;
import com.demo.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author linzhang
 */

@Path("activities") //http://localhost:8080/zRESTFulWebServices/webresources/activities
public class ActivityResource {
    
    private ActivityRepository activityRepository = new ActivityRepositoryStub();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}") //http://localhost:8080/zRESTFulWebServices/webresources/activities/1234
    public Response getActivity(@PathParam("activityId") String activityId) {
        
        if (activityId == null || activityId.length() < 4) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        
        Activity activity = activityRepository.findActivity(activityId);
        
        if (activity == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok().entity(activity).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{activityId}/user") //http://localhost:8080/zRESTFulWebServices/webresources/activities/1234/user
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
        
    }
    
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        
        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        
        activityRepository.create(activity);
        
        return activity;
    }
    
    
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
        
        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));
       
        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
        
        activityRepository.create(activity);
        
        return activity;
    }
}
