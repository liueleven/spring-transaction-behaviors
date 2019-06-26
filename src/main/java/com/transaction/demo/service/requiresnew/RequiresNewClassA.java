package com.transaction.demo.service.requiresnew;

import com.transaction.demo.model.Coffee;
import com.transaction.demo.model.User;
import com.transaction.demo.repository.UserRepository;
import com.transaction.demo.service.required.ClassB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 测试事务的传播性
 *
 * 1. Propagation.REQUIRED
 * @date: 2019-06-24 12:42
 * @author: 十一
 */
@Service
public class RequiresNewClassA {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  RequiresNewClassB requiresNewClassB;

    /**
     * 在类A调用方法1（有@Transaction），同时调用类B方法1（无@Transaction）
     * 类B方法1抛异常，全部回滚
     * 事务传播特性是：REQUIRED，在一个事务的上下文中，都会回滚
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = RuntimeException.class)
    public void method1() {


        User user = new User();
        user.setName("十一");
        user = userRepository.save(user);
        System.out.println("<====================== user: " + user.toString());
        Coffee coffee = requiresNewClassB.method1();
        if (coffee.getId() > 0) {
            throw new RuntimeException("异常测试");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = RuntimeException.class)
    public void method2() {


        User user = new User();
        user.setName("十一");
        user = userRepository.save(user);
        System.out.println("<====================== user: " + user.toString());
        Coffee coffee = requiresNewClassB.method2();

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = RuntimeException.class)
    public void method3() {


        User user = new User();
        user.setName("十一");
        user = userRepository.save(user);
        System.out.println("<====================== user: " + user.toString());
        try {
            Coffee coffee = requiresNewClassB.method3();
        }catch (Exception e) {
            System.out.println("异常测试---捕获");
        }

    }
}
