package com.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "Spring-Actuator", url = "http://localhost:8080/map")
public interface FeignConfigs {

	@GetMapping("gap")
	String getUser();

	@GetMapping("deep")
	String seUser();
}
