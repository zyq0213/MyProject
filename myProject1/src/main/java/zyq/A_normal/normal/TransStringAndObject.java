package zyq.A_normal.normal;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import zyq.A_normal.util.MyArrayList;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2023-03-02 09:57
 * Description transition String and Object
 */
public class TransStringAndObject {
        static User user = new User("zyq",18,new MyArrayList<String>().myAdd("123,456,789"));
        static String userStr = "{\"age\":18,\"hobby\":[\"123\",\"456\",\"789\"],\"name\":\"zyq\"}";

    public static void main(String[] args) {
      ObjectToString();
      StringToObject();
    }



    public static void ObjectToString(){
        String str = JSONObject.toJSONString(user);
        System.out.println("ObjectToString is:"+str);
    }

    public static void StringToObject(){
        User user = (User)JSONObject.parseObject(userStr, User.class);
        System.out.println("StringToObject is:"+user);
    }


    @Data
    @AllArgsConstructor
    static class User{
        private String name;
        private Integer age;
        private List<String> hobby;

    }

}
