package zyq.designmode.$2_factorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-07 17:10
 * Description
 */
public class Coffee implements Drink{

    public Coffee(){
        System.out.println("product coffee");
    }
    /**
     * 生产饮料
     * @return
     */
    @Override
    public Drink product() {
        return new Coffee();
    }
}
