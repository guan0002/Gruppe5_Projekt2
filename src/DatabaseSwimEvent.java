import java.io.*;
import java.time.LocalDate;

public class DatabaseSwimEvent {
    public static void saveEventDatabase() throws IOException {

        // --- Save Event ---
        try (PrintWriter out = new PrintWriter(new FileWriter("src/DatabaseSwimEvents.txt"))) {
            for (SwimEvent se : SwimEvent.eventList) {
                out.println(se.toString());
            }
        }
        System.out.println("Even database updated.");
    }

    public static void loadEventDatabase() throws IOException {


        try (BufferedReader br = new BufferedReader(new FileReader("src/DatabaseSwimEvents.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] entry = line.split(",");
                if (entry.length < 4) continue;

                String eventName = entry[0];
                String disciplin = entry[1];
                String location = entry[2];
                LocalDate date = LocalDate.parse(entry[3]);

                SwimEvent se = new SwimEvent(eventName, disciplin, location, date);
                SwimEvent.eventList.add(se);
            }
        } catch (FileNotFoundException e) {
            System.out.println("DatabaseSwimEvents.txt not found yet.");
        }

        System.out.println("Competition database loaded.");
    }
}
