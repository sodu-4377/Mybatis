package com.example.mybatisdemo2.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    //不让其他类new这个类，类中都是静态方法，可以直接调用。
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        //取得SQLSession对象
        String resource = "mybstis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
         sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }
    //
    private static ThreadLocal<SqlSession> t=new ThreadLocal<>();
    public static SqlSession getSession(){
        SqlSession session = t.get();
        if (session==null){
            session=sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }
    public static void myClose(SqlSession session){
        if(session!=null){
            session.close();

            //这句必须要，这次操作结束之后，强制剥离开，线程回到线程池中，等待下次操作被捞起。
            t.remove();
        }

    }
}
