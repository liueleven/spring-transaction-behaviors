package com.transaction.demo.service.notsupported;

import com.transaction.demo.model.Coffee;
import com.transaction.demo.model.User;
import com.transaction.demo.repository.CoffeeRepository;
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
public class NotSupportedClassB {

    @Autowired
    private CoffeeRepository coffeeRepository;

    /**
     * 在类A调用方法1（有@Transaction），同时调用类B方法1（无@Transaction）
     * 类B方法1抛异常，全部回滚
     * 事务传播特性是：REQUIRED，在一个事务的上下文中，都会回滚
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = RuntimeException.class)
    public Coffee method1() {

        Coffee coffee = new Coffee();
        coffee.setName("卡布其诺");
        coffee.setPrice(38.8);
        coffee = coffeeRepository.save(coffee);
        System.out.println("<======================  coffee: " + coffee.toString());
        if(coffee.getId() > 0) {
            throw new RuntimeException("测试 propagation = Propagation.REQUIRED ");
        }
        return coffee;
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = RuntimeException.class)
    public Coffee method2() {

        Coffee coffee = new Coffee();
        coffee.setName("卡布其诺");
        coffee.setPrice(38.8);
        coffee = coffeeRepository.save(coffee);
        System.out.println("<======================  coffee: " + coffee.toString());
        if(coffee.getId() > 0) {
            throw new RuntimeException("测试 propagation = Propagation.REQUIRED ");
        }
        return coffee;
    }
}
