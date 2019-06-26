package com.transaction.demo.controller;

import com.transaction.demo.service.mandatory.MandatoryClassA;
import com.transaction.demo.service.never.NeverClassA;
import com.transaction.demo.service.required.ClassA;
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
@RequestMapping("/never")
public class NeverController {

    @Autowired
    private NeverClassA neverClassA;


    @GetMapping("/method1")
    public void method1() {
        neverClassA.method1();
    }

}
