package zyq.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanqing.zou
 * @date 2022-09-13 16:40
 * Description
 */
@RestController
@RequestMapping("/filter")
public class TestController {

    @GetMapping("/test1")
    public String test1() throws InterruptedException{
        System.out.println("TestController.test1()");
        return "TestController.test1()";
    }
}
