import java.util.Scanner;

public class InputValidation {

public static final Scanner scanner = new Scanner(System.in);

public static int ReadInt(String prompt) {
while (true) {
    System.out.println(prompt);
    String line = scanner.nextLine().trim();
    try {
        int value = Integer.parseInt(line);

        if (value < 0) {
            System.out.println("Please enter a positive integer");
            continue;
        }
        return value;

    } catch (NumberFormatException e) {
        System.out.println("Invalid Input! Please type a number");
    }
}
 }

 public static String ReadString(String prompt) {
    while (true) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();

        if (input.matches("[a-zA-ZæøåÆØÅ ]+")) {
            return input;
        } else {
            System.out.println("Please type a valid input!");

        }
    }
 }
}



