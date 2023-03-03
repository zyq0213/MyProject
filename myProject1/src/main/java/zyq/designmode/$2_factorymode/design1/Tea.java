package zyq.designmode.$2_factorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-07 17:09
 * Description
 */
public class Tea implements Drink{

    public Tea(){
        System.out.println("product tea");
    }

    /**
     * 生产饮料
     * @return
     */
    @Override
    public Drink product() {
        return new Tea();
    }
}
