package com.springboottest.dao;

import com.springboottest.model.Student;

import java.util.List;

public interface StudentDao {

    int insert(Student student);
    int update(Student student);
    List<Student> selectStudents();
}
