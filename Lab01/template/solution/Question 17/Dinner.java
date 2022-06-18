package package1;

public class Dinner {
    public static void main(String[] args) {
        var Aunt = new Buyer("Aunt");
        var Mom = new Buyer("Mom");
        var I = new Buyer("I");
        var Dad = new Cook("Dad");
        var Aunt2 = new Cook("Aunt2");
        Aunt.Buy("carrot");
        Mom.Buy("rice");
        I.Buy("cucumber");
        Dad.cook("carrot");
        Aunt2.cook("carrot and rice");
    }
}
