package io.pivotal.mday.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Services {
	private Map<String, List<Service>> service = new HashMap<>();

	@JsonAnyGetter
	public Map<String, List<Service>> any() {
		return service;
	}

	@JsonAnySetter
	public void set(String name, List<Service> value) {
		service.put(name, value);
	}
}
