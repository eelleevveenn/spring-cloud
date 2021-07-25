package com.eleven.test.controller;

import com.alibaba.fastjson.JSON;
import com.eleven.test.entity.Test;
import com.eleven.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/query")
    public String query () {
        Test test = new Test("a","b","c","d","e");
        return JSON.toJSONString(List.of(test));
    }

    @GetMapping("/find/all")
    public String findAll() {
        return JSON.toJSONString(testService.findAll());
    }

}
