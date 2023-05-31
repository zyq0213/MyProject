package zyq.proxy.test1;

/**
 * @author yanqing.zou
 * @date 2023-04-12 17:33
 * Description
 */
public class main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl1();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.select();
        userServiceProxy.update();
    }
}
