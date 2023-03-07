package myProject1.exceptionHandler;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zyq.filter.TestController;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yanqing.zou
 * @date 2022-08-17 11:11
 * Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = zyq.Application.class)
public class TestControllerTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestControllerTest.class);

    @Autowired
    TestController testController;

    @Test
    public void test(){
        System.out.println(1);
    }

    @Test
    public void test1(){
        //testController.exceptionTest1(null, null);
    }

    @Test
    public void test2(){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        map.put(1,11);
        map.put(2,22);
        System.out.println(JSON.toJSONString(map));
        map.remove(1,11);
        System.out.println("*******");
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.size());
    }

    @Test
    public void test01(){
        //日志输出
        LOGGER.error("error");
        LOGGER.warn("wring");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trance");

        //占位符输出
        String name = "bysen";
        Integer age = 24;
        LOGGER.info("姓名{}，年龄{}",name,age);

        //异常处理
        try{
            int i =1/0;
        }catch (Exception e){
            LOGGER.error("发生异常：",e);
        }
    }

    public static void main(String[] args) {

    }


}
