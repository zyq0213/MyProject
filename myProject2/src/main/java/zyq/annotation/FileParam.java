package zyq.annotation;

import java.lang.annotation.*;

/**
 * @author yanqing.zou
 * @date 2023-02-15 17:18
 * Description
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileParam {
     String[] suffix() default {"doc","xls","txt"};

    int size() default 1024;
}
