public class Test {
    public static void main(String[] args) {
        Shape[] test = new Shape[10];
        ShapeFactory factory = new ShapeFactory();
        for(int i = 0;i < 5;i++) {
            test[i]=factory.randomNextShape();
        }
        for(Shape p : test){
            if(p != null) System.out.println(p.calcArea());
        }
    }
}
