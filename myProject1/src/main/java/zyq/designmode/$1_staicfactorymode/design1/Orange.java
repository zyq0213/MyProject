package zyq.designmode.$1_staicfactorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-01 17:00
 * Description
 */
public class Orange extends Fruit{

    public Orange(){
        System.out.println("product Orange");
    }

    /**
     * 生产对象
     */
    @Override
    public Orange product() {
        return new Orange();
    }
}
