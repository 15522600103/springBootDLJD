package com.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    //http://localhost:8080/user/user/106/naxiaoxin    地址中有中文会报错
    @ResponseBody
    @PostMapping(value = "/userId/{id}/{name}")
    public Object userId(@PathVariable("id") Integer id,@PathVariable("name") String name){
        System.err.println(id+"----------"+name);
        return id;
    }

}
