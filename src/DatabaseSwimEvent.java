import java.io.*;
import java.time.LocalDate;

public class DatabaseSwimEvent {
    public static void saveEventDatabase() throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter("src/DatabaseSwimEvents.txt"))) {

            for (SwimEvent se : SwimEvent.eventList) {

                out.println(se.toDatabaseString());

                for (SwimEvent.EventMember em : se.eventMembers) {
                    out.println(em.toDatabaseString());
                }

                out.println();
            }
        }

        System.out.println("Event database updated.");
    }

    public static void loadEventDatabase() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("src/DatabaseSwimEvents.txt"))) {

            String line;
            SwimEvent currentEvent = null;

            while ((line = br.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) {
                    currentEvent = null;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String eventName = parts[0];
                    String discipline = parts[1];
                    String location = parts[2];
                    LocalDate date = LocalDate.parse(parts[3], SwimEvent.DATE_FORMATTER);

                    currentEvent = new SwimEvent(eventName, discipline, location, date);
                    SwimEvent.eventList.add(currentEvent);
                }

                else if (parts.length == 3 && currentEvent != null) {

                    String name = parts[0];
                    double time = Double.parseDouble(parts[1]);
                    int rank = Integer.parseInt(parts[2]);

                    Members m = new Members(name, 0, "", "", "");

                    SwimEvent.EventMember em = new SwimEvent.EventMember(m);
                    em.time = time;
                    em.rank = rank;

                    currentEvent.eventMembers.add(em);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("DatabaseSwimEvents.txt not found yet.");
        }

        System.out.println("Competition database loaded.");
    }

}
