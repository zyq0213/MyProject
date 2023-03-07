package zyq.demo.demo1;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/**
 * @author yanqing.zou
 * @date 2022-05-26 15:12
 * Description
 */
public class ParamTest {

    static int i = 0;
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(test2(),1,1);

    }

    public static void test1() {
        String pattern = "[A-Z]+";
        String str = "ADDDRRWW";
        boolean matches = Pattern.matches(pattern, str);
        System.out.println(matches);
    }

    public static TimerTask test2() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test:"+i++);
            }
        };
        return timerTask;
    }

}
