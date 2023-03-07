package zyq.designmode.$2_factorymode.design1;

/**
 * @author yanqing.zou
 * @date 2022-04-07 17:13
 * Description  多个具体工厂
 */
public class ProductFactory extends AbstractFactory {
    /**
     * 生产水果
     *
     * @return
     */
    @Override
    public Fruit[] productFruit(Class...clazz)throws InstantiationException,IllegalAccessException {
        if(clazz == null || clazz.length==0){
            return null;
        }
        Fruit[] fruits = new Fruit[clazz.length];
        int index =0;
        for (Class aClass : clazz) {
            Fruit fruit ;
            try {
                fruit = (Fruit) aClass.newInstance();
                fruits[index++] = fruit;
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
        return fruits;
    }


    /**
     * 生产饮料
     *
     * @return
     */
    @Override
    public Drink[] productDrink(Object...obj) {
        return null;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ProductFactory productFactory = new ProductFactory();
        Fruit[] fruits = productFactory.productFruit(Banana.class, Orange.class);
        System.out.println(fruits);
        System.out.println("*******");
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

}
