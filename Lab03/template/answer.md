# Lab 03 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question 1:

initialize A1
initialize A2
initialize A3
initialize A4
initialize A5
initialize A6
copy from A6
initialize B1
initialize A8
main begins
initialize A9
initialize A6
copy from A6
initialize B2
initialize A8
main ends

## Question 2:

可以

可以，静态变量a3,a5按照顺序输出

## Question 3:

按照顺序：

1.静态变量和静态初始化块

2.在属性定义处显式初始化的变量

3.在构造方法或非静态方法中初始化的变量

## Question 4:

可以，在A中实例a6被构造时，JVM执行了类加载，因此a3,a4,a5先于a6初始化

## Question 5:

不能，Singleton的构造方法设置了private

## Question 6:

只有一个uniqueInstance可以存在，由于构造方法设置了private，外类无法进行构造。

该实例在类加载时完成构造。

## Question 7:

```
Singleton.getInstance.foo();
```

