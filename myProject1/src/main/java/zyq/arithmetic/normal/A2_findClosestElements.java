package zyq.arithmetic.normal;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2022-08-25 16:24
 * Description
 */
public class A2_findClosestElements {

    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(i,Math.abs(arr[i] - x));
        }
        while (k>0){
            Integer minKey = null;
            Integer minValue = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
               if(minKey == null
                       || entry.getValue() < minValue
                       || (entry.getValue().intValue() == minValue.intValue() && entry.getKey() < minKey)){
                   minKey = entry.getKey();
                   minValue = entry.getValue();
               }

            }
            list.add(arr[minKey]);
            map.remove(minKey);
            k--;
        }
        Collections.sort(list);

        return list;
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

        public static void main(String[] args) {
        List<Integer> closestElements = findClosestElements1(new int[]{1, 3, 7, 13, 1}, 2, 3);
        System.out.println(JSON.toJSONString(closestElements));
    }

}
