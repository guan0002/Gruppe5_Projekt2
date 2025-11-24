package listFramework;

import java.io.*;
import java.util.ArrayList;

public class CompetitionDatabase {

    public static ArrayList<Member> loadDatabase() throws IOException {
        ArrayList<Member> members = new ArrayList<>();

        FileReader cdb = new FileReader("src/CompetitionDatabase.txt");
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null) {
            String[] entry = line.split(",");

            if (entry.length < 4) {
                line = load.readLine();
                continue;
            }

            String name = entry[0];
            String age = entry[1];
            String memberType = entry[2];
            String paid = entry[3];

            Member m = new Member(name, age, memberType, paid);
            members.add(m);

            line = load.readLine();
        }
        load.close();
        return members;
    }

    public static void saveMembersToFile(ArrayList<Member> members) throws IOException {
        FileWriter file = new FileWriter("src/CompetitionDatabase.txt", false);
        PrintWriter out = new PrintWriter(file);

        for (Member m : members) {
            out.println(m.toString());
        }

        out.close();
    }

    public static Member findMemberByName(String name) throws IOException {
        ArrayList<Member> members = loadDatabase();

        for (Member m : members) {
            if (m.name.equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public static void deleteMember(String name) throws IOException {
        ArrayList<Member> members = loadDatabase();
        boolean removed = members.removeIf(m -> m.name.equalsIgnoreCase(name));

        if (!removed) {
            System.out.println("Member not found.");
            return;
        }

        FileWriter writer = new FileWriter("src/CompetitionDatabase.txt", false);
        PrintWriter dc = new PrintWriter(writer);

        for (Member m : members) {
            dc.println(m.toString());
        }
        dc.close();
        System.out.println("Member deleted: " + name);
    }
}

