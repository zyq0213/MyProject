package zyq.redis.redis1;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

/**
 * @author yanqing.zou
 * @date 2022-05-11 17:57
 * Description
 */
public class BigKeyTest {
    public static void main(String []args){
        Jedis jedis = new Jedis("localhost", 6379);
        String key = "list_big_key";
        /*for(int i = 0;i<10000000;i++){
            jedis.lpush(key, String.valueOf(i));
        }*/

        System.out.println(JSON.toJSONString(jedis.lrange(key,0,-1),true));
    }
}
