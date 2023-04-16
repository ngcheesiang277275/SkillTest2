package my.uum;

import java.util.Scanner;

public class MySkill {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int command;
        double amount;
        int bottle = 0;

        Pack24 pack24 = new Pack24();
        Pack10 pack10 = new Pack10();
        Below10 below10 = new Below10();

        do {
            System.out.println("" +
                    "1. Enter Amount\n" +
                    "2. Enter Bottle\n" +
                    "0. Exit");

            command = scan.nextInt();

            if(command == 1){
                System.out.print("Enter amount (RM): ");
                amount = scan.nextDouble();
                double originalAmount = amount;

                System.out.printf("Amount RM: %.2f%n", amount);
                System.out.println("--------------------------------------");

                int numOfPack24 = pack24.calculatePack(amount);
                System.out.printf("%d set24 (%d bottles) -> RM%.1f\n", numOfPack24, (numOfPack24 * 24 ), pack24.calculatePrice(numOfPack24) );

                amount = amount - pack24.calculatePrice(numOfPack24);
                int numOfPack10 = pack10.calculatePack(amount);
                System.out.printf("%d set10 (%d bottles) -> RM%.1f%n", numOfPack10, (numOfPack10 * 10), pack10.calculatePrice(numOfPack10) );


                amount = amount - pack10.calculatePrice(numOfPack10);
                int numOfBelow10 = below10.calculatePack(amount);

                System.out.printf("%d  bottle(s) -> RM%.1f%n", numOfBelow10, below10.calculatePrice(numOfBelow10) );
                double total = pack24.calculatePrice(numOfPack24) + pack10.calculatePrice(numOfPack10) + below10.calculatePrice(numOfBelow10);
                double balance = originalAmount - total;
                int totalBottle = numOfBelow10 + (numOfPack10 * 10) + (numOfPack24 * 24 );
                System.out.printf("Total: RM%.2f%n", total);
                System.out.printf("Balance: RM%.2f%n", balance);
                System.out.printf("Total Bottle: %d %n", totalBottle);
                System.out.println("--------------------------------------");

            }else if(command == 2){
                System.out.print("Enter number of bottles: ");
                int numOfBottles = scan.nextInt();
                System.out.println("Quantity (bottles): " + numOfBottles);
                System.out.println("--------------------------------------");

                int bottle24 = pack24.calculateBottle(numOfBottles);
                System.out.printf("%d set24 (%d bottles) -> RM%.1f%n", bottle24, bottle24*24, pack24.calculatePrice(bottle24));

                numOfBottles = numOfBottles - (bottle24*24);
                int bottle10 = pack10.calculateBottle(numOfBottles);
                System.out.printf("%d set10 (%d bottles) -> RM%.1f%n", bottle10, bottle10*10, pack10.calculatePrice(bottle10));

                numOfBottles = numOfBottles - (bottle10*10);
                int bottleBelow10 = below10.calculateBottle(numOfBottles);
                System.out.printf("%d bottle(s) -> RM%.1f%n", bottleBelow10, below10.calculatePrice(bottleBelow10));

                double totalPrice = pack24.calculatePrice(bottle24) + pack10.calculatePrice(bottle10) + below10.calculatePrice(bottleBelow10);
                System.out.printf("Total: RM%.1f%n", totalPrice);
                System.out.println("--------------------------------------");


            }

        } while (command != 0);




    }
}
