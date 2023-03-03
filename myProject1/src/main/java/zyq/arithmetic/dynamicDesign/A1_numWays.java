package zyq.arithmetic.dynamicDesign;

import java.math.BigDecimal;

/**
 * @author yanqing.zou
 * @date 2022-09-23 14:09
 * Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A1_numWays {
    public static int  numWays(int n){
        BigDecimal[] a = new BigDecimal[n];
        a[0] = new BigDecimal(1);
        a[1] = new BigDecimal(2);
        for(int i = 2;i< n ;i++){
            a[i] = a[i-1].add(a[i-2]);
        }
         BigDecimal remainder = a[n - 1].remainder(new BigDecimal(1000000007));
         return Integer.parseInt(remainder.toString());
    }

    public static int  numWays1(int n){
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for(int i = 2;i< n ;i++){
            a[i] = (a[i-1]+a[i-2])%1000000007;
        }
        return a[n-1];
    }

    public static int numWays2(int n){
        //斐波那契 f(n) = f(n-1)+f(n-2);
        if(n == 0){
            return 1;
        }
        int f0 = 1;
        int f1 = 2;
        for(int i =2;i < n;i++){
           f1 = f0+f1;
           f0 = f1-f0;
           f1 = f1%1000000007;
        }
        return f1;
    }

    public static void main(String[] args){
         int  i = numWays2(92);
        System.out.println(i);
    }
}
