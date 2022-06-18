class Rhombus extends Shape{
    private static IShapeFactory factory = new IShapeFactory(){
        @Override
        public Shape makeShape(double a, double b) {
            if(a < 0 || b < 0) return null;
            return new Rhombus(a,b);
        }
    };

    public static IShapeFactory getFactory() {
        return factory;
    }

    public Rhombus(double a,double b){
        super(a,b);
    }

    @Override
    public double calcArea() {
        return getA()*getB()/2;
    }
}
