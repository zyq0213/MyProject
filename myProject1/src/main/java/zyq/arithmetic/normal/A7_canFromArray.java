package zyq.arithmetic.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanqing.zou
 * @date 2022-09-22 15:35
 * Description
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，
 * 其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A7_canFromArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        for (int i = 0; i < pieces.length; i++) {
            int preIndex = 0;
            int curIndex = 0;
            for (int j = 0; j < pieces[i].length; j++) {
                //寻找arr存不存在
                if (!map.containsValue(pieces[i][j])) {
                    return false;
                }
                //判断连续情况
                if (j > 0) {
                    int preNum = pieces[i][j - 1];
                    int curNum = pieces[i][j];
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if(entry.getValue() == preNum){
                            preIndex = entry.getKey();
                            continue;
                        }
                        if(entry.getValue() == curNum){
                            curIndex = entry.getKey();
                            continue;
                        }
                        if(preIndex != 0 && curIndex != 0){
                            break;
                        }
                    }
                    if(preIndex+1 != curIndex ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        A7_canFromArray a = new A7_canFromArray();
        boolean b = a.canFormArray(new int[]{1,2,3,4}, new int[][]{{3}, {1,4}, {2}});
        System.out.println(b);
    }
}
