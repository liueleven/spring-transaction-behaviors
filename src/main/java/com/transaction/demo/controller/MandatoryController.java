package com.transaction.demo.controller;

import com.transaction.demo.service.mandatory.MandatoryClassA;
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
@RequestMapping("/man")
public class MandatoryController {

    @Autowired
    private MandatoryClassA mandatoryClassA;


    @GetMapping("/method1")
    public void method1() {
        mandatoryClassA.method1();
    }

    @GetMapping("/method2")
    public void method2() {
        mandatoryClassA.method2();
    }

    @GetMapping("/method3")
    public void method3() {
        mandatoryClassA.method3();
    }

    @GetMapping("/method4")
    public void method4() {
        mandatoryClassA.method4();
    }

}
