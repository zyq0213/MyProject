package normal;

import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;

/**
 * @author yanqing.zou
 * @date 2022-09-20 09:55
 * Description 求最长回文子串
 * a c d b b d a a
 */
public class A6_longestPalindrome {
    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if(s.length()==1){
            return String.valueOf(s.charAt(0));
        }
        int left;
        int right;
        int len;
        int maxStart = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            len = 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            //  b b b a b
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static void main(String[] args) {
        String aaabaac = longestPalindrome1("a");
        System.out.println(aaabaac);

    }

}
