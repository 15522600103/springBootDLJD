package com.springboottest.service.student.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboottest.dao.StudentDao;
import com.springboottest.model.Student;
import com.springboottest.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public int addStudent(Student student) {
        return studentDao.insert(student);
    }

    @Transactional
    @Override
    public int updateStudent(Student student) {
        return studentDao.update(student);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<Student> findAllStudent(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentDao.selectStudents();
        PageInfo result = new PageInfo(students);
        return result;
    }
}
