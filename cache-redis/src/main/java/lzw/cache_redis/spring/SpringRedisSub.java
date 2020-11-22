package lzw.cache_redis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringRedisSub {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("lzw.cache_redis.spring");

		RedisTemplate redisTemplate = (RedisTemplate)ctx.getBean(RedisTemplate.class);
       System.out.print(redisTemplate == null);
      
	}

}
