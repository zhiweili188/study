package lzw.cache_redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class SubRedis 
{
    public static void main( String[] args )
    {
    	 System.out.println("订阅者 ");
         Jedis jr = null;
         try {
             jr = new Jedis("127.0.0.1", 6379, 0);// redis服务地址和端口号
             RedisMessageListener sp = new RedisMessageListener();
             // jr客户端配置监听两个channel
             jr.subscribe(sp, "news.share", "news.blog");
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             if (jr != null) {
                 jr.disconnect();
             }
         }
    }
}
