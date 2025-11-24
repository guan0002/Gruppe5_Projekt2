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

            members.add(m);

            line = load.readLine();
        }
        load.close();
        return members;
    }
}
//opdaterer memberDatabase.txt med ny kunde
public static void savemembersToFile(ArrayList<member> members) throws IOException {

    FileWriter file = new FileWriter("src/memberDatabase.txt", false);
    PrintWriter out = new PrintWriter(file);

    for (member m : members) {
        out.println(m.toString());
    }

    out.close();
}
//søgefunktion til at finde en kunde ud fra navn
public static member findmemberByName(String name) throws IOException {
    ArrayList<member> member = memberDatabase.loadDatabase();

    for (member m : member) {
        if (m.name.equalsIgnoreCase(name)) {
            return m;
        }
    }
    return null;
}
//sletter kunde
static void deletemember(String name) throws IOException {
    ArrayList<member> members = loadDatabase();
    boolean removed = members.removeIf(m -> m.name.equalsIgnoreCase(name));   //finder kunde ud fra indtastet navn

    if (!removed) {
        System.out.println("member not found.");
        return;
    }

    FileWriter writer = new FileWriter("src/memberDatabase.txt", false);
    PrintWriter dc = new PrintWriter(writer);

    for (member m : members) {
        dc.println(m.toString());
    }
    dc.close();
    System.out.println("member deleted: " + name);
}

