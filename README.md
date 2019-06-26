# 说明

使用jpa简化CRUD，每次重启就会清除数据，需要创建数据库：test


---

# Spring-Transaction事务传播特性

Spring提供了7中事务传播行为，用来控制多个方法相互调用的事务边界

本文的调用发是methodA，被调用方是methodB






### REQUIRED
默认的传播行为

方法B的事务传播特性是REQUIRED，方法A有事务，方法A调用方法B，
方法B不开启事务

方法B抛异常，方法A、B全部回滚

方法B抛异常，方法A捕获，会抛异常，全部回滚

### SUPPORTS

方法B的事务传播特性是SUPPORTS

方法A没有事务，方法A、B运行异常都不会回滚

方法A有事务，方法A异常，方法A、B都不会回滚

方法A有事务，方法B异常，方法A、B全部回滚


### MANDATORY
该方法必须运行在一个事务中，否则就报错

方法B为MANDATORY

方法A没有事务，调用方法B执行会报错

方法A有事务，执行异常，方法A、B都回滚

方法A有事务，方法B抛异常，都回滚

方法A有事务，方法B抛异常，方法A捕获异常，报错

### REQUIRES_NEW
该方法必须运行在一个新的事务中


方法A有事务，方法A异常，方法A回滚，方法B不回滚


方法A有事务，方法B抛异常，都会回滚

方法A有事务，方法B抛异常，方法A捕获，方法B回滚

### NOT_SUPPORTED
方法B是NOT_SUPPORTED

方法A有事务，方法B抛异常，方法A回滚，

方法A有事务，方法B抛异常，方法A捕获，都不回滚

### NEVER
该方法不能运行在另一个事务环境中

方法B是NEVER

方法A有事务，调用方法B会报错

### NESTED
方法B是NESTED

方法A没有事务，方法B抛异常，方法B回滚，方法A不回滚

方法A没有事务，方法A抛异常，都不回滚

方法A有事务，方法A抛异常，都回滚

方法A有事务，方法B抛异常，都回滚

方法A有事务，方法B抛异常，方法A捕获异常，方法B回滚，方法A不回滚

![image](https://raw.githubusercontent.com/liueleven/study/master/%E5%9B%BE%E5%BA%93/17-spring/03-spring-transaction%E4%BC%A0%E6%92%AD%E8%A1%8C%E4%B8%BA.png)

[参考博客](https://blog.csdn.net/pml18710973036/article/details/58607148)

