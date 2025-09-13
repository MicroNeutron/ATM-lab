import java.util.Scanner;

public class in4 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            
            if (age >= 18 && gpa >= 3.0) {
                System.out.println("Eligible for Scholarship");
            } else if (gpa >= 3.5 && age < 18) {
                System.out.println("Unqualified");
            } else {
                System.out.println("Not Eligible");
            }
        }
    }
}