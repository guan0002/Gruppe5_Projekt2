import java.util.Scanner;

public class MemberList {

    public static void show() {

        Scanner input = MainMenu.scanner;

        System.out.println("Member List:");

        for (Members m : Members.membersRegister) {
            System.out.println(m);
        }

        System.out.println("\nPress 0 to go back to the menu.");

        int choice = input.nextInt();
        input.nextLine();

    }
}