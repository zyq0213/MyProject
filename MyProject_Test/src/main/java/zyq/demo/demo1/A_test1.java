package zyq.demo.demo1;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanqing.zou
 * @date 2022-09-30 10:01
 * Description
 */
public class A_test1 {

    public static void main(String[] args) throws ParseException {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list.subList(0,3)));*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String format = sdf.format(new Date());
        System.out.println(format);*/

        /*Random random = new Random();
        int index = 20;
        while (index-->0){
            System.out.println(random.nextInt(3));
        }*/
        /*User user = new User();
        user.setName("a");
        user.setAge(1);
        User user1 = new User();
        user1.setName("b");
        user1.setAge(2);
        User user2 = new User();
        user2.setName("c");
        user2.setAge(3);
        User user3 = new User();
        user3.setName("d");
        user3.setAge(5);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        IntSummaryStatistics collect = list.stream().filter(v -> v.getAge() <= 4)
                .map(User::getAge).collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("max"+collect.getMax());
        System.out.println("avg"+collect.getAverage());*/
       /* SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date parse = sdf.parse("10:31");
        Date parse1 = sdf.parse(sdf.format(new Date()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        System.out.println(calendar.getTime());

        Calendar temp = Calendar.getInstance();
        temp.setTime(new Date());

        calendar.set(Calendar.YEAR,temp.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH,temp.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,temp.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime());*/

        /*System.out.println((10<<3)+(10<<0));

        //0000 1010
        //0101 0000
        System.out.println();*/
        /*int index = 1;
        for(int i =index;i>0;--i){
            System.out.println(i);
        }*/

       /* int[] a = new int[]{1,2};
        int index = 0;
        a[index++] = a[index-1];;
        System.out.println(Arrays.toString(a));
        System.out.println("*********index:"+index);*/
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);
        List<Integer> list1 = list.subList(0, 1);
        System.out.println(Arrays.toString(list1.toArray()));*/
        /*Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        Stack<Integer> stack1 = (Stack<Integer>)stack.clone();
        stack1.pop();
        stack1.pop();
        System.out.println(stack.peek());*/




    }
}
