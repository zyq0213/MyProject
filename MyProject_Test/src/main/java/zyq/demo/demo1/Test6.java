package zyq.demo.demo1;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.cglib.core.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanqing.zou
 * @date 2022-08-24 17:21
 * Description
 */
public class Test6 {

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                Integer index = map.get(i);
                map.put(i, ++index);
            } else {
                map.put(i, 1);
            }
        }
        for (int j : target) {
            if (!map.containsKey(j)) {
                return false;
            } else {
                //判断次数
                Integer index = map.get(j);
                if (--index == 0) {
                    map.remove(j);
                    continue;
                }
                map.put(j, index);

            }
        }

        if (map.size() != 0) {
            return false;
        }

        return true;

    }

    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            a[index++] = nums[i];
            a[index++] = nums[i + n];
        }
        return a;
    }

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return 0;
        if(cost.length == 2) return Math.min(cost[0],cost[1]);

        Vector<Integer> dp = new Vector<>();
        dp.add(cost[0]);
        dp.add(cost[1]);

        for( int i = 2; i<cost.length ; i++){
            dp.add(Math.min(cost[i-1],cost[i-2])+cost[i]);
        }
        return Math.min(dp.get(cost.length-1),dp.get(cost.length-2));
    }


    public static void main(String[] args) {

        int i = minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(i);
    }
}
