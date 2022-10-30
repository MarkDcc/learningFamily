package com.gordon.springboot.exception;

/**
 * @author dongchen
 * @Data 2022/10/4
 * @Time 17:55
 */
public class MyException extends Exception{

    public MyException(String message, Throwable cause){
        super(message, cause);
    }
}
