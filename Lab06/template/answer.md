# Lab 06 Assignment

> 班级：202113
> 
> 学号：20373221
> 
> 姓名：王宇奇

## Question 01

```
class Outer {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
    }
}
```

![image-20220422181231161](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220422181231161.png)

## Question 02

```
interface Inter {
    void show();
}

class Outer {
    public static Inter method(){
        return new Inter() {
            @Override
            public void show() {
                System.out.println("Duludulu");
            }
        };
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.method().show();
    }
}
```

![image-20220422182353242](C:\Users\Ando\AppData\Roaming\Typora\typora-user-images\image-20220422182353242.png)

## Question 03

见代码

## Question 04

见代码