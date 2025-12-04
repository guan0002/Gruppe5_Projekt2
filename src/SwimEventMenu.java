import java.io.IOException;

public class SwimEventMenu {

    public static void PrintEventMenu() throws IOException {

        boolean run = true;

        while (run) {
            System.out.println("Welcome to the event menu:\n");

            String[] printMenus = {
                    "",
                    "Register a new event",
                    "Edit an existing event",
                    "Add Member to an event",
                    "View event",
                    "Show top 5 for all events",
                    "Return to main menu",
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
                    SwimEvent.createEvent();
                    break;

                case 2:
                    SwimEvent.editEventMenu();
                    break;

                case 3:
                    SwimEvent.addMemberToEvent();
                    break;

                case 4:
                    SwimEvent.showEvent();
                    break;

                case 5:
                    SwimEvent.showTopRanks();
                    break;

                case 6:
                    MainMenu.PrintMenus();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }

}
