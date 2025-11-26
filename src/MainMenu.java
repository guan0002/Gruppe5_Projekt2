import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void PrintMenus() throws IOException {

        boolean run = true;

        while (run) {
            System.out.println("Welcome to your booking system!\n");

            String[] printMenus = {
                    "",
                    "Register a new member",
                    "View member list",
                    "Example 4",
                    "Close the program",
            };

            for (int i = 1; i < printMenus.length; i++) {
                System.out.println(i + ": " + printMenus[i]);
            }

            int choice = InputValidation.ReadInt("Enter a number:");


            switch (choice) {

                case 0:
                    System.out.println("Returning to main menu");
                    break;

                case 1:
                    Members members = new Members("", 0, "", "");
                    members.registerMember();
                    break;

                case 2:
                    MemberList.show();
                    break;

                case 3:
                    //Metode her
                    break;

                case 4:
                    System.out.println("Closing the program");
                    run = false;
                    break;

                case 5:
                    //Metode her
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}


