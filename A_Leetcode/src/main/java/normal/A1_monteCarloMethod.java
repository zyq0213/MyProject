package normal;

import java.util.Random;

/**
 * @author yanqing.zou
 * @date 2022-04-13 17:36
 * Description 蒙特卡洛算法
 * 计算一个不规则图形的面积，把这个图形放在一个正方形里面，然后在正方形里面随机出现小点，最后计算不规则图形小点数量和正方形数量的对比
 */
public class A1_monteCarloMethod {

    //两个正方形
    public static void square(long time){
        int x1 = 4;
        int x2 = 2;
        double calculate = calculate(x1, x2,time);
        System.out.println(calculate);
    }
    public static double calculate(int x1,int x2,long time){
        Random random = new Random();
        int hit = 0;
        for(int i =0;i<time;i++){
            double x = random.nextDouble() * 4;
            double y = random.nextDouble() * 4;
            if(x <= 2 || y <= 2){
                hit++;
            }
        }
        return Math.pow(x1, 2) * hit / time;
    }

    public static void main(String[] args){
        A1_monteCarloMethod.square(10000000);
    }

}
