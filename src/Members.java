import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Members {
    String name;
    int age;
    String memberType;
    String paid;
    String swimType;
    public static ArrayList<Members> membersRegister = new ArrayList<>();

    public Members(String name, int age, String memberType, String paid, String swimType) {
        this.name = name;
        this.age = age;
        this.memberType = memberType;
        this.paid=paid;
        this.swimType=swimType;

    }
    public void registerMember() throws IOException {
        String name = InputValidation.ReadString("Write member name");
        int age = InputValidation.ReadInt("Write age");

        String activity;
        while (true) {
            activity = InputValidation.ReadString("Is the membership active or passive?");
            if (activity.equalsIgnoreCase("Active") || activity.equalsIgnoreCase("Passive")) {
                break;
            } else {
                System.out.println("Please write either 'Active' or 'Passive'.");
            }
        }

        String memberType;
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

        String paid;
        while (true) {
            paid = InputValidation.ReadString("Has the member paid? Type 'yes' or 'no'.");
            if (paid.equalsIgnoreCase("Yes") || paid.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("You must write either yes or no.");
            }
        }

        while (true) {
            String team = InputValidation.ReadString("Does the member want to join a team? Type 'yes' or 'no'.");
            if (team.equalsIgnoreCase("Yes")) {
                break;
            } else if (team.equalsIgnoreCase("No")) {
                Members m  = new Members(name, age, memberType, paid, swimType);
                membersRegister.add(m);
                DatabaseMember.saveMembersToFile(Members.membersRegister);
                System.out.println("The member is now registered.");

                while (true) {
                    int back = InputValidation.ReadInt("Press 0 to get back to the menu:");
                    if (back == 0) {
                        return;
                    } else {
                        System.out.println("Invalid number. Press 0 to go back.");
                    }
                }
            }
        }
        //Opretter en scanner der kun bliver brugt her fordi InputValidation automatisk filtrerer tal
        Scanner OneTimeUse = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Is the member a recreational or competitive swimmer? '1' for Recreational or '2' for Competitive");
            if (OneTimeUse.hasNextInt()) {
                choice = OneTimeUse.nextInt();
                OneTimeUse.nextLine();
            } else {
                System.out.println("Please enter a number '1' or '2'");
                OneTimeUse.nextLine();
                continue;
            }
            if (choice == 1) {
                swimType = "Recreational";
                break;
            } else if (choice == 2) {
                swimType = "Competitive";
                break;
            } else {
                System.out.println("Invalid number! Type '1' or '2'");
            }
        }

        Members m  = new Members(name, age, memberType, paid, swimType);
        membersRegister.add(m);
        DatabaseMember.saveMembersToFile(Members.membersRegister);

        if (swimType.equalsIgnoreCase("Competitive")) {
            CompetitionMember cm = new CompetitionMember(name, age, memberType, paid, "Competitive");
            boolean added = cm.tryAddToCompetition();

            if (added) {
                System.out.println("The member is now registered as a competitive swimmer!");

                DatabaseCompetitionMember.saveCompetitionDatabase();

            } else {
                System.out.println("Only active members within the allowed age range can be added to the list.");
            }
        } else {
            System.out.println("The member is now registered as a recreational swimmer.");
        }

        while (true) {
            int back = InputValidation.ReadInt("Press 0 to get back to the menu:");
            if (back == 0) {
                return;
            }
        }
    }

    @Override
    public String toString() {
        return name + "," + age + "," + memberType + "," + paid + "," + swimType;
    }

    public String memberDisplay() {
        return "------------------------------------------------------------------------------------------\n" + "Name:" + name + " | " +
                "Age:" + age + " | " +
                "Type:" + memberType + " | " +
                "Paid:" + paid + " | " +
                "SwimType:" + swimType;

    }
}

