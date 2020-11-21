package com.xxxx.server.utils;


import com.xxxx.server.exception.MyException;

public class AssertUtil {

    public static void isTrue(boolean flag,String msg,Integer code)  {
        if (flag){
            throw new MyException(msg,code);
        }
    }
}
