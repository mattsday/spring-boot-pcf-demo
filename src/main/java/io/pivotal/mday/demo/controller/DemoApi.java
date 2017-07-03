package io.pivotal.mday.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.mday.demo.model.Service;
import io.pivotal.mday.demo.model.Services;

@RestController
public class DemoApi {

	@Value("${services.demo}")
	private String vcapServicesDemo;

	public DemoApi() {

	}

	@RequestMapping("/")
	public ModelAndView home() throws JsonProcessingException, IOException {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("services", getServiceInstances());

		if (getServiceInstances().size() > 0) {
			return new ModelAndView("views/home-services", model);
		}
		return new ModelAndView("views/home", model);
	}

	@RequestMapping("/service/{serviceName}")
	public ModelAndView getService(@PathVariable("serviceName") String serviceName)
			throws JsonProcessingException, IOException {

		for (Service service : getServiceInstances()) {
			if (serviceName.equals(service.getName())) {
				Map<String, Service> model = new HashMap<>();
				model.put("vcapService", service);
				return new ModelAndView("views/service", model);
			}
		}
		return null;
	}

	@GetMapping("/services")
	public Services getServices() throws JsonProcessingException, IOException {
		String vcapServices = System.getenv("VCAP_SERVICES");
		if (null == vcapServices) {
			vcapServices = vcapServicesDemo;
		}
		return new ObjectMapper().readValue(vcapServices, Services.class);
	}

	@GetMapping("/services/instances")
	public List<Service> getServiceInstances() throws JsonProcessingException, IOException {
		ArrayList<Service> list = new ArrayList<>(getServices().any().keySet().size());
		for (String service : getServices().any().keySet()) {
			for (Service instance : getServices().any().get(service)) {
				list.add(instance);
			}
		}
		return list;
	}
}
