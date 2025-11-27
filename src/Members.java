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
        boolean choiceTeam = false;
        boolean backToMenu = false;

        String name;
        int age = 0;
        String memberType = "";
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

        while (!correctActivity) {
            System.out.println("Is the membership active or passive?");
            activity = input.nextLine();
            if (activity.equalsIgnoreCase("Active") || activity.equalsIgnoreCase("Passive")) {
                correctActivity = true;
            } else {
                System.out.println("Please write either 'Active' or 'Passive'.");
            }
        }

        if (activity.equalsIgnoreCase("Active")) {
            if (age < 18) {
                memberType = "Junior Member";
            } else if (age > 18 && age < 60) {
                memberType = "Senior Member";
            } else {
                memberType = "Elder Member";
            }
        } else {
            memberType = "Passive";
        }

        while (!correctPaid) {
            System.out.println("Has the member paid? Type 'yes' or 'no'.");
            paid = input.nextLine();
            if (paid.equalsIgnoreCase("Yes") || paid.equalsIgnoreCase("No")) {
                correctPaid = true;
            } else {
                System.out.println("You must write either yes or no");
            }
        }

        Members m = new Members(name, age, memberType, paid);
        membersRegister.add(m);
        DatabaseMember.saveMembersToFile(Members.membersRegister);

        while (!choiceTeam) {
            System.out.println("Does the member want to join a team? Type 'yes' or 'no'.");
            String team = input.nextLine();
            if (team.equalsIgnoreCase("Yes"))
                choiceTeam = true;
            else if (team.equalsIgnoreCase("No")) {
                System.out.println("The member is now registered.");
                while (true) {
                    System.out.println("Press 0 to get back to the menu:");
                    if (input.hasNextInt()) {
                        int back = input.nextInt();
                        input.nextLine();
                        if (back == 0)
                            return;
                        else
                            System.out.println("Invalid number. Press 0 to go back.");
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        input.nextLine();
                    }
                }

            } else {
                System.out.println("Invalid input — please write yes or no");
            }
        }

        System.out.println("Is the member a recreational or competitive swimmer?");
        String swimType = input.nextLine();

        if (swimType.equalsIgnoreCase("Competitive")) {
            CompetitionMember cm = new CompetitionMember(name, age, memberType, paid, "Competitive");
            boolean added = cm.tryAddToCompetition();

            if (added) {
                System.out.println("The member is now registered as a competitive swimmer!");
            } else {
                System.out.println("Only active members within the allowed age range can be added to the list.");
            }
        } else if (swimType.equalsIgnoreCase("recreational")) {
            System.out.println("The member is now registered as a recreational swimmer");
        } else {
            System.out.println("Invalid input — please write exerciser or competition");
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
        return name + "," + age + "," + memberType + "," + paid;
    }

    public String memberDisplay() {
        return "Name: " + name +
                " Age: " + age +
                " Type: " + memberType +
                " Paid: " + paid ;
    }
}

