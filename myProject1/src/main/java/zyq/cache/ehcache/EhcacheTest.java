package zyq.cache.ehcache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import zyq.model.entity.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author yanqing.zou
 * @date 2022-08-04 09:51
 * Description
 */
public class EhcacheTest {

    public static void main(String []args){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        CacheManager cacheManager = CacheManager.create(path+"\\myProject1\\src\\main\\resources\\ehcache.xml");
        Cache cache = cacheManager.getCache("EhcacheTest");
        Element element = new Element("zyq1", JSON.toJSON(new User("zyq1",1,'男')));
        cache.put(element);

        Element element1 = cache.get("zyq1");
        Object objectValue = element1.getObjectValue();
        System.out.println(JSONObject.parseObject(objectValue.toString(),User.class));


    }

}
