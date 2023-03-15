package zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yanqing.zou
 * @date 2022-08-17 11:22
 * Description
 */
@SpringBootApplication(scanBasePackages = "zyq")
public class Application {

    public static void main(String[] args){
        System.out.println("myProject2 Application is start running.........");
        SpringApplication.run(Application.class, args);
        System.out.println("myProject2 Application is running.........");

    }







}
