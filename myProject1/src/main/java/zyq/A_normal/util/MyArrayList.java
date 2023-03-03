package zyq.A_normal.util;

import java.util.ArrayList;

/**
 * @author yanqing.zou
 * @date 2023-03-02 14:18
 * Description
 */
public class MyArrayList<E> extends ArrayList<E> {

    public MyArrayList<E> myAdd(E e) {
        String eStr = e.toString();
        for (String s : eStr.split(",")) {
            super.add((E)s);
        }
        return this;
    }

}
