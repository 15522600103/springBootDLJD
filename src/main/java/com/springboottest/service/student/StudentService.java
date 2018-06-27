package com.springboottest.service.student;

import com.github.pagehelper.PageInfo;
import com.springboottest.model.Student;

public interface StudentService {

    int addStudent(Student student);

    int updateStudent(Student student);

    PageInfo<Student> findAllStudent(int pageNum,int pageSize);
}
