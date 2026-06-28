// Implementing the Factory Method Pattern
public class Exercise_2 
{
    interface Shape 
    {
        void area(int side1, int side2);
    }
    static class Square implements Shape 
    {
        public void area(int side, int ignored) 
        {
            System.out.println("Area of Square = " + (side * side));
        }
    }
    static class Rectangle implements Shape 
    {
        public void area(int length, int breadth) 
        {
            System.out.println("Area of Rectangle = " + (length * breadth));
        }
    }
    static class ShapeFactory 
    {
        public Shape getShape(String type) 
        {
            if (type.equalsIgnoreCase("Square"))
                return new Square();
            else
                return new Rectangle();
        }
    }
    public static void main(String[] args) 
    {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.getShape("Square");
        s1.area(5, 0);
        Shape s2 = factory.getShape("Rectangle");
        s2.area(4, 6);
    }
}