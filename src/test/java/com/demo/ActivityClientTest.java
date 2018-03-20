/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.client.ActivityClient;
import com.demo.model.Activity;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linzhang
 */
public class ActivityClientTest {
    
    public ActivityClientTest() {
    }
    
    @Test
    public void testGet() {
        
        ActivityClient client = new ActivityClient();
        
        Activity activity = client.get("1234");
        
        System.out.println(activity);
        
        assertNotNull(activity);
    }


    @Test
    public void testGetList() {
        
        ActivityClient client = new ActivityClient();
        
        List<Activity> activities = client.get();
        
        System.out.println(activities);
        
        assertNotNull(activities);
    }
    
    @Test(expected=RuntimeException.class)
    public void testGetWithBadRequest() {
        
        ActivityClient client = new ActivityClient();
        
        client.get("123");
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testGetWithNotFound() {
        
        ActivityClient client = new ActivityClient();
        
        client.get("7777");
        
    }
    
    @Test
    public void testCreate() {
        
        ActivityClient client = new ActivityClient();
        
        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(90);
        
        activity = client.create(activity);
        
        assertNotNull(activity);
    }
}
