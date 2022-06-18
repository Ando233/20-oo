# Lab 05 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question 1

1.private f()

2.不能，子类的权限不能比父类还低

## Question 2

1.sup.field = 0, sup.getField() = 1
	sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0

2.类的非静态属性体现不出多态性，只有非静态⽅法可以

## Question 3

1.Base staticGet()
	Derived dynamicGet()

2.静态方法不会被覆盖，不能体现多态性

​	静态属性不能体现多态性

## Question 4

1.A() before draw()
	B.draw(), b = 0	
	A() after draw()
	B(), b = 5

2.B类继承了子类，在B的构造函数开始前，要先调用A的构造函数，从而输出“A() before draw()”

​	在A的构造函数调用draw方法时，发现子类B重写了draw方法，同时此时B中的变量b还未赋值，

​	故输出"B.draw(), b = 0"。再输出"A() after draw()"，结束调用A的构造函数，再调用B的构造函数，

​	从而输出"B(), b = 5"

## Question 5

见代码

## Question 6

1.

Test01继承的f()是public类型，重写的时候权限变小了

Test23返回的a不确定是来自哪个接口

Test02两个方法传参一样但返回值不一样，无法重载

2.

I2会引入新的错误，出现两个函数参数相同但返回值不同

