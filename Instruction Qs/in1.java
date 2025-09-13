import java.util.Scanner;

public class in1 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter three integers: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            if (a + b > c && a + c > b && b + c > a) {
                if (a == b && b == c) {
                    System.out.println("Equilateral triangle");
                } else if (a == b || b == c || a == c) {
                    System.out.println("Isosceles triangle");
                } else {
                    System.out.println("Scalene triangle");
                }
            } else {
                System.out.println("Invalid triangle");
            }
        }
    }
}