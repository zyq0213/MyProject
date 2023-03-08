package normal;


import com.alibaba.fastjson.JSON;

/**
 * @author yanqing.zou
 * @date 2022-09-19 11:25
 * Description  计数排序
 */
public class A3_countingSort {

    public static int[] countingSort(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
            if(i > max){
                max = i;
            }
        }
        int[] sort = new int[max - min + 1];
        for (int i = 0; i < a.length; i++){
            sort[a[i]-min]++;
        }
        int[] b = new int[a.length];
        int index = 0;
        for (int i =0 ; i<sort.length; i++) {
            while (sort[i]-->0){
                b[index++] = i+min;
            }
        }
        return b;
    }

    public static void main(String[] args){
        int[] a = new int[]{5, 2, 9, 6, 2, 5, 3, 6};
        int[] b = new int[]{10,9,8,7,6,5};
        int[] ints = countingSort(a);
        System.out.println(JSON.toJSONString(ints));
        System.out.println(new Integer(123).toString().substring(0,1));
    }
}
