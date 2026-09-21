import java.util.Scanner;

public class prac1{
    enum coin{
        ONE,
        TWO,
        FIVE,
        TEN,
    }

    public static void main(String[] args){

        int SnackPrice=15;
        int total=0;
        Scanner s = new Scanner(System.in);
        while(total<SnackPrice){

            System.out.print("Enter the coin(ONE,TWO,FIVE and TEN): ");
            String input = s.nextLine().toUpperCase();

            coin c= coin.valueOf(input);
            int value=switch(c){
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN-> 10;
            };
            total += value;
            System.out.println("Total so far: " + total );}
        int change=total-15;
        System.out.println("The Price of snack is : " + SnackPrice );
        System.out.println("The Total is : " + total );
        System.out.println("The Change is :" + change );
    }
} 