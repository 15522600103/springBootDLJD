package com.springboottest.controller;

import com.springboottest.model.Student;
import com.springboottest.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @PostMapping(value = "/add")
    public int addStudent(Student student){
        return studentService.addStudent(student);
    }

    @ResponseBody
    @PostMapping(value = "/updateById")
    public int updateStudentById(Student student){
        return studentService.updateStudent(student);
    }

    @ResponseBody
    @GetMapping(value = "/findAll")
    public Object findAllStudent(
        @RequestParam(name = "pageNum",required = false,defaultValue = "1")
        int pageNum,
        @RequestParam(name = "pageSize",required = false,defaultValue = "10")
        int pageSize){
        return studentService.findAllStudent(pageNum,pageSize);
    }

}
