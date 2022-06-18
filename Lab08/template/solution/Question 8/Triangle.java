class NotTriangleException extends Exception{}

public class Triangle {
    double x,y,z;
    public Triangle(double x,double y,double z) throws NotTriangleException{
        this.x = x;
        this.y = y;
        this.z = z;
        if (x+y<=z || y+z<=x || x+z<=y)	{
            throw new NotTriangleException();
        }
    }
    public double getArea(){
        double cir = (x + y + z) / 2;
        return Math.sqrt(cir * (cir - x) * (cir - y) * (cir - z));
    }
    public void showInfo(){
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println("z: "+z);
    }
}
