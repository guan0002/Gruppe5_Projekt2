import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.Scanner;

public class SwimEvent {

    String diciplineType;
    String name;
    int rank;
    double time;
    LocalDate date;

    public SwimEvent(String name, String diciplineType, int rank, double time, LocalDate date) {
        this.diciplineType=diciplineType;
        this.name=name;
        this.rank=rank;
        this.time=time;
        this.date=date;
    }

    public SwimEvent registerEventMember() {
        Scanner input = new Scanner(System.in);
        boolean correctDicipline=false;
        diciplineType="";
        name="";
        rank=0;
        time=0.0;
        date = null;
        String member;

        System.out.println("Which Competition Member would you like to add an event to?");
         member = input.nextLine();
        boolean added = CompetitionMember.addedIf(cm -> cm.name.equalsIgnoreCase(name));



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
        name=input.nextLine();

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

        SwimEvent event = new SwimEvent(name, diciplineType, rank, time, date);
        return event;
    }



}
