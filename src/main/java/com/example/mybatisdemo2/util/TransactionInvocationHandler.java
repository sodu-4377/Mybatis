package com.example.mybatisdemo2.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 李四的表白方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;

        try {
            session=SqlSessionUtil.getSession();
            //处理业务逻辑
            /**
             * 张三的表白方法
             */
             obj = method.invoke(target, args);
             session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }
    public  Object getProxy(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }
}
