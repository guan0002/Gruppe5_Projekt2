import java.io.FileWriter;
import java.io.IOException;

public class DatabaseCompetitionMember {

    public static void saveCompetitionMembers() {


        try (FileWriter writer = new FileWriter("src/juniorCompetition.txt")) {
            for (CompetitionMember cm : CompetitionMember.juniorCompetitionList) {
                writer.write(cm.toString() + "\n");
            }
            System.out.println("Junior competition list saved.");
        } catch (IOException e) {
            System.out.println("Error writing junior competition file.");
        }


        try (FileWriter writer = new FileWriter("src/seniorCompetition.txt")) {
            for (CompetitionMember cm : CompetitionMember.seniorCompetitionList) {
                writer.write(cm.toString() + "\n");
            }
            System.out.println("Senior competition list saved.");
        } catch (IOException e) {
            System.out.println("Error writing senior competition file.");
        }
    }
}
