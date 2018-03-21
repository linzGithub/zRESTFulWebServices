/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import java.util.List;

/**
 *
 * @author linzhang
 */
public class ActivitySearch {
    
    private int durationFrom;
    private int durationTo;
    
    private List<String> descriptions;
    
    private ActivitySearchType searchType;

    /**
     * @return the durationFrom
     */
    public int getDurationFrom() {
        return durationFrom;
    }

    /**
     * @param durationFrom the durationFrom to set
     */
    public void setDurationFrom(int durationFrom) {
        this.durationFrom = durationFrom;
    }

    /**
     * @return the durationTo
     */
    public int getDurationTo() {
        return durationTo;
    }

    /**
     * @param durationTo the durationTo to set
     */
    public void setDurationTo(int durationTo) {
        this.durationTo = durationTo;
    }

    /**
     * @return the descriptions
     */
    public List<String> getDescriptions() {
        return descriptions;
    }

    /**
     * @param descriptions the descriptions to set
     */
    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * @return the searchType
     */
    public ActivitySearchType getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(ActivitySearchType searchType) {
        this.searchType = searchType;
    }
    
    
    
}
