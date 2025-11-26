import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Members {
    String name;
    int age;
    String memberType;
    String paid;
    public static ArrayList<Members> membersRegister = new ArrayList<>();

    public Members(String name, int age, String memberType, String paid) {
        this.name = name;
        this.age = age;
        this.memberType = memberType;
        this.paid=paid;

    }

    public void registerMember() throws IOException {
        Scanner input = new Scanner(System.in);

        boolean correctIntFormat = false;
        boolean correctActivity = false;
        boolean correctMemberType = false;
        boolean correctPaid = false;
        boolean backToMenu = false;

        String name;
        int age = 0;
        String memberType="";
        String paid = "";
        String activity = "";

        System.out.println("Write member name");
        name = input.nextLine();

        while (!correctIntFormat) {
            System.out.println("Write age");
            try {
                age = input.nextInt();
                correctIntFormat = true;
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("We only accept numbers, not letters. Try again!");
                input.nextLine();
            }
        }

        while(!correctActivity) {
            System.out.println("Are the membership, active or passive?");
            activity=input.nextLine();
            if(activity.equalsIgnoreCase("Active") || activity.equalsIgnoreCase("Passive")) {
                correctActivity=true;
            }
            else {
                System.out.println("you have to write either 'Active' or 'Passive'!!!");
            }
        }

        if (activity.equalsIgnoreCase("Active")) {

        }
        else {
            memberType="Passive";
        }

        while (!correctPaid) {
            System.out.println("Write yes if the member has paid or no for not paid");
            paid = input.nextLine();
            if (paid.equalsIgnoreCase("Yes") || paid.equalsIgnoreCase("No")) {
                correctPaid = true;
            } else {
                System.out.println("You have to write yes or no");
            }
        }

        Members m = new Members(name, age, memberType, paid);
        membersRegister.add(m);
        DatabaseMember.saveMembersToFile(Members.membersRegister);

        System.out.println("Member registered!");

        System.out.println("Press 0 to go back to the menu.");

        while (true) {
            int choice = input.nextInt();
            if (choice == 0) break;
            System.out.println("Press 0 to go back to the menu.");
        }
        System.out.println("Press 0 to get back to the menu");
        while(!backToMenu){
            int back = input.nextInt();
            if (back == 0) {
                backToMenu = true;
            } else {
                System.out.println("Press 0 to get back to the menu");
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
                ", Type: " + memberType + ", Paid: " + paid;
    }

}

