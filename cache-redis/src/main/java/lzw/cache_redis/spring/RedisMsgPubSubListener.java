package lzw.cache_redis.spring;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;


public class RedisMsgPubSubListener implements MessageListener {

	public void onMessage(Message message, byte[] pattern) {
		System.out.println("onMessage="+message);

	}

}
