package zyq.demo.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanqing.zou
 * @date 2022-09-26 15:23
 * Description
 */
public class Test7 {
    public static boolean CheckPermutation(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            Character c = s1.charAt(i);
            map.put(c, map.get(c)== null?1:map.get(c)+1);
        }
        for(int j = 0 ;j<s2.length();j++){
             char c = s2.charAt(j);
             if(!map.containsKey(c)){
                 return false;
             }else{
                 if(map.get(c) <= 0){
                     return false;
                 }
                 map.put(c,map.get(c)-1);
             }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if(characterIntegerEntry.getValue() > 0){
                return false;
            }
        }

        return true;
    }

    private static final long count = 10000000000L;



    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0;i < count;i++){
                a += 5;
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            int b = 0;
            for (long i = 0; i < count; i++) {
                b--;
            }
        });
        thread1.start();
        thread.join();
        thread1.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time+"ms");
    }


    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
