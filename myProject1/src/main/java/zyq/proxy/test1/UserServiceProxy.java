package zyq.proxy.test1;

import java.util.Date;

/**
 * @author yanqing.zou
 * @date 2023-04-12 17:31
 * Description
 */
public class UserServiceProxy implements UserService{

    private UserService proxy;

    public UserServiceProxy(UserService proxy){
        this.proxy = proxy;
    }

    @Override
    public void select() {
        before();
        proxy.select();
    }

    @Override
    public void update() {
        before();
        proxy.update();
    }

    public void before(){
        System.out.println("Time:"+new Date());
    }

}
