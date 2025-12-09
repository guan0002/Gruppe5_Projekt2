import java.util.ArrayList;

public class CompetitionMember extends Members {

    private String swimType;
    static ArrayList<CompetitionMember> juniorCompetitionList = new ArrayList<>();
    static ArrayList<CompetitionMember> seniorCompetitionList = new ArrayList<>();

    public CompetitionMember(String name, int age, String memberType, String paid, String swimType) {
        super(name, age, memberType, paid, swimType);
        this.swimType = swimType;
    }

    public boolean tryAddToCompetition() {

        if (memberType.equalsIgnoreCase("Passive") || memberType.toLowerCase().contains("retired")) {
            return false;
        }

        if (!this.swimType.equalsIgnoreCase("Competitive")) {
            return false;
        }

        if (this.age < 18) {
            juniorCompetitionList.add(this);
            return true;
        } else if (this.age >= 18 && this.age < 60) {
            seniorCompetitionList.add(this);
            return true;
        } else {
            return false;
        }
    }

    public static void printcompetition() {

        if (Members.membersRegister.isEmpty()) {
            System.out.println("No members have been registered yet.");
        } else {
            int choice = InputValidation.ReadInt(
                    "1: Display Junior Competitors\n" + "2: Display Senior Competitors\n" + "0: Return to the main menu");
            if (choice == 1) {
                for (CompetitionMember cm : juniorCompetitionList) System.out.println(cm);
                {
                }
            } else if (choice == 2) {
                for (CompetitionMember cm : seniorCompetitionList) System.out.println(cm);

            }
                while (true) {
                    int back = InputValidation.ReadInt("Press 0 to get back to the menu:");
                    if (back == 0) {
                        return;
                    }

                }
            }
        }
    }



