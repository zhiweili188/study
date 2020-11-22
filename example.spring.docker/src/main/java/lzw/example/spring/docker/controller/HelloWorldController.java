package lzw.example.spring.docker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

	@Value("${app.version}")
	private String appVersion;
    
	@GetMapping("/api/health")
	public void checkHealth() {
		LOGGER.info("#############health#########");
	}
	
	@GetMapping("/hello")
	public String hello() {
		LOGGER.info("HELLO WORLD,appversion:"+appVersion);
		return "hello ,how are you?";
	}
}
