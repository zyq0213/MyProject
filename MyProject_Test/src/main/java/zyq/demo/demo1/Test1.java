package zyq.demo.demo1;


import zyq.demo.domain.TestDTO;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2022-04-11 14:17
 * Description
 */
public class Test1 {

    public void test() {
        InterfaceExample com =  Test1::new;
        Test1 bean = com.create();
        System.out.println(bean);
    }

}

interface InterfaceExample{
    Test1 create();
}
