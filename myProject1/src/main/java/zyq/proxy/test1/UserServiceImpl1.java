package zyq.proxy.test1;

/**
 * @author yanqing.zou
 * @date 2023-04-12 17:29
 * Description
 */
public class UserServiceImpl1 implements UserService{


    @Override
    public void select() {
        System.out.println("userService select");
    }

    @Override
    public void update() {
        System.out.println("userService update");
    }
}
