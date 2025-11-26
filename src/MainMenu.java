import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static void PrintMenus() {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        {
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
                System.out.println("Enter a number:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0)
                    System.out.println("Returning to the main menu");

                switch (choice) {
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
