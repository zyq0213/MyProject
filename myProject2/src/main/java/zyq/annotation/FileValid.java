package zyq.annotation;

import java.lang.annotation.*;

/**
 * @author yanqing.zou
 * @date 2023-02-16 09:56
 * Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileValid {
}
