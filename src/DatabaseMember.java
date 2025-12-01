import java.io.*;
import java.util.ArrayList;

public class DatabaseMember {

    public static ArrayList<Members> loadDatabase() throws IOException {
        ArrayList<Members> members = new ArrayList<>();

        FileReader cdb = new FileReader("src/DatabaseMember.txt");
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
            String swimType = entry.length >= 5 ? entry[4] : "Recreational";

            Members m = new Members(name, Integer.parseInt(age), memberType, paid, swimType);
            members.add(m);

            line = load.readLine();
        }
        load.close();
        return members;
    }

    public static void saveMembersToFile(ArrayList<Members> members) throws IOException {
        FileWriter file = new FileWriter("src/DatabaseMember.txt", false);
        PrintWriter out = new PrintWriter(file);

        for (Members m : members) {
            out.println(m.toString());
        }

        out.close();
    }

    // ------------------------------------------------------------------------------

    public static void loadCompetitionDatabase() throws IOException {


        try (BufferedReader br = new BufferedReader(new FileReader("src/juniorCompetition.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] entry = line.split(",");
                if (entry.length < 5) continue;

                String name = entry[0];
                int age = Integer.parseInt(entry[1]);
                String memberType = entry[2];
                String paid = entry[3];
                String swimType = entry[4];

                CompetitionMember cm = new CompetitionMember(name, age, memberType, paid, swimType);
                CompetitionMember.juniorCompetitionList.add(cm);
            }
        } catch (FileNotFoundException e) {
            System.out.println("juniorCompetition.txt not found yet.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/seniorCompetition.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] entry = line.split(",");
                if (entry.length < 5) continue;

                String name = entry[0];
                int age = Integer.parseInt(entry[1]);
                String memberType = entry[2];
                String paid = entry[3];
                String swimType = entry[4];

                CompetitionMember cm = new CompetitionMember(name, age, memberType, paid, swimType);
                CompetitionMember.seniorCompetitionList.add(cm);
            }
        } catch (FileNotFoundException e) {
            System.out.println("seniorCompetition.txt not found yet.");
        }

        System.out.println("Competition database loaded.");
    }


    // ------------------------------------------------------------------------------


    //opdaterer kunde i customerDatabase.txt
    static void saveMembers(Members m) throws IOException {
        FileWriter file = new FileWriter("src/customerDatabase.txt", true);
        PrintWriter updateList = new PrintWriter(file);

        updateList.println(m.toString());
        updateList.close();
    }


    public static Members findMemberByName(String name) throws IOException {
        ArrayList<Members> members = loadDatabase();

        for (Members m : members) {
            if (m.name.equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public static void deleteMember(String name) throws IOException {
        ArrayList<Members> members = loadDatabase();
        boolean removed = members.removeIf(m -> m.name.equalsIgnoreCase(name));

        if (!removed) {
            System.out.println("Member not found.");
            return;
        }

        FileWriter writer = new FileWriter("src/DatabaseMember.txt", false);
        PrintWriter dc = new PrintWriter(writer);

        for (Members m : members) {
            dc.println(m.toString());
        }
        dc.close();
        System.out.println("Member deleted: " + name);
    }


}

