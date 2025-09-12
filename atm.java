import java.util.Scanner;

class ConsoleColors {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[38;5;33m";
    
    public static String green(String text) {
        return GREEN + text + RESET;
    }
    
    public static String red(String text) {
        return RED + text + RESET;
    }

    public static String blue(String text) {
        return BLUE + text + RESET;
    } 
} 

public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = null;
        double balance = 0.00; 

        while (password == null) {
            System.out.print(ConsoleColors.RESET + "4-DIGIT_PIN_SET: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d{4}")) {
                password = input;
                System.out.println(ConsoleColors.GREEN + "SUCCEED!");
            } else {
                System.out.println(ConsoleColors.RED + "INVALID_PIN!");
            }
        }
        
        while (true) {
            System.out.println(ConsoleColors.BLUE + "LOGIN: (ENTER_RESET_TO_RESET_PASSWORD)");
            int attempts = 3;
            boolean isLoggedIn = false;
            
            while (attempts > 0 && !isLoggedIn) {
                System.out.print(ConsoleColors.RESET + "PIN_YOU_HAVE: " + attempts + " CHANCES: ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("RESET")) {
                    System.out.println(ConsoleColors.BLUE + "\nPASSWORD_RECOVERY");
                    System.out.print(ConsoleColors.RESET + "SET_NEW_4-DIGIT_PIN: ");
                    String newPassword = scanner.nextLine().trim();
                    
                    if (newPassword.matches("\\d{4}")) {
                        password = newPassword;
                        System.out.println(ConsoleColors.GREEN + "SUCCEED!");
                        attempts = 3;
                    } else {
                        System.out.println(ConsoleColors.RED + "INVALID_PIN!");
                    }
                } else if (input.equals(password)) {
                    System.out.println(ConsoleColors.GREEN + "SUCCEED!");
                    isLoggedIn = true;
                } else {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println(ConsoleColors.RED + "FAILED!");
                    } else {
                        System.out.println(ConsoleColors.RED + "LOCKED_FOR_FAILED_OVER_3_TIMES");
                        System.out.println(ConsoleColors.BLUE + "TO_RESET_PASSWORD_ENTER_RESET" + ConsoleColors.RESET);
                        

                        String resetInput = scanner.nextLine().trim();
                        if (resetInput.equalsIgnoreCase("RESET")) {
                            System.out.print(ConsoleColors.BLUE + "\nPASSWORD_RECOVERY: \n");
                            System.out.print(ConsoleColors.RESET + "SET_NEW_4-DIGIT_PIN: ");
                            String newPassword = scanner.nextLine().trim();
                            if (newPassword.matches("\\d{4}")) {
                                password = newPassword;
                                System.out.println(ConsoleColors.GREEN + "SUCCEED!");
                                attempts = 3; 
                            } else {
                                System.out.println(ConsoleColors.RED + "INVALID_PIN!");
                            }
                        } else {
                            System.out.println(ConsoleColors.RED + "ACCOUNT_LOCKED");
                            return; 
                        }
                    }
                }
            }
            
            while (isLoggedIn) {
                System.out.println(ConsoleColors.BLUE + "ATM_MENU");
                System.out.println(ConsoleColors.RESET + "1: CHECK_BALANCE"); 
                System.out.println(ConsoleColors.RESET + "2: DEPOSIT_FUNDS");
                System.out.println(ConsoleColors.RESET + "3: WITHDRAW_FUNDS");
                System.out.println(ConsoleColors.RESET + "4: RETURN_CARD");
                System.out.print(ConsoleColors.BLUE + "CHOOSE_BETWEEN1-4: ");
                
                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        System.out.printf(ConsoleColors.GREEN + "BALANCE: $%.2f\n", balance); 
                        break;
                        
                    case "2":
                        System.out.print(ConsoleColors.RESET + "ENTER_DEPOSIT_AMOUNT: ");
                        try {
                            double deposit = Double.parseDouble(scanner.nextLine());
                            if (deposit > 0) {
                                balance += deposit;
                                System.out.printf(ConsoleColors.GREEN + "SUCCEED! BALANCE_NOW: $%.2f\n", balance);
                            } else {
                                System.out.println(ConsoleColors.RED + "INVALID_AMOUNT!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(ConsoleColors.RED + "INVALID_CHARACTERS!");
                        }
                        break;
                        
                    case "3":
                        System.out.print(ConsoleColors.RESET + "ENTER_WITHDRAW_AMOUNT: ");
                        try {
                            double withdraw = Double.parseDouble(scanner.nextLine());
                            if (withdraw > 0) {
                                if (withdraw <= balance) {
                                    balance -= withdraw;
                                    System.out.printf(ConsoleColors.GREEN + "SUCCEED! BALANCE_NOW: $%.2f\n", balance);
                                } else {
                                    System.out.println(ConsoleColors.RED + "INSUFFICIENT_FUNDS!");
                                }
                            } else {
                                System.out.println(ConsoleColors.RED + "INVALID_AMOUNT!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(ConsoleColors.RED + "INVALID_CHARACTERS!");
                        }
                        break;
                        
                    case "4":
                        System.out.println(ConsoleColors.GREEN + "THANK_YOU_FOR_USING_OUR_SERVICE");
                        isLoggedIn = false;
                        break;
                        
                    default:
                        System.out.println(ConsoleColors.RED + "INVALID_SELECTION");
                }
            }
        }
    }
}