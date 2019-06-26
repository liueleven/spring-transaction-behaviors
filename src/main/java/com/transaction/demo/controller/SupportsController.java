package com.transaction.demo.controller;

import com.transaction.demo.service.supports.SupportClassA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 一定要写注释啊
 * @date: 2019-06-24 13:01
 * @author: 十一
 */
@RestController
@RequestMapping("/support")
public class SupportsController {

    @Autowired
    private SupportClassA supportClassA;


    @GetMapping("/method1")
    public void method1() {
        supportClassA.method1();
    }

    @GetMapping("/method2")
    public void method2() {
        supportClassA.method2();
    }

    @GetMapping("/method3")
    public void method3() {
        supportClassA.method3();
    }



}
