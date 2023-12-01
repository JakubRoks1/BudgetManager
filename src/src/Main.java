import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static double totalAmount = 0.0;
    private static List<String> purchases = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addPurchase(scanner);
                    break;
                case 3:
                    listOfPurchases();
                    break;
                case 4:
                    balance();
                    break;
                case 0:
                    System.out.println("Bye!");
                    scanner.close();  // Close the Scanner before exiting the program
                    return;
                default:
                    System.out.println("Option doesn't exist");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }

    private static void addIncome(Scanner scanner) {
        System.out.println("Enter income:");
        double income = scanner.nextDouble();
        totalAmount += income;
        System.out.println("Income was added!");
    }

    private static void addPurchase(Scanner scanner) {
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Purchase was added!");
        purchases.add(purchaseName + " $" + price);

    }

    private static void listOfPurchases() {
        if (purchases.isEmpty()) {
            for (String purchase : purchases) {
                System.out.println(purchase);
            }
        } else {
            System.out.println("The purchase list is empty");
        }
    }

    private static void balance() {
        System.out.println("Balance: $" + totalAmount);
    }
}