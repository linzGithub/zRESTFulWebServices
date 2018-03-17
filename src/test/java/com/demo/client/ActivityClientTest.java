/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.model.Activity;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linzhang
 */
public class ActivityClientTest {
    
    public ActivityClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
        
        System.out.println("In testGetList" + activities);
        
        assertNotNull(activities);
    }
    
    @Test(expected=RuntimeException.class)
    public void testGetWithBadRequest() {
        
        ActivityClient client = new ActivityClient();
        
        client.get("123");
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
