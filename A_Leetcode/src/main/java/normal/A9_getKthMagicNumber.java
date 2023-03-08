package normal;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yanqing.zou
 * @date 2022-09-28 16:47
 * Description 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A9_getKthMagicNumber {
    public static int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        int index = 1;
        int num = 1;
        for (int i = 3; ; i++) {
            if ((i % 3 == 0 && i / 3 == 1) || (i % 5 == 0 && i / 5 == 1) || (i % 7 == 0 && i / 7 == 1)) {
                index++;
                num = i;
                if (index == k) {
                    return num;
                }
                continue;
            }
            if (i % 2 == 0) {
                continue;
            }
            if ((i % 3 == 0 && (i/3 == 3 || i/3 == 5 ||i/7 == 7 ))
                    || (i % 5 == 0&& (i/5 == 3 || i/5 == 5 ||i/5== 7 ))
                    || (i % 7 == 0 && (i/7 == 3 || i/7 == 5 ||i/7 == 7 ))) {
                index++;
                num = i;
            }
            if (index == k) {
                return num;
            }
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.WEEK_OF_YEAR,-100);
        calendar.set(Calendar.DAY_OF_WEEK,2);
        calendar.set(Calendar.HOUR_OF_DAY,19);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date time = calendar.getTime();
        System.out.println(time);

    }

}
