package zyq.designmode.$1_staicfactorymode.design1;

import java.text.ParseException;

/**
 * @author yanqing.zou
 * @date 2022-04-01 17:02
 * Description
 */
public class FruitFactory {

    public FruitFactory(String fruitName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> aClass = Class.forName(FruitFactory.class.getPackage().getName() + "." + fruitName);
        Object obj = aClass.newInstance();
        if (obj instanceof Fruit) {
            Fruit fruit = (Fruit) obj;
            fruit.product();
        } else {
            System.out.println("please input an existing fruit!!!");
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
      /* try {
            FruitFactory fruitFactory = new FruitFactory("Orange");
            FruitFactory fruitFactory1 = new FruitFactory("Banana");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("can't find class");
        }
        System.out.println("**********************************************");*/
        Fruit fruit= (Fruit) new Banana();

    }


}
