# Lab 00 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question1 

`java` 的使用方法为：**java -classpath [path] [file]**

其参数的含义是：**options**(命令行选项)

`javac` 的使用方法为：**javac -sourcepath [path] [file]**

其参数的使用含义是：

​	**path**(源文件的路径)

​	**files**(一个或多个要编译的源文件)

## Question2 

![image-20220305151650276](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220305151650276.png)

## Question3

(1)

![image-20220305164606969](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220305164606969.png)

(2)

![image-20220305164646673](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220305164646673.png)

## Question4

![image-20220305153739583](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220305153739583.png)

## Question5

字节型变量 b = 85
短整型变量 s = 22015
整型变量 i = 1000000
长整型变量 l = 65535
字符型变量 c = c
浮点型变量 f = 0.23
双精度变量 d = 7.0E-4
布尔型变量 B = true
字符串对象 S = This is a string

Process finished with exit code 0

## Question6

| 基本类型  | 默认值 | 基本类型    | 默认值 |
| :-------- | :----: | :---------- | :----: |
| **byte**  |   0    | **boolean** | false  |
| **short** |   0    | **char**    |  null  |
| **int**   |   0    | **float**   |  0.0f  |
| **long**  |   0L   | **double**  |  0.0d  |

## Question7

max=96.9
min=-9.9

## Question8

(1)

1

2 

b is false

(2)

```
//对于a&&b&&c&&……
if(a){
	接着检查b，c，……的正确性
}
if(!a){
	return false;
}
```

(3)

利用短路机制可以优化if-else段代码，将复杂的多段if判断用逻辑判断式简洁的完成

## Question9

全局变量  a = 10
在print()中, 全局变量　a = 10, b = 20.0
在print()中, 全局变量　a = 30, b = 20.0
全局变量变化后  a = 30

Process finished with exit code 0

## Question10

在print()中的局部变量　a = 10, b = 20.0
在print()中的局部变量　a = 30, b = 20.0

Process finished with exit code 0