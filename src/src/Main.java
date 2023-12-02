
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
                    System.out.println();
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
        System.out.println();
        System.out.println("Enter income:");
        double income = scanner.nextDouble();
        totalAmount += income;
        System.out.println("Income was added!");
        System.out.println();
    }

    private static void addPurchase(Scanner scanner) {
        System.out.println();
        scanner.nextLine();

        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();

        double price;
        while (true) {
            System.out.println("Enter its price:");
            try {
                price = Double.parseDouble(scanner.nextLine());
                totalAmount -= price;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        System.out.println("Purchase was added!");
        purchases.add(purchaseName + " $" + price);
        System.out.println();

    }

    private static void listOfPurchases() {
        System.out.println();
        if (purchases.size() > 0) {
            for (String purchase : purchases) {
                System.out.println(purchase);
            }
            System.out.println("Total sum: " + totalAmount);
        } else {
            System.out.println("The purchase list is empty");
        }
        System.out.println();
    }

    private static void balance() {
        System.out.println();
        System.out.println("Balance: $" + totalAmount);
        System.out.println();
    }
}