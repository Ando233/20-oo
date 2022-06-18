package package1;

public class Person {
    private String name = "";
    public Person(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class Buyer extends Person{
    public Buyer(String name){
        super(name);
    }
    public void Buy(String object){
        System.out.println(getName() + " buys " + object);
    }
}

class Cook extends Person{
    public Cook(String name){
        super(name);
    }
    public void cook(String dish){
        System.out.println(getName() + " makes " + dish);
    }
}
