import java.util.Scanner;

public class in3 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChoose category: 1-Electronics, 2-Clothing, 3-Books");
            int choice = scanner.nextInt();
            double basePrice = 0;
            double discount = 0;
            
            switch (choice) {
                case 1:
                    basePrice = 1000;
                    discount = 0.10;
                    break;
                case 2:
                    basePrice = 500;
                    discount = 0.20;
                    break;
                case 3:
                    basePrice = 300;
                    discount = 0.05;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            
            double finalPrice = basePrice * (1 - discount);
            System.out.printf("Final price: $%.2f", finalPrice);
        }
    }
}