package zyq.arithmetic.normal;

/**
 * @author yanqing.zou
 * @date 2023-01-05 17:45
 * Description
 *
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 */
public class A12_isPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        long num = 1;
        while (num <= n){
            if(num == n){
                return true;
            }
            num = num * 2;
        }
        return false;
    }

    public static boolean isPowerOfTwo1(int n) {
        while (true){
            if(n == 1){
                return true;
            }
            if(n%2 != 0 || n == 0){
                return false;
            }
            n = n/2;
        }
    }

    // 递归
    public static boolean isPowerOfTwo2(int n){
        if(n == 1){
            return true;
        }
        if(n == 0){
            return false;
        }
        boolean b = isPowerOfTwo2(n/2);
        if(!b){
            return false;
        }
        return n%2 == 0;
    }

    // 位运算
    public static boolean isPowerOfTwo3(int n) {
        // n 右移一位 和 1 与运算，一定是等于0的
        if( n ==0 ||((n & 1) != 0 && n !=1)){
            return false;
        }
        return isPowerOfTwo3(n >> 1) || n == 1;

    }

    public static boolean isPowerOfTwo4(int n) {
        return n > 0 && ((n&(n-1))==0);
    }


        public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo3(2);
        System.out.println(powerOfTwo);
    }

}
