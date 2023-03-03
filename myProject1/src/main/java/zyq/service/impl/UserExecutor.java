package zyq.service.impl;

import org.springframework.stereotype.Component;
import zyq.service.Executor;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yanqing.zou
 * @date 2023-02-08 10:30
 * Description
 */
@Component
public class UserExecutor extends Thread implements Executor {

    @Override
    public void run() {
        System.out.println("userExecutor is running...............");
    }

    @Override
    @PostConstruct
    public void execute() {
        System.out.println("userExecutor execute is running.............................");
        this.start();
    }

}
