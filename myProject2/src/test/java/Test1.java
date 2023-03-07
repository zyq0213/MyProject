import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zyq.controller.FileController;

import java.util.Arrays;
import java.util.List;

/**
 * @author yanqing.zou
 * @date 2023-02-16 15:30
 * Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = zyq.Application.class)
public class Test1 {

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);


    @Test
    public void test1(){
        Object[] a = new Object[]{"a","b","c"};
        StringBuilder sb = new StringBuilder();
        Arrays.stream(a).forEach(v->{
            sb.append(v);
        });
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Object[] a = new Object[]{"a","b","c"};
        String[] s= new String[]{"doc","xls","txt"};
        boolean b = Arrays.stream(s).anyMatch(v -> v == "xls");
        System.out.println(b);
    }

}
