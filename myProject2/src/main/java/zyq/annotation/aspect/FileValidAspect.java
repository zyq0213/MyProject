package zyq.annotation.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import zyq.annotation.FileParam;
import zyq.annotation.FileValid;
import zyq.model.param.FileImportParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author yanqing.zou
 * @date 2023-02-16 17:17
 * Description
 */
@Component
@Aspect
@Slf4j
public class FileValidAspect {


    @Pointcut("@annotation(zyq.annotation.FileValid)")
    public void pointcut(){}

    @Around("pointcut()")
    public String around(ProceedingJoinPoint pjp){
        log.info("FileValid around is start............");

        Object[] args = pjp.getArgs();
        Optional<Object> first = Arrays.stream(args).filter(v -> v instanceof FileImportParam).findFirst();
        ObjectMapper objectMapper = new ObjectMapper();
        FileImportParam fileImportParam = objectMapper.convertValue(first.get(), FileImportParam.class);
        String param = fileImportParam.getFileName();

        String[] split = param.split("\\.");
        if(split.length != 2){
            return "传入的file["+param+"]文件格式有误";
        }
        String fileType = split[1];
        // 方法
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        FileValid annotation = method.getAnnotation(FileValid.class);
        log.info("methodName is {},annotation is {}",method.getName(), annotation.toString());
        for (Parameter parameter : method.getParameters()) {
            String[] suffixs = parameter.getAnnotation(FileParam.class).suffix();
            log.info("file suffixs is {}",suffixs);
            boolean b = Arrays.stream(suffixs).anyMatch(v -> v.equals(fileType));
            if(!b){
                String suffixStr = Arrays.asList(suffixs).toString();
                return param+"传入的fileType["+fileType+"]文件后缀不支持，支持的格式为:"+suffixStr;
            }
        }

        return param;
    }

}
