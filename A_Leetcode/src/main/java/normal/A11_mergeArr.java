package normal;

import java.util.Arrays;

/**
 * @author yanqing.zou
 * @date 2023-01-04 16:09
 * Description 合并数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A11_mergeArr {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums = new int[m + n];
        int numsIndex1 = 0;
        int numsIndex2 = 0;
        while (numsIndex1 != m || numsIndex2 != n) {
            if (numsIndex1 == m) {
                tempNums[numsIndex1 + numsIndex2++] = nums2[numsIndex2 - 1];
            } else if (numsIndex2 == n) {
                tempNums[numsIndex2 + numsIndex1++] = nums1[numsIndex1 - 1];
            } else {
                if (nums1[numsIndex1] <= nums2[numsIndex2]) {
                    tempNums[numsIndex2 + numsIndex1++] = nums1[numsIndex1 - 1];
                } else if (nums1[numsIndex1] >= nums2[numsIndex2]) {
                    tempNums[numsIndex1 + numsIndex2++] = nums2[numsIndex2 - 1];
                }
            }
        }
        nums1 = tempNums;
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);
    }


}
