package zyq.A_normal.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * @author yanqing.zou
 * @date 2022-11-11 14:52
 * Description
 */
public class IntSummaryStatistics {
    public static void test1(){
        Double[] d = new Double[]{1.2,2.1,5.2,4.8,3.9};
        DoubleSummaryStatistics collect = Arrays.stream(d).collect(Collectors.toList()).stream().collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("avg:"+collect.getAverage());
        System.out.println("count:"+collect.getCount());
        System.out.println("sum:"+collect.getSum());
        System.out.println("max:"+collect.getMax());
        System.out.println("min:"+collect.getMin());
    }

    public static void main(String[] args) {
        test1();
    }
}
