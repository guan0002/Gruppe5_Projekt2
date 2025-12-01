import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatabaseCompetitionMember {

    public static void saveCompetitionDatabase() throws IOException {

        // --- Save Juniors ---
        try (PrintWriter out = new PrintWriter(new FileWriter("src/juniorCompetition.txt"))) {
            for (CompetitionMember cm : CompetitionMember.juniorCompetitionList) {
                out.println(cm.toString());
            }
        }

        // --- Save Seniors ---
        try (PrintWriter out = new PrintWriter(new FileWriter("src/seniorCompetition.txt"))) {
            for (CompetitionMember cm : CompetitionMember.seniorCompetitionList) {
                out.println(cm.toString());
            }
        }

        System.out.println("Competition database saved.");
    }

}
