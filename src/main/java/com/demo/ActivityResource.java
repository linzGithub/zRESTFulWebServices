/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.model.Activity;
import com.demo.repository.ActivityRepository;
import com.demo.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author linzhang
 */

@Path("activities")
public class ActivityResource {
    
    private ActivityRepository activityRepository = new ActivityRepositoryStub();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }
    
}
