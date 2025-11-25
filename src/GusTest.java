import java.util.Scanner;

public class GusTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        {
            while (run) {
                System.out.println("Welcome to your booking system!");

                String[] printMenus = {
                        "",
                        "Go back to the main menu",
                        "Example 2",
                        "Example 3",
                        "Example 4",
                        "Close the program",
                };

                for (int i = 1; i < printMenus.length; i++) {
                    System.out.println(i + ": " + printMenus[i]);
                }
                System.out.println("Enter a number:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("Returning to the main menu");
                    continue;
                }


                switch (choice) {
                    case 1:
                        //Metode her
                        break;
                    case 2:
                        //Metode her
                        break;

                    case 3:
                        //Metode her
                        break;

                    case 4:
                        //Metode her
                        break;

                    case 5:
                        if (choice == 5) {
                            System.out.println("Closing the program");
                            run = false;
                            break;
                        }
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        }
    }
}
