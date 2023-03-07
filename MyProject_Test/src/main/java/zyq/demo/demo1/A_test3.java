package zyq.demo.demo1;

/**
 * @author yanqing.zou
 * @date 2023-01-13 13:54
 * Description
 */
public class A_test3 {
    protected static int [][] bronzeConfigs = {
            {50,55000,0},
            {58,52490,0},
            {60,35000,0},
            {65,35120,0},
            {70,33210,0},
            {75,46300,0},
            {80,69380,0},
            {85,62470,0},
            {88,64320,0},
            {95,70640,0},
            {100,55050,0},
            {110,52410,0},
            {120,32270,0},
            {125,30000,0},
            {150,28050,0},
            {180,22130,0},
            {200,12500,0},
            {280,10000,0},
            {300,500,0},
            {1000,200,0},
            {0,136960,40001277,1},
            {0,20000,40001402,1},
            {0,72000,40001401,1},
            {0,1000,40001071,1},
            {0,3000,40001278,1}
    };

    public static void main(String[] args) {
        int sum = 0;
        for (int[] bronzeConfig : bronzeConfigs) {
            sum += bronzeConfig[1];
        }
        System.out.println(sum);
    }
}
