import java.io.*;
import java.util.ArrayList;

public class memberDatabase {
    public static ArrayList<member> loadDatabase() throws IOException {
        ArrayList<member> members = new ArrayList<>(); //TBD

        FileReader cdb = new FileReader("src/memberDatabase.txt");//Tilgår memberDatabase.txt
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null) {
            String[] entry = line.split(",");

            if (entry.length < 4) {
                line = load.readLine();
                continue; // hopper over den forkerte linje
            }
            String name         = entry [0];
            String age          = entry [1];
            String memberType   = entry [2];
            String paid         = entry [3]; //TBD

            member m = new member(name, age, memberType, paid);
            if (entry.length > 4) {
                try {


                }
            }
            members.add(m);

            line = load.readLine();
        }
        load.close();
        return members;
        }
    }
//opdaterer customerDatabase.txt med ny kunde
public static void saveCustomersToFile(ArrayList<Customer> customers) throws IOException {

    FileWriter file = new FileWriter("src/customerDatabase.txt", false);
    PrintWriter out = new PrintWriter(file);

    for (Customer c : customers) {
        out.println(c.toString());
    }

    out.close();
}
