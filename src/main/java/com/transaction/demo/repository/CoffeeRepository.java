package com.transaction.demo.repository;

import com.transaction.demo.model.Coffee;
import com.transaction.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 一定要写注释啊
 * @date: 2019-06-24 12:43
 * @author: 十一
 */
public interface CoffeeRepository extends JpaRepository<Coffee,Integer>{
}
