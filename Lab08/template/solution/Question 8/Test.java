public class Test {
    public static void main(String[] args) {
        try {
            Triangle test = new Triangle(1, 2, 3);
            test.showInfo();
            System.out.println(test.getArea());
        } catch (NotTriangleException e) {
            e.printStackTrace();
        }

        try {
            Triangle test2 = new Triangle(2, 2, 3);
            test2.showInfo();
            System.out.println(test2.getArea());
        } catch (NotTriangleException e) {
            e.printStackTrace();
        }
    }

}
