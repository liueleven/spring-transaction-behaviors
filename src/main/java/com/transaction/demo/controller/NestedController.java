package com.transaction.demo.controller;

import com.transaction.demo.service.nested.NestedClassA;
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
@RequestMapping("/nested")
public class NestedController {

    @Autowired
    private NestedClassA nestedClassA;


    @GetMapping("/method1")
    public void method1() {
        nestedClassA.method1();
    }

    @GetMapping("/method2")
    public void method2() {
        nestedClassA.method2();
    }

    @GetMapping("/method3")
    public void method3() {
        nestedClassA.method3();
    }

    @GetMapping("/method4")
    public void method4() {
        nestedClassA.method4();
    }

    @GetMapping("/method5")
    public void method5() {
        nestedClassA.method5();
    }


}
