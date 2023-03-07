package zyq.proxy;

import java.lang.reflect.Field;

/**
 * @author yanqing.zou
 * @date 2022-12-09 10:46
 * Description
 */
public class Test {
    public static void main(String[] args) {
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();

    }
}
