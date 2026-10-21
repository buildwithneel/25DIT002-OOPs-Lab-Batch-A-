abstract class Shape 
{
    abstract double area();    
}
class Circle extends Shape
{
    double radius;
    Circle(double radius)
    {
        this.radius=radius;
    }
    @Override
    double area()
    {
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape
{
    double length,width;
    Rectangle(double length,double width)
    {
        this.length=length;
        this.width=width;
    }
    @Override
    double area()
    {
        return length*width;
    }
}
class Triangle extends Shape
{
    double base,height;
    Triangle(double base,double height) 
    {
        this.base=base;
        this.height=height;
    }
    @Override
    double area()
    {
        return 0.5*base*height;
    }
}
public class shapedemo
{
    public static void main(String[] args)
    {
        Shape[] shapes={new Circle(1.2),
            new Rectangle(10,20),
            new Triangle(11,12),
            new Circle(15)        
        };
        double currentArea=0;
        double total=0;
        double largest=0;
        for(Shape i:shapes)
        {
            currentArea=i.area();
            System.out.println("Area:"+String.format("%.2f",currentArea));
            total+=currentArea;
            if(currentArea>largest)
            {
                largest=currentArea;
            }
            System.out.println("Total:"+String.format("%.2f",total));
        }
        System.out.println("Largest Area:"+String.format("%.2f",largest));
    }
}