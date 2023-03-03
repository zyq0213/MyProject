package zyq.exceptionHandler.advice;

import com.alibaba.fastjson.JSON;
import zyq.exceptionHandler.util.ExceptionUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zyq.exceptionHandler.util.Result;

/**
 * @author yanqing.zou
 * @date 2022-08-17 10:23
 * Description
 */
@RestControllerAdvice
public class ExceptionAdvice{


    @ExceptionHandler(value = ExceptionUtil.class)
    public Result handlerIllegalArguments(ExceptionUtil e){
        Result result = new Result(e.getErrorCode(),e.getMessage());
        System.out.println(JSON.toJSONString(result));
        return result;
    }
}
