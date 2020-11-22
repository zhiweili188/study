package lzw.cache_redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class PubRedis 
{
    public static void main( String[] args )
    {
        
        System.out.println("发布者 ");
        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 0);// redis服务地址和端口号
            // jr客户端配置监听两个channel
            jr.publish( "news.share", "新闻分享");
            jr.publish( "news.blog", "新闻博客");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }
}
