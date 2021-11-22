package com.example.mybatisdemo2.dao;

import com.example.mybatisdemo2.domain.Student;
import com.example.mybatisdemo2.vo.StudenAndClassroom;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student select(String num);
    public void insert(Student stu);

    List<Student> getAll();

    List<Student> selectage(int i);


    List<Student> select2(Student student1);

    List<Student> selectmap(Map<String, Object> map);

    List<Student> selectcon(String b);

    List<Map<String, Object>> select3();

    List<Student> select17(Student stu);



    List<Student> select18(String[] strArr);

    List<Map<String, Object>> select20();

    List<StudenAndClassroom> select21();

    List<StudenAndClassroom> select22(String z);
}
