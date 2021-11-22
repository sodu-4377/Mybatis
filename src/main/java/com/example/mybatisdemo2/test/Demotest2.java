package com.example.mybatisdemo2.test;

import com.example.mybatisdemo2.dao.StudentDao;
import com.example.mybatisdemo2.domain.Student;
import com.example.mybatisdemo2.util.SqlSessionUtil;
import com.example.mybatisdemo2.vo.StudenAndClassroom;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demotest2 {
    public static void main(String[] args) {
        StudentDao session = SqlSessionUtil.getSession().getMapper(StudentDao.class);
        /**
         * parameterType 用于设置输入参数的Java类型
         * 简单数据类型和引用数据类型等 ，mybatis已经起好了别名。
         * String =string  大小写都可，
         * sql语句获取参数的值使用 #｛｝或者$｛｝
         */

//       1、
//        List<Student> li=session.selectage(24);
//        for (Student student : li) {
//            System.out.println(student);
//        }

        //     2、
        // 不可以为sql语句传递多个参数，如果要传递多个参数，
        // 应该封装到domain对象中传递，或者封装传递map集合
//   错误的写法     List<Student> s=session.select2("cxk",28);

//          3、
//        Student student1=new Student("","cxk",28);
//        List<Student> s=session.select2(student1);
//        for (Student student : s) {
//            System.out.println(student);
//        }

        //   4、
        // 用map传递参数,可以同时传递多个参数，
        // domain符合需求的话使用domain，不适合的话使用map，（多表联查使用map）
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","cxk");
//        map.put("age",28);
//        List<Student> si=session.selectmap(map);
//        for (Student student : si) {
//            System.out.println(student);
//        }


        /*
        *  #｛｝相当于preparedStatement ，可防止sql注入，${} 是createStatement  id=‘#｛value｝
        * #{}占位符，占的值的位置。      $｛｝拼接符，拼接字符串，
        * */


//        6、like 模糊查询，以后用的比较多。
        /**
         * 查询名字包含字母 b 的用户
         *1\ 可以再传递的时候  %b%   List<Student> stu=session.selectcon("%b%"); 一般不用
         *2\select * from tb_student where name like  '%' #{value} '%'  mysql中拼接字符串用空格
         */
//        List<Student> stu=session.selectcon("b");
//        for (Student student : stu) {
//            System.out.println(student);
//        }


        //resultType  基本数据类型
//         7\
        //返回map类型

   /*     List<Map<String,Object>> list= session.select3();
        for (Map<String, Object> map : list) {

            Set<String> strings = map.keySet();
            for (String string : strings) {
                System.out.print("key :"+string);
                System.out.println("  value :"+map.get(string));

            }
            System.out.println("-----------------------");

        }*/

        //8、
        // 当数据库字段名和domain的字段不一致，结果是 该字段为null ，如何解决？
        /**
         * 1、查询语句时候，给查询字段起别名，
         * 2、resultMap
         */

        /**
         * 动态sql
         */
        /*Student stu=new Student();
        stu.setAge(24);
        List<Student> sList=session.select17(stu);
        for (Student student : sList) {
            System.out.println(student);
        }*/

        /**
         * 9、
         * 动态sql  foreach标签
         * 可以接收数组
         * 前段给后端用数组，后端给前段用list
         */
       /* String[] strArr= {"A001","A002" ,"A003"};
        List<Student> stu=session.select18(strArr);
        for (Student student : stu) {
            System.out.println(student);
        }*/


        /*
        * 多表联查
        * 需要注意，map的key不可以重复，所以起名的时候需要注意不能重名
        * */
        /*List<Map<String,Object>> list=session.select20();
        for (Map<String, Object> map : list) {
            Set<String> strings = map.keySet();
            for (String string : strings) {
                System.out.println(" key ："+string);
                System.out.println(" value :"+map.get(string));
            }
        }*/


        /* VO （value Object）
        domain 不能满足的，使用  map 或者  vo解决
        vo 指的是创建一个类，这个类的属性完全是由我们自己定义的，属性会保存所有需要展示的信息
        vo：
            student
            classroom
         */
       /*List<StudenAndClassroom> sl= session.select21();
        for (StudenAndClassroom stu : sl) {
            System.out.println(stu);
        }*/


//      22\
        //加一个where,名字里边带有字母 z
       /* List<StudenAndClassroom> sl= session.select22("c");
        for (StudenAndClassroom stu : sl) {
            System.out.println(stu);
        }*/
        /**
         * 实际开发中如判断使用哪种 （map还是vo）?
         * 1、如果前段需求的重复率不高，使用map
         * 2、如果前段重复率较高，创建vo 类
         */
    }
}
