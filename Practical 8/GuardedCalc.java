import java.util.Scanner;
class DivideByZeroException extends Exception
{
    public DivideByZeroException(String msg)
    {
        super(msg);
    }
}
public class GuardedCalc
{
   public static double calculate(double a, double b, char operator)throws DivideByZeroException
    {
        switch(operator)
        {
            case '+':
                return a+b;

            case '-':
                return a-b;

            case '*':
                return a*b;

            case '/':
                if(b == 0)
                    throw new DivideByZeroException("Divide by zero error");
                return a/b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1:");
        String input1=sc.nextLine();
        System.out.println("Enter number 2:");
        String input2=sc.nextLine();
        try
        {
            double a=Double.parseDouble(input1);
            double b=Double.parseDouble(input2);
            boolean success=false;
            while(!success)
            {
                System.out.println("Enter operator (+, -, *, /):");
                char operator=sc.next().charAt(0);
                try
                {
                    double result=calculate(a, b, operator);
                    System.out.println("Result: " + result);
                    success=true;
                }
                catch(DivideByZeroException e)
                {
                    System.out.println(e.getMessage());
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid number format");
        }
        sc.close();
    }
}