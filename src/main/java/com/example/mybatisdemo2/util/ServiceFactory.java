package com.example.mybatisdemo2.util;

public class ServiceFactory {
    //传递张三对象，得到李四对象的过程
    public static  Object getService(Object obj){
        return new TransactionInvocationHandler(obj).getProxy();
    }
}
