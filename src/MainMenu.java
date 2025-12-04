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
                    "View competition list",
                    "Choose discipline",
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
                    Members members = new Members("", 0, "", "", "");
                    members.registerMember();
                    break;

                case 2:
                    if (Members.membersRegister.isEmpty()) {
                        System.out.println("No members have been registered yet.");
                    } else {
                        System.out.println("Member List:");
                        for (Members m : Members.membersRegister) {
                            System.out.println(m.memberDisplay());
                        }
                        InputValidation.ReadInt("Press 0 to go back to the menu.");
                        while (true) {
                            if (choice == 0);
                                break;
                            }
                        }
                    break;

                    case 3:
                    CompetitionMember.printcompetition();
                    break;


                case 4:
                    SwimEvent.registerEventMember();
                    break;

                case 5:
                    System.out.println("Closing the program...");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}


