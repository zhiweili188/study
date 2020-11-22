package lzw.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@GetMapping("/echo")
	public String echo(String hello) {
		return "hello world,"+hello;
	}
	
	@Value("${useLocalCache:false}")
    private boolean useLocalCache;

	@GetMapping("/testDynaConfig")
    public boolean get() {
        return useLocalCache;
    }
}
