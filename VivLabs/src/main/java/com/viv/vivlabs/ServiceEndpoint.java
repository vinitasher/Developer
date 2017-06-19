/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viv.vivlabs;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ServiceEndpoint<T> {
    int getMaxConcurrentInvocations();
    Set<String> getSupportedParameters();
    List<T> invoke(Map<String, Object> parameters);
}
