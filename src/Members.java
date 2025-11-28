import java.io.IOException;
import java.util.ArrayList;
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
        this.paid = paid;

    }

    public void registerMember() throws IOException {
        Scanner input = InputValidation.scanner;

        String name = InputValidation.ReadString("Write member name: ");
        int age = InputValidation.ReadInt("Write member age: ");

        String activity;
        while (true) {
            activity = InputValidation.ReadString("Is the member passive or active?");
            if (activity.equalsIgnoreCase("Active") || activity.equalsIgnoreCase("Passive")) {
                break;
            } else {
                System.out.println("Please write either Passive or Active");
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

        String paid;
        while (true) {
            paid = InputValidation.ReadString("Has the member paid? Yes or No");
            if (paid.equalsIgnoreCase("Yes") || paid.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("Please write either Yes or No");
            }
        }

        Members m = new Members(name, age, memberType, paid);
        membersRegister.add(m);
        DatabaseMember.saveMembersToFile(Members.membersRegister);


        while (true) {
            String team = InputValidation.ReadString("Does the member want to join a team? Type 'yes' or 'no'.");
            if (team.equalsIgnoreCase("Yes")) {
                break;

            } else if (team.equalsIgnoreCase("No")) {
                System.out.println("The member is now registered.");

                while (true) {
                    int back = InputValidation.ReadInt("Press 0 to get back to the menu:");
                    if (back == 0) {
                        return;
                    } else {
                        System.out.println("Invalid number. Press 0 to go back.");
                    }
                }

            } else {
                System.out.println("Invalid input — please write yes or no");
            }
        }

        String swimType = "";
        while (true) {
            swimType = InputValidation.ReadString("Is the member a recreational or competitive member?");
            if (swimType.equalsIgnoreCase("Competitive") || swimType.equalsIgnoreCase("Recreational")) {
                break;
            } else {
                System.out.println("Invalid input! Please write Recreational or Competitive");
            }
        }
        if (swimType.equalsIgnoreCase("Competitive")) {
            CompetitionMember cm = new CompetitionMember(name, age, memberType, paid, "Competitive");
            boolean added = cm.tryAddToCompetition();

            if (added) {
                System.out.println("The member is now registered as a competitive swimmer!");
            } else {
                System.out.println("Only active members within the allowed age range can be added to the list.");
            }
        } else {
            System.out.println("The member is now registered as a recreational swimmer");
        }
        while (true) {
            int back = InputValidation.ReadInt("Press 0 to get back to the menu:");
            if (back == 0) {
                break;
            } else {
                System.out.println("Press 0 to go back to the main menu");
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
                " Paid: " + paid;
    }
}

