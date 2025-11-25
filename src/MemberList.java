import java.util.Scanner;

public class MemberList {



    public static void show() {

        Scanner input = new Scanner(System.in);

        System.out.println("Member List:");

        for (Members m : Members.membersRegister) {
            System.out.println(m);
        }

        System.out.println("Press 0 to go back to the menu.");

        while (true) {
            int choice = input.nextInt();
            if (choice == 0) break;
            System.out.println("Press 0 to go back to the menu.");
        }
    }
}