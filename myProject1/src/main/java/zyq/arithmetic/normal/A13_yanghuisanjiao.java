package zyq.arithmetic.normal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2023-01-09 15:34
 * Description
 * 示例 1:
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A13_yanghuisanjiao {
    /**
     * 1.循环
     * @param rowIndex
     * @return
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++){
            for(int j = 0; j<=i; j++){
                if(j == 0 || i==j){
                    list.add(1);
                }else{
                    // (1+i)*i/2
                    int a = (i + 1) * i / 2 - i - 1 + j;
                    int b = (i + 1) * i / 2 - i - 1 + j + 1;

                    list.add(list.get(a) + list.get(b));
                }
            }
        }
        int begin = (rowIndex + 2) * (rowIndex +1) / 2 - rowIndex -1;
        int end = (rowIndex + 2) * (rowIndex +1) / 2;
        return list.subList(begin,end);
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();


        return list;
    }

    public void recursion(int[][] a, int rowIndex){

    }

        public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(Arrays.toString(row.toArray()));
    }
}
