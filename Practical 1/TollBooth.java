import java.util.Scanner;
public class TollBooth {
    record Vehicle(String number, String type){}
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int total=0;
        int bikec=0, carc=0, truckc=0;
        while(true)
        {
            System.out.println("Enter Vehicle Number (or done for exit) : ");
            String number = s.next();
            if(number.equalsIgnoreCase("done"))
                break;
            System.out.print("Enter Vehicle Type : ");
            String type = s.next().toLowerCase();
            Vehicle v = new Vehicle(number, type);
            int toll= switch(v.type())
            {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };
            total+=toll;
            switch(v.type())
            {
                case "bike" -> bikec++;
                case "car" -> carc++;
                case "truck" -> truckc++;

            }
        }
        System.out.println("Total toll : "+total);
       if(bikec>=carc && bikec>=truckc)
        System.out.println("Most Frequent : Bike");
    else if(carc>=bikec && carc>=truckc)
        System.out.println("Most Frequent : Car");
    else System.out.println("Most Frequent : Truck");
    s.close();
    }
}
