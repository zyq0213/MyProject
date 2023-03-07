package zyq.demo.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author yanqing.zou
 * @date 2022-04-14 09:38
 * Description
 */
public class Test2 {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"11");
        map.put(2,"22");

        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println("key:"+next.getKey() +",value:"+next.getValue());
        }
        System.out.println("********************************************");
        map.forEach((k,v)->{
            System.out.println("key:"+k+",value:"+v);
        });
        System.out.println("************");
        Integer a = null;
        System.out.println(a+"");

    }
}
