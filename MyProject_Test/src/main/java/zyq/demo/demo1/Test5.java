package zyq.demo.demo1;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-08-01 15:49
 * Description
 */
public class Test5 {
    Integer userId = 1;

    public static String test(){
        Test5 test5 = new Test5();
        Field[] fields = test5.getClass().getDeclaredFields();
        return JSON.toJSONString(fields);

    }

    /**
     * 复制列表
     */
    public static <T> List<T> copyList(List<? super T> resource, Class<? extends T> clazz){
        List<T>  list = new ArrayList<>();
        try {
            T t = clazz.newInstance();
            resource.forEach(v->{
                BeanUtils.copyProperties(v,t);
                list.add(t);
            });
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    return list;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        /*System.out.println(test());
        System.out.println("*************");
        System.out.println(test().indexOf("userId"));*/
        /*User user = new User("zyq", 18, '男');
        //对象转JSON字符串
        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        //JSON转对象
        User user1 = JSONObject.parseObject(s,User.class);
        System.out.println(user1);*/

        List<User> list = new ArrayList<>();
        list.add(new User("a",1));
        list.add(new User("b",2));
        List<User> list1 = new ArrayList<>();
        Test5.copyList(list, User.class);
        System.out.println(JSON.toJSONString(list));
        System.out.println("*************");
        System.out.println(JSON.toJSONString(list1));



    }
}
