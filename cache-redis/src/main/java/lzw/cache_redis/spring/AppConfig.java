package lzw.cache_redis.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class AppConfig {

	@Bean(value="connectionFactory")
 	public JedisConnectionFactory jedisConnectionFactory() {
              JedisCluster jedis;
		
		        // 添加集群的服务节点Set集合
		        Set<String> hostAndPortsSet = new HashSet<String>();
		        // 添加节点
		        hostAndPortsSet.add("127.0.0.1:6379");
		       

		        // Jedis连接池配置
		        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		        // 最大空闲连接数, 默认8个
		        jedisPoolConfig.setMaxIdle(2);
		        // 最大连接数, 默认8个
		        jedisPoolConfig.setMaxTotal(2);
		        //最小空闲连接数, 默认0
		        jedisPoolConfig.setMinIdle(0);
		        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
		        jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
		        //对拿到的connection进行validateObject校验
		        jedisPoolConfig.setTestOnBorrow(true);
		        
		        
		        RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(hostAndPortsSet);
		    
		        RedisConnectionFactory pool = new JedisConnectionFactory(clusterConfig,jedisPoolConfig);
		/*pool.setHostName("127.0.0.1");
		pool.setPort(6379);*/
		
		return pool;
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate redis = new RedisTemplate();
		redis.setConnectionFactory(connectionFactory);
		return redis;
	}
	
	@Bean
	public MessageListenerAdapter messageListenerAdapter() {
		MessageListenerAdapter ada = new MessageListenerAdapter(new RedisMsgPubSubListener());
		
		return ada;
	}
	
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory,MessageListener adapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		Map< MessageListener, Collection<? extends Topic>> listeners = new HashMap<MessageListener, Collection<? extends Topic>>();
		List<Topic> list = new ArrayList<Topic>();
		list.add(new ChannelTopic("news.share"));
		list.add(new ChannelTopic("news.blog"));
		listeners.put(adapter, list);
		container.setMessageListeners(listeners);
		return container;
	}
}
