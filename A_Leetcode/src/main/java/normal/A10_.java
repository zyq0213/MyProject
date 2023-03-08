package normal;

/**
 * @author yanqing.zou
 * @date 2023-01-03 17:16
 * Description  检查句子中的数字是否递增
 *
 * 输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * 输出：true
 * 解释：句子中的数字是：1, 3, 4, 6, 12 。
 * 这些数字是按从左到右严格递增的 1 < 3 < 4 < 6 < 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A10_ {
    public static boolean areNumbersAscending(String s) {
        Integer indexValue = null;
        int preValue = 0;
        for(int i = 0; i < s.length(); i++){
            Integer value;
            try {
                 value = Integer.parseInt(Character.toString(s.charAt(i)));
                 indexValue = Integer.parseInt((indexValue==null?"":indexValue.toString())+value);
                 if(i == s.length()-1  && indexValue <= preValue){
                     return false;
                 }
            }catch (Exception e){
               if(indexValue != null && indexValue <= preValue){
                   return false;
               }
               if(indexValue != null) {
                   preValue = indexValue;
               }
               indexValue = null;
               continue;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "5 x 5";
        boolean b = areNumbersAscending(s);
        System.out.println(b);
    }
}
