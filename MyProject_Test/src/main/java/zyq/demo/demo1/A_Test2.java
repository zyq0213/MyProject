package zyq.demo.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author yanqing.zou
 * @date 2022-11-07 14:03
 * Description
 */
public class A_Test2 {

    public boolean halvesAreAlike(String s) {
        int len1 = 0;
        int len2 = 0;
        s = s.toLowerCase();
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int length = s.length()/2;
        for(int i = 0; i<length;i++){
            int j = i+length;
            if(list.contains(s.charAt(i))){
                len1++;
            }
            if(list.contains(s.charAt(j))){
                len2++;
            }
        }

        return len1 == len2;
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize){
        int count = 0;
        int tempSize = 0;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int[] boxType : boxTypes) {
            if(map.containsKey(boxType[1])){
                map.put(boxType[1],map.get(boxType[1])+boxType[0]);
            }else{
                map.put(boxType[1],boxType[0]);
                list.add(boxType[1]);
            }
        }
        Collections.sort(list,(a,b)->b-a);
        for (Integer size : list) {
            if(tempSize+map.get(size)<truckSize){
                tempSize += map.get(size);
                count += size * map.get(size);
            }else{
                count += size * (truckSize-tempSize);
                break;
            }
        }

        return count;
    }

    public static int maximumUnits1(int[][] boxTypes, int truckSize) {
        int count = 0;
        int tempSize = 0;
        Arrays.sort(boxTypes,(a,b)-> b[1]-a[1]);
        for (int[] boxType : boxTypes) {
            if(tempSize+boxType[0]<truckSize){
                tempSize += boxType[0];
                count += boxType[1] * boxType[0];
            }else{
                count += boxType[1] * (truckSize-tempSize);
                break;
            }
        }

        return count;
    }

        public static void main(String[] args) throws IOException {
            Consumer<Void> consumer = (t)->{
                System.out.println(1);
            };
            System.out.println(2);
            Consumer<Void> consumer1 = consumer.andThen((t) -> {
                System.out.println(3);
            });
            System.out.println(4);
            Consumer<Void> consumer2 = consumer1.andThen((t) -> {
                System.out.println(5);
            });
            consumer2.accept(null);
        }

}
