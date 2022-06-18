# Lab 04 Assignment

> 班级：202113
>
> 学号：20373221
>
> 姓名：王宇奇

## Question 1

A.java中添加

```
package com.oo.aa;
```

B.java中添加

```
package com.oo.bb;
import com.oo.aa.A;
```

C.java中添加

```
package com.oo.cc;
import com.oo.bb.B;
```

Main.java中添加

```
package com.oo;
import com.oo.cc.C;
```

BTest.java中添加

```
package test;
import com.oo.bb.B;
```



## Question 2

1.可以有子类，但无法创建子类的实例。

2.不能，final类可以创建多个实例，而所有构造方法都是private的类不能。

## Question 3

1.执行java Test

```
4
4
5
foo() of Parent
foo() of Child
foo() of Child
bar() of Parent
bar() of Parent
bar() of Child
```

2，3:不能通过编译，子类权限不能低于父类权限

4:不一致

5:

override:属性，非静态方法可以，静态方法不可以

hide:属性，非静态方法可以，静态方法不可以

## Question 4

![image-20220408190305860](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220408190305860.png)

![image-20220408190326478](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220408190326478.png)

![image-20220408190339632](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220408190339632.png)

## Question 5

![image-20220408193606882](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220408193606882.png)

## Question 6

见代码