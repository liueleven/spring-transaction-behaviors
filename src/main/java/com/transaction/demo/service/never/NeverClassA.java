package com.transaction.demo.service.never;

import com.transaction.demo.model.Coffee;
import com.transaction.demo.model.User;
import com.transaction.demo.repository.UserRepository;
import com.transaction.demo.service.supports.SupportClassB;
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
public class NeverClassA {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NeverClassB neverClassB;



    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    public void method1() {

        User user = new User();
        user.setName("十一");
        user = userRepository.save(user);
        System.out.println("<====================== user: " + user.toString());
        Coffee coffee = neverClassB.method1();


    }



}
