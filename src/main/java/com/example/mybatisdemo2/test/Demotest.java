package com.example.mybatisdemo2.test;

import com.example.mybatisdemo2.domain.Student;
import com.example.mybatisdemo2.service.impl.StudentServiceImpl;
import com.example.mybatisdemo2.service.StudentSevice;
import com.example.mybatisdemo2.util.ServiceFactory;

import java.util.List;


public class Demotest {
    public static void main(String[] args) {

        StudentSevice sevice =  (StudentSevice) ServiceFactory.getService(new StudentServiceImpl());
        //插入、修改、删除都需要走事务
     //   Student student=new Student("A005","cxk",28);
//        sevice.insert(student);

//        Student student1 = sevice.select("A002");
//        System.out.println(student1);

        List<Student> list=sevice.getAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
