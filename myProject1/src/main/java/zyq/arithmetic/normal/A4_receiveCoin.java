package zyq.arithmetic.normal;

/**
 * @author yanqing.zou
 * @date 2022-09-19 17:01
 * Description
 * 国王将金币作为工资，发放给忠诚的骑士。第一天，骑士收到一枚金币；之后两天（第二天和第三天），每天收到两枚金币；之后三天（第四、五、六天），每天收到三枚金币；之后四天（第七、八、九、十天），每天收到四枚金币……；这种工资发放模式会一直这样延续下去：当连续N天每天收到N枚金币后，骑士会在之后的连续N+1天里，每天收到N+1枚金币。
 *
 * 请计算在前K天里，骑士一共获得了多少金币
 * ————————————————
 * 版权声明：本文为CSDN博主「鸟啼西山~」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_16964363/article/details/52260102
 */
public class A4_receiveCoin {

    public static int receiveCoin(int day) {
        int count = 0;
        int tempCoin = 1;
        int index = 1;
        for(int i = 1 ;i <= day;){
            while (index-- > 0){
                count += tempCoin;
                i++;
            }
            index=++tempCoin;
        }
        return count;
    }

    public static void main(String[] args){
        int day = 6;
        int i = receiveCoin(day);
        System.out.println(i);
    }
}

