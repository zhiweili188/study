package lzw.service.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String echo(String hello) {
		List<ServiceInstance> list = discoveryClient.getInstances("service-provider1");
		ServiceInstance service = null;
		if(list.size()>0) {
			service = list.get(0);
		} else {
			return "no service provider found.";
		}
		
		String url = service.getUri()+"/echo?hello="+hello;
		String result = restTemplate.getForObject(url, String.class);
		return "hello world,"+result;
	}
}
