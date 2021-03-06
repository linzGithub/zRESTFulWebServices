/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.client.ActivityClient;
import com.demo.client.ActivitySearchClient;
import com.demo.model.Activity;
import com.demo.model.ActivitySearch;
import com.demo.model.ActivitySearchType;
import java.util.ArrayList;
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
    
    @Test
    public void testPut() {
        
        Activity activity = new Activity();
        
        activity.setId("3456");
        activity.setDescription("Biking");
        activity.setDuration(90);
        
        ActivityClient client = new ActivityClient();
        activity = client.update(activity);
    }
    
    @Test
    public void testDelete() {
        
        ActivityClient client = new ActivityClient();
        
        client.delete("1234");
        
    }
    
    @Test
    public void testSearch(){
        
        ActivitySearchClient client = new ActivitySearchClient();
        
        String param = "description";
        List<String> searchValues = new ArrayList<String>();
        
        searchValues.add("Swimming");
        searchValues.add("Running");
        
        List<Activity> activities = client.search(param, searchValues);
        
        System.out.println(activities);
        assertNotNull(activities);
    }
    
    @Test
    public void testSearchObject() {
        
        ActivitySearchClient client = new ActivitySearchClient();
        
        List<String> searchValues = new ArrayList<String>();
        
        searchValues.add("Biking");
        searchValues.add("Running");
        
        ActivitySearch search = new ActivitySearch();
        
        search.setDescriptions(searchValues);
        search.setDurationFrom(30);
        search.setDurationTo(55);
        
        search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
        
        List<Activity> activities = client.search(search);
        
        System.out.println(activities);
        
        assertNotNull(activities);
        
    }
}
