import java.util.Scanner;

public class MainMenu {

    public static void MainMenu() {


        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Welcome to your booking system!");
            String[] printMenus = {
                    "",
                    "Example 1",
                    "Example 2",
                    "Example 3",
                    "Example 4",
                    "Example 5",
            };

            for (int i = 0; i < printMenus.length; i++) {
                System.out.println(i + ": " + printMenus[i]);
            }
            System.out.println("Enter a number");
            int choice = scanner.nextInt();
            scanner.nextLine();

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

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}
