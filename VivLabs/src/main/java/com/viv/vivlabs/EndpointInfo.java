/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viv.vivlabs;

import java.util.Set;

/**
 *
 * @author vasher
 */
public class EndpointInfo {

    int maxConcurrentInvocations;
    Set<String> supportedParameters;
    String applicationLocation;
    
    public EndpointInfo(int maxConcurrentInvocations, Set<String> supportedParameters, String appLocation) {
        this.maxConcurrentInvocations = maxConcurrentInvocations;
        this.supportedParameters = supportedParameters;
        this.applicationLocation = appLocation;
    }
    
    public boolean supportsParameters(Set<String> params){
        if(supportedParameters.size() >= params.size()){
            return supportedParameters.containsAll(params);
        }
        return false;
    }
    
}
