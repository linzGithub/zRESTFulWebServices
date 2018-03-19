/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.client.ActivityClient;
import com.demo.model.Activity;

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
    
}
