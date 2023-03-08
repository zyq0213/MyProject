package dynamicDesign;

/**
 * @author yanqing.zou
 * @date 2022-11-01 15:16
 * Description
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class A2_jump {
    /**
     * 从尾部开始，遍历一次数组，每次找到能一次到达尾部的最靠近首部的值
     * 时间复杂度o(n²)
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int times = 0;
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            //遍历全部寻找能一次到达的
            int tempIndex = index;
            for (int j = index - 1; j >= 0; j--) {
                if (j + nums[j] >= tempIndex) {
                    index = j;
                }
            }
            times++;
            System.out.print(index + "-->");
            //判断是否最终index到了数组首端
            if (index == 0) {
                break;
            }
        }
        System.out.println();
        return times;
    }

    /**
     * 从首部开始，寻找本次跳跃和第二次跳跃能到的最远的地方
     * @param nums {2, 3, 0, 1, 4}
     * @return
     */
    public static int jump1(int[] nums) {
        int times = 0;
        int index = 0;
        int tempIndex = 0;

        for(int i = index;i<nums.length;i++){
            if(index + nums[index]>= nums.length -1){
                times++;
                return times;
            }
            int tempValue = 0;
            for(int j = index+1;j <= index+nums[index];j++){
                if(j+nums[j] > tempValue){
                    tempValue = j+ nums[j];
                    tempIndex = j;
                }
            }
            times ++;
            index = tempIndex;
        }

        return times;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(jump1(a)+"次");
    }
}
