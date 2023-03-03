package zyq.demo.demo1;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2022-05-20 11:08
 * Description
 */
public class Test4 {

    public static void main(String[]args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> deleteList = new ArrayList<>();
        deleteList.add(2);
        deleteList.add(3);

        List<Integer> tempList = new ArrayList<>();
        Collections.addAll(list,new Integer[list.size()]);
        Collections.copy(list,tempList);

        tempList.removeAll(deleteList);

        for (Integer integer : tempList) {
            System.out.println(integer);
        }
    }

}
