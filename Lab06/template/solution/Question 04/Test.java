public class Test {
    public static void main(String[] args) {
        IShapeFactory rectangle = Rectangle.getFactory();
        IShapeFactory rhombus = Rhombus.getFactory();
        IShapeFactory ellipse = Ellipse.getFactory();

        System.out.println(rectangle.makeShape(1,2).calcArea());
        System.out.println(rhombus.makeShape(1,2).calcArea());
        System.out.println(ellipse.makeShape(1,2).calcArea());
    }
}
