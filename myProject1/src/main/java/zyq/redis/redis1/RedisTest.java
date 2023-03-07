package zyq.redis.redis1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-08-29 10:14
 * Description
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        Transaction transaction = jedis.multi();
        try {
            transaction.set("test1", "test11");
            transaction.set("test2", "test22");
            transaction.set("test3", "test33");
            List<Object> exec = transaction.exec();
        }catch (Exception e){
            transaction.discard();
            System.out.println("catch exception");
        }
    }
}
