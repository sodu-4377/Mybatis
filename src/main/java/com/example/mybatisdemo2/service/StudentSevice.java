package com.example.mybatisdemo2.service;


import com.example.mybatisdemo2.domain.Student;

import java.util.List;

public interface StudentSevice {
    public Student select(String id);
    public void insert(Student stu);

    List<Student> getAll();
}
