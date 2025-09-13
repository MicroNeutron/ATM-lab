import java.util.Scanner;

public class in2 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter month: ");
            int month = scanner.nextInt();
            System.out.print("Enter day: ");
            int day = scanner.nextInt();
            
            boolean valid = true;
            if (month < 1 || month > 12 || day < 1) {
                valid = false;
            } else {
                int maxDay;
                switch (month) {
                    case 2:
                        maxDay = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
                        break;
                    case 4: case 6: case 9: case 11:
                        maxDay = 30;
                        break;
                    default:
                        maxDay = 31;
                }
                if (day > maxDay) valid = false;
            }
            System.out.println(valid ? "Valid date" : "Invalid date");
        }
    }
}