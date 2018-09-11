package com.major.demo.controller;

import com.major.demo.entiy.Resource;
import com.major.demo.entiy.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello() {
        return "hello spring boot";
    }


    @RequestMapping("/getResource")
    public Response getResource(){
        Resource bean = new Resource();
        // 属性拷贝
        BeanUtils.copyProperties(resource, bean);
        return Response.success(bean);
    }
}
