import java.time.LocalDate;
import java.util.Scanner;

public class SwimDicipline {

    String diciplineType;
    String event;
    int rank;
    double time;
    LocalDate date;

    public SwimDicipline(String diciplineType, String event, int rank, double time, LocalDate date) {
        this.diciplineType=diciplineType;
        this.event=event;
        this.rank=rank;
        this.time=time;
        this.date=date;
    }

    public SwimDicipline registerDicipline() {
        Scanner input = new Scanner(System.in);
        boolean correctDicipline=false;
        diciplineType="";
        event="";
        rank=0;
        time=0.0;
        date = null;

        while(!correctDicipline)
        System.out.println("What is the dicipline?");
        diciplineType=input.nextLine();
        if (diciplineType.equalsIgnoreCase("Crawl") || diciplineType.equalsIgnoreCase("Breast Swim") ||
                diciplineType.equalsIgnoreCase("Back Swim") || diciplineType.equalsIgnoreCase("Butterfly")) {
            correctDicipline=true;
        }
        else {
            System.out.println("Invalid swim dicipline! ⚠️ Please write one of the 4 dicipline options...");
            correctDicipline=false;
        }

        System.out.println("What event was the dicipline performed at?");
        event=input.nextLine();

        System.out.println("How did the competitor rank at the event?");
        rank=input.nextInt();

        System.out.println("What was the competitors time?");
        time= input.nextDouble();

        System.out.println("What was the date of the event?");
        while (date == null) {
            System.out.println("Please enter a date dd/mm/yyyy:");
            String dateStr = input.nextLine();
            try {
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(dateStr, formatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        SwimDicipline sd = new SwimDicipline(diciplineType, event, rank, time, date);
        return sd;
    }

}
