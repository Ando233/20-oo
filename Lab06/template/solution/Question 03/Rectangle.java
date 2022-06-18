class Rectangle extends Shape{
    private static IShapeFactory factory = new IShapeFactory(){
        @Override
        public Shape makeShape(double a, double b) {
            if(a < 0 || b < 0) return null;
            return new Rectangle(a,b);
        }
    };

    public static IShapeFactory getFactory() {
        return factory;
    }

    public Rectangle(double a, double b){
        super(a,b);
    }

    @Override
    public double calcArea() {
        return getA()*getB();
    }
}
