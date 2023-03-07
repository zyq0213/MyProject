package zyq.demo.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanqing.zou
 * @date 2022-08-17 16:26
 * Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;

    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
