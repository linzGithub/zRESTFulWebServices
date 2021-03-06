/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.repository;

import com.demo.model.Activity;
import com.demo.model.ActivitySearch;
import java.util.List;

/**
 *
 * @author linzhang
 */
public interface ActivityRepository {

    List<Activity> findAllActivities();

    public Activity findActivity(String activityId);

    public void create(Activity activity);

    public Activity update(Activity activity);

    public void delete(String activityId);

    public List<Activity> findByDescription(List<String> description);

    public List<Activity> findByConstraints(ActivitySearch search);
    
}
