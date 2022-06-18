package package1;

public class Person {
    int weight;
    public void setWeight(int n){
        this.weight = n;
    }

    public void lose_weight(int n){
        this.weight -= n;
    }

    public static void main(String[] args) {
        Person Xiaowang = new Person();
        Xiaowang.setWeight(70);
        System.out.println(Xiaowang.weight);
        Xiaowang.lose_weight(25);
        System.out.println(Xiaowang.weight);
    }
}
