import java.util.Random;

public class ShapeFactory {
    public enum ShapeType{
        Rectangle, Rhombus, Ellipse;
    }

    public Shape makeShape(ShapeType type, double a, double b){
        if(a < 0 || b < 0) return null;
        else {
            switch (type){
                case Rectangle:
                    return new Rectangle(a,b);
                case Rhombus:
                    return new Rhombus(a,b);
                case Ellipse:
                    return new Ellipse(a,b);
                default:
                    return null;
            }
        }
    }

    public Shape randomNextShape(){
        Random random = new Random();
        int x = (random.nextInt() % 3 + 3) % 3;
        double a = random.nextDouble();
        double b = random.nextDouble();
        switch (x){
            case 0:
                return new Rectangle(a, b);
            case 1:
                return new Rhombus(a, b);
            case 2:
                return new Ellipse(a, b);
            default:
                return null;
        }
    }

}
