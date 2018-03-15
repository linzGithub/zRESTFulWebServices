/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.repository;

import com.demo.model.Activity;
import com.demo.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linzhang
 */
public class ActivityRepositoryStub implements ActivityRepository {
    
    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();
        
        Activity activity1 = new Activity();
        
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        
        activities.add(activity1);
        
        Activity activity2 = new Activity();
        
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        
        activities.add(activity2);
        
        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {
        //database query put here, now use static for demo
        Activity activity1 = new Activity();
        
        activity1.setId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
                
        User user = new User();
        user.setId("5678");
        user.setName("Bryan");
        
        activity1.setUser(user);
        
        return activity1;
    }
    
    
    
}
