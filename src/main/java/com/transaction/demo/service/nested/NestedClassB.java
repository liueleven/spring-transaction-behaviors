package com.transaction.demo.service.nested;

import com.transaction.demo.model.Coffee;
import com.transaction.demo.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 一定要写注释啊
 * @date: 2019-06-24 12:42
 * @author: 十一
 */
@Service
public class NestedClassB {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
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


}
