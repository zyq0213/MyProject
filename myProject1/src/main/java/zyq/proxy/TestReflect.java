package zyq.proxy;

import com.fasterxml.jackson.databind.ser.std.NumberSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanqing.zou
 * @date 2022-07-20 11:21
 * Description
 */
public class TestReflect {
    public static void main(String[] args) throws Exception{
        //test1();
        User user = new User();
        get("zyq.proxy.User");
        System.out.println(User.class);
        /*String name = "zyq";
        Integer age = 18;
        String sex = "男";

        Map<String,Object> map = new HashMap<>() ;
        Map<String,Class> classMap = new HashMap<>();
        map.put("name",name);
        classMap.put("name",name.getClass());
        map.put("age",age);
        classMap.put("age",age.getClass());
        map.put("sex",sex);
        classMap.put("sex",sex.getClass());

        *//*Object set = setV2("zyq.thread.User", map , classMap);
        System.out.println(set.toString());*//*
        Class<?> aClass = Class.forName("zyq.thread.User");
        Method getName = aClass.getMethod("getName", new Class[]{});
        System.out.println(getName);*/
    }

    public static void test1(){
        try {
            Class<?> aClass = Class.forName("zyq.thread.User");
            Method[] methods = aClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++){
                String method = methods[i].getName();
                System.out.println("*****method:"+method);
                Class<?>[] parameterTypes = methods[i].getParameterTypes();
                for(int j = 0; j< parameterTypes.length; j++){
                    String parameter = parameterTypes[j].getName();
                    System.out.println("方法:"+method+",参数类型:"+parameter);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void get(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        User user = new User();
        user.setName("zyq");
        user.setAge(12);
        user.setSex("男");

        Class<? extends User> aClass1 = user.getClass();
        //Class<?> aClass = Class.forName(className);
        Method[] methods = aClass1.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.startsWith("get")){
                System.out.print("method:"+name+"\t");
                Object[] arguments = new Object[]{};

                Object invoke = method.invoke(aClass1.newInstance(), arguments);
                System.out.print("value:"+invoke+"\t");
                System.out.println();
            }
        }
    }

    public static Object set(String className, Map<String,Object> map) throws Exception{
        Class<?> aClass = Class.forName(className);
        Object returnObject = aClass.newInstance();
        Method[] methods = aClass.getDeclaredMethods();
        Map<String,Method> methodMap = new HashMap<>();
        for (Method method : methods) {
            methodMap.put(method.getName(),method);
        }

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            if(map.containsKey(name)){
                Object value = map.get(name);
                String setMethod = "set"+ name.substring(0,1).toUpperCase()+name.substring(1);
                if(!methodMap.containsKey(setMethod)){
                    System.out.println(String.format("方法 %s 对应的 methodMap 不存在该方法",setMethod));
                    continue;
                }
                Method method = methodMap.get(setMethod);
                Class<?>[] parameterTypes = method.getParameterTypes();
                /*String parameterType = parameterTypes[0].getName();
                Class<?> parameterClass = Class.forName(parameterType);*/
                Object[] arguments = new Object[]{value};
                method.invoke(returnObject, arguments);
            }
        }
        return returnObject;
    }

    public static Object setV2(String className, Map<String,Object> parameterMap, Map<String,Class> classMap) throws Exception{
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        Map<String,Field> map = new HashMap<>();
        for (Field declaredField : declaredFields) {
            map.put(declaredField.getName(),declaredField);
        }
        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String methodName= "set"+key.substring(0,1).toUpperCase()+key.substring(1);
            Method method = clazz.getMethod(methodName, classMap.get(key));
            method.invoke(obj, value);
        }
        return obj;
    }

}
