import java.util.Scanner;

public class InputValidation {

public static final Scanner scanner = new Scanner(System.in);

public static int ReadInt(String prompt) {
while (true) {
    System.out.println(prompt);
    String line = scanner.nextLine().trim();

    try {
        return Integer.parseInt(line);
    } catch (NumberFormatException e) {
        System.out.println("Invalid Input! Please type a number");
    }
}
 }

 public static String  ReadString(String prompt) {
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



