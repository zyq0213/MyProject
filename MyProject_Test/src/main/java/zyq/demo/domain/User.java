package zyq.demo.domain;

import lombok.*;

/**
 * @author yanqing.zou
 * @date 2022-08-04 10:34
 * Description
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;

    private Character sex;
}
