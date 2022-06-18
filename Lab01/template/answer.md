# Lab 01 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question 01:

(a):Person.java

(b):两个; Person.class, Xiti.class

(c):

执行java Person:

错误: 找不到或无法加载主类 Person
原因: java.lang.NoClassDefFoundError: package1/Person (wrong name: Person)



执行java xiti:

错误: 找不到或无法加载主类 xiti
原因: java.lang.NoClassDefFoundError: package1/Xiti (wrong name: xiti)



执行java Xiti.class:

错误: 找不到或无法加载主类 Xiti.class
原因: java.lang.ClassNotFoundException: Xiti.class



执行java Xiti:

您好，很高兴认识您 nice to meet you



## Question 02:

![image-20220315235411974](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220315235411974.png)

## Question 03:

'大'的Unicode编码：22823
Unicode编码为23398的字符是：学

## Question 04:

intArray[0]=8
intArray[1]=9
intArray[2]=12
intArray[3]=13
intArray[4]=14

sum=56

## Question 05:

b[0] [0]=1000
sum=1139
b.lengh=3
 arr1:
 0 1 2 3 4 5 6 7 8 9 10 11
 arr2:
 12
 13
 14
 15
 16
 17
 18
 19
 20
 21
 22
 23
 arr3:
 0 1 2 3 4 5 6 7 8

## Question 06:

Jeep好好

case1和case3中没有写break,因此它们下面含有break的case2和default各多执行了一次

## Question 07:

![image-20220314172134258](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220314172134258.png)

![image-20220314172215720](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220314172215720.png)

## Question 08:

![37](C:\Users\Ando\Desktop\37.png)

![image-20220315191101506](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220315191101506.png)

## Question 09:

```java
public static double getPi(int n){
	double ans=0;
    if(n<0) n=0;
    for(int i=0;i<=n;i++){
    	if(i%2==1) ans-=1.0/(2*i+1);
        else ans+=1.0/(2*i+1);
    }
    return 4*ans;
}
```

![image-20220316145127403](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316145127403.png)

## Question 10:

```
public static void sort(int[] arr,int l,int r){
        if(l>r) return;
        int flag=arr[l],i=l,j=r;
        while (i!=j){
            while (arr[j]>=flag&&i<j){
                j--;
            }
            while (arr[i]<=flag&&i<j){
                i++;
            }
            if(i<j){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
        arr[l]=arr[i];
        arr[i]=flag;
        sort(arr,l,i-1);
        sort(arr,i+1,r);
        return ;
    }

    public static int[] qsort(int[] arr){
        if(arr==null) return null;
        if(arr.length==1) return arr;
        sort(arr,0,arr.length- 1);
        return arr;
    }
```

![image-20220316150956988](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316150956988.png)

## Question 10.5(原Question 13)

![image-20220316152335338](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316152335338.png)

![image-20220316152359190](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316152359190.png)

## Question 11

![image-20220316152644625](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316152644625.png)

## Question 12

p1的x,y坐标:1111,2222
p2的x,y坐标:-100,-200

p1的x,y坐标:0,0
p2的x,y坐标:0,0

## Question 13

数组a的元素个数=4
数组b的元素个数=3
数组a的引用=[I@4e50df2e
数组b的引用=[I@1d81eb93
数组a的元素个数=3
数组b的元素个数=3
a[0]=100,a[1]=200,a[2]=300
b[0]=100,b[1]=200,b[2]=300



a=b将b的引用赋给了a，因此a的元素个数及内容在赋值之后与b相同

## Question 14

1
2
-1
-2
-3
-4
9
7
6

## Question 15

![image-20220316160407714](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220316160407714.png)

(1) 可以

(2) 不能

(3) 不能



## Question 16

对象：小王

类：人

属性：体重

行为：减肥

状态：减肥前状态：小王体重70kg；减肥后状态：小王体重45kg；

状态变化：减肥行为使得小王的体重发生了变化

## Question 17

父类：人

子类：采购员，厨师

父类的属性：名字

采购员，厨师的属性：名字

采购员的行为：买菜

厨师的行为：做菜

![image-20220317221016359](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220317221016359.png)
