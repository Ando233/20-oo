interface IShapeFactory{
    Shape makeShape(double a, double b);
}

public abstract class Shape {
    private double a;
    private double b;

    public Shape(double a, double b) {
        if(a>0) this.a = a;
        else this.a = 0;
        if(b>0) this.b = b;
        else this.b = 0;
    }

    /** calcArea
     * 计算形状的面积
     * @return 面积
     */
    abstract public double calcArea();

    /* 其他必要的方法，比如 getter 和 setter */

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

}
