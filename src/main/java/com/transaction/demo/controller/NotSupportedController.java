package com.transaction.demo.controller;

import com.transaction.demo.service.notsupported.NotSupportedClassA;
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
@RequestMapping("/ns")
public class NotSupportedController {

    @Autowired
    private NotSupportedClassA notSupportedClassA;


    @GetMapping("/method1")
    public void method1() {
        notSupportedClassA.method1();
    }

    @GetMapping("/method2")
    public void method2() {
        notSupportedClassA.method2();
    }



}
