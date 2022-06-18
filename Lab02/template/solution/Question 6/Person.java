public class Person {
    private String name;
    private int age;
    private char sex;

    public Person(String name,int age,char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void work(){
        System.out.println("working");
    }

    public void showage(){
        System.out.println(age);
    }
}
