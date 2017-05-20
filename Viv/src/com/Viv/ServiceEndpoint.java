package com.Viv;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ServiceEndpoint<T> {
	int getMaxConcurrentInvocations();
    Set<String> getSupportedParameters();
    List<T> invoke(Map<String, Object> parameters);
}
