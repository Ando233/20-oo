# Lab 09 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question 1

FileInputStream.

FileInputStream是按字节读取

FileOutputStream是按字符读取

## Question 2

(1)

3

abc

1

dbc

(2)

Part I: 读取三个字符，返回3，read指针直到d的位置

Part II:读取d之后发现到文件的末尾，返回1，向tom[0]写入d

根本原因在于read指针会随着读取而自动移动

## Question 3-6

见代码

