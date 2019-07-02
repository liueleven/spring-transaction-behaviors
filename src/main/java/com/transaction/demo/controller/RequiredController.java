package com.transaction.demo.controller;

import com.transaction.demo.service.required.ClassA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 一定要写注释啊
 * @date: 2019-06-24 13:01
 * @author: 十一
 */
@RestController
public class RequiredController {

    @Autowired
    private ClassA classA;


    @GetMapping("/method1")
    public void method1() {
        classA.method1();
    }

    @GetMapping("/method2")
    public void method2() {
        classA.method2();
    }

    /**
     * 不能在Transactional方法中捕获，这里可以捕获到
     */
    @GetMapping("/method3")
    public void method3() {
        try {
            classA.method1();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("<========================="+e.getMessage()+"=========================================");
        }
    }

}
