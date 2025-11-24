import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class memberDatabase {
    public static ArrayList<member> loadDatabase() throws IOException {
        ArrayList<member> members = new ArrayList<>(); //TBD

        FileReader cdb = new FileReader("src/memberDatabase.txt");//Tilgår customerDatabase.txt
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null) {
            String[] entry = line.split(",");

            if (entry.length < 4) {
                line = load.readLine();
                continue; // hopper over den forkerte linje
            }
            String name = entry[0]; //TBD
            String memberType = entry[1]; //TBD
            String paid = entry[2]; //TBD
        }
    }
}
