package com.example.mybatisdemo2.service.impl;

import com.example.mybatisdemo2.dao.StudentDao;
import com.example.mybatisdemo2.domain.Student;
import com.example.mybatisdemo2.service.StudentSevice;
import com.example.mybatisdemo2.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentSevice {

  private StudentDao student = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student select(String id) {
        Student stu = student.select(id);
        return stu;
    }

    @Override
    public void insert(Student stu) {
        student.insert(stu);
    }

    @Override
    public List<Student> getAll() {
        List<Student> list= student.getAll();
        return list;
    }
}
