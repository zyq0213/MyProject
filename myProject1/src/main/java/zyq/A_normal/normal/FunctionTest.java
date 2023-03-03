package zyq.A_normal.normal;

import java.util.function.Function;

/**
 * @author yanqing.zou
 * @date 2022-11-14 11:29
 * Description
 */
public class FunctionTest {
    public static int testFunction(int i, Function<Integer, Integer> function){
        return function.apply(i);
    }

    public static void main(String[] args) {
        System.out.println(testFunction(2,integer -> integer*2+1));
    }
}
