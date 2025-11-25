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

    public void registerMember() {
        Scanner input = new Scanner(System.in);

        boolean correctIntFormat = false;
        boolean correctActivity = false;
        boolean correctMemberType = false;
        boolean correctPaid = false;

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
            if (age<18) {
                memberType = "Junior Member";
            }
            else if (age>18 && age<60) {
                memberType = "Senior Member";
            } else {
                memberType = "Retied Member";
                }
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

        System.out.println("Member registered!");
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
                ", Type: " + memberType + ", Paid: " + paid;
    }
}

