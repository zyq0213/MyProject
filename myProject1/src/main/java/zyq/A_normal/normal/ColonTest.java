package zyq.A_normal.normal;

import com.alibaba.fastjson.JSON;
import zyq.A_normal.User;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yanqing.zou
 * @date 2022-11-14 10:08
 * Description
 */
public class ColonTest {
    public static class UserAgeComparator implements Comparator<User>{
        @Override
        public int compare(User user1, User user2) {
            return user1.getAge().compareTo(user2.getAge());
        }

        public static int compareAge(User a, User b){
            return a.getAge().compareTo(b.getAge());
        }

    }

    public static void main(String[] args) {
        User[] users = new User[]{new User("mzj",456),new User("jzw",789),new User("zyq",123)};
        Arrays.sort(users, (a,b)->b.getAge().compareTo(a.getAge()));
        System.out.println("users:"+JSON.toJSONString(users));

        User[] users1 = Arrays.copyOf(users,users.length);
        Arrays.sort(users1,new UserAgeComparator());
        System.out.println("users1:"+JSON.toJSONString(users1));

        User[] users2 = Arrays.copyOf(users,users.length);
        Arrays.sort(users2,(a,b)->UserAgeComparator.compareAge(b,a));
        System.out.println("user2"+JSON.toJSONString(users2));
    }
}
