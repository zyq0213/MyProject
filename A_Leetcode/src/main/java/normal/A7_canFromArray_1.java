package normal;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2022-09-22 16:09
 * Description
 * @see A7_canFromArray
 */
public class A7_canFromArray_1 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        //通过栈方式
        Map<Integer, Deque<Integer>> map = new HashMap();
        for (int i = 0; i < pieces.length; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < pieces[i].length; j++) {
                deque.addFirst(pieces[i][j]);
            }
            map.put(pieces[i][0], deque);
        }
        for (int i = 0; i < arr.length;) {
            Deque<Integer> deque = map.get(arr[i]);
            if(deque==null){
                return false;
            }
            while (!deque.isEmpty()) {
                if(arr[i++] != deque.removeLast()){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = canFormArray(new int[]{1,2,3,4}, new int[][]{{4,3,2,1}});
        System.out.println(b);
    }

}
