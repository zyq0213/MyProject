package character;

/**
 * @author yanqing.zou
 * @date 2022-09-21 10:18
 * Description
 *  2[a]2[bb]
 *  输出：aabbbb
 */
public class A1_ {

    public static String test(String str){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int startIndex = 0;
        int endIndex = 0;
        boolean reset = false;
        for(int i = 0; i < str.length();i++){
            if(reset){
                num = 0;
                endIndex = 0;
                reset = false;
            }
            if(str.charAt(i) == '['){
                String substring = str.substring(startIndex, i);
                num = Integer.parseInt(substring);
                startIndex = i;
            }
            if(str.charAt(i) == ']'){
                endIndex = i;
            }
            if(startIndex != 0 && endIndex != 0){
                String substring = str.substring(startIndex+1, endIndex);
                for(int j = 0; j < num ; j++){
                    sb.append(substring);
                }
                startIndex = endIndex+1;
                reset = true;
            }

        }
        return sb.toString();
    }
    public static void main(String []args){
        String str = "3[c]2[bb]";
        String test = test(str);
        System.out.println(test);
    }
}
