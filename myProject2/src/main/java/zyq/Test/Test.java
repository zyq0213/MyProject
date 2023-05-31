package zyq.Test;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-03-20 17:37
 * Description
 */
public class Test {

    public static void main(String[] args) {

     /*   Map<String,Integer> map = new TreeMap<String,Integer>();
        map.put("d",4);
        map.put("a",1);
        map.put("e",5);
        map.put("c",3);
        map.put("b",2);
        System.out.println(JSON.toJSONString(map));
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        System.out.println(JSON.toJSONString(map));
*/

        /*Map<String, Integer> maps = new TreeMap<String, Integer>();
        maps.put("zhangsan", 22);
        maps.put("lisi", 24);
        maps.put("wangwu", 18);
        maps.put("zhaoliu", 22);

        //自定义比较器
        Comparator<Map.Entry<String, Integer>> valCmp = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue()-o1.getValue();  // 降序排序，如果想升序就反过来
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(maps.entrySet());
        Collections.sort(list,valCmp); // 注意此处Collections 是java.util包下面的,传入List和自定义的valCmp比较器*/



    }
}
