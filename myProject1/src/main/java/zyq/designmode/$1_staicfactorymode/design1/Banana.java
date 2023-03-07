package zyq.designmode.$1_staicfactorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-01 16:59
 * Description
 */
public class Banana extends Fruit{

    public Banana(){
        System.out.println("product banana");

    }

    /**
     * 生产对象
     */
    @Override
    public Banana product() {
        return new Banana();
    }

}
