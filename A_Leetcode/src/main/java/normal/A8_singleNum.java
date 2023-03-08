package normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanqing.zou
 * @date 2022-09-23 17:27
 * Description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A8_singleNum {
    public static int singleNum(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }


    public static int singleNum1(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            if(i == 0 ){
                if(nums[i] != nums[i+1]){
                    return nums[i];
                }else{
                    continue;
                }
            }

            if(i == nums.length-1){
                return nums[i];
            }
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    public static void main(String[] args){
        final int i = singleNum1(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }
}
