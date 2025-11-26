import java.util.ArrayList;
import java.util.Scanner;

public class MemberList {

    public static void show(){


        System.out.println("Member List:");

        for (Members m : Members.membersRegister) {
            System.out.println(m);
        }

        int choice = InputValidation.ReadInt("\nPress 0 to go back to the menu.");

        while (choice != 0) {
            choice = InputValidation.ReadInt("Press 0 to go back to the menu.");
        }

    }
}