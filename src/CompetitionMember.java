import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionMember extends Members {

    private String swimType;
    static ArrayList<CompetitionMember> juniorCompetitionList = new ArrayList<>();
    static ArrayList<CompetitionMember> seniorCompetitionList = new ArrayList<>();

    public CompetitionMember(String name, int age, String memberType, String paid, String swimType) {
        super(name, age, memberType, paid, swimType);
        this.swimType=swimType;
    }

    public String getSwimType() {
        return swimType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Swim Type: " + swimType;
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
        Scanner input = new Scanner(System.in);
        boolean backToMenu = false;


        if (Members.membersRegister.isEmpty()) {
            System.out.println("No members have been registered yet.");

        }
        else {
            System.out.println("Junior competition:");
            for (CompetitionMember cm : juniorCompetitionList) System.out.println(cm);

            System.out.println("Senior competition");
            for (CompetitionMember cm : seniorCompetitionList) System.out.println(cm);
        }

        while (!backToMenu) {
            int back = InputValidation.ReadInt("Press 0 to go back to the main menu");
            if (back == 0) {
                backToMenu = true;
            } else {
                System.out.println("Press 0 to get back to the menu");
            }
        }
    }
}
