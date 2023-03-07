package zyq.designmode.$2_factorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-07 17:07
 * Description
 */
public abstract class AbstractFactory {
    /**
     * 生产水果
     * @return
     */
    public abstract Fruit[] productFruit (Class...clazz) throws InstantiationException,IllegalAccessException ;


    /**
     * 生产饮料
     * @return
     */
    public abstract Drink[] productDrink(Object...obj);

}
