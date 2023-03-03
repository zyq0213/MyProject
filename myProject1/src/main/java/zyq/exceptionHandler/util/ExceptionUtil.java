package zyq.exceptionHandler.util;

/**
 * @author yanqing.zou
 * @date 2022-08-17 10:28
 * Description
 */
public class ExceptionUtil extends RuntimeException{

    String errorCode;

    public ExceptionUtil(String message){
        super(message);
    }


    public ExceptionUtil(String code, String message){
        super(message);
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
