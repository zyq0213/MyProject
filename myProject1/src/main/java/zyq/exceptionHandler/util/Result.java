package zyq.exceptionHandler.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanqing.zou
 * @date 2022-08-17 10:09
 * Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private String code;

    private Integer msg;

    private T data;


    public Result(String code, String message) {

    }

}
