import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SwimEvent {

    public static ArrayList<SwimEvent> eventList = new ArrayList<>();
    private ArrayList<EventMember> eventMembers = new ArrayList<>();

    private String eventName;
    private String discipline;
    private String location;
    private LocalDate date;

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public SwimEvent(String eventName, String discipline, String location, LocalDate date) {
        this.eventName = eventName;
        this.discipline = discipline;
        this.location = location;
        this.date = date;

    }

    public static SwimEvent createEvent() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String eventName = input.nextLine();

        System.out.print("Enter discipline: ");
        String discipline = input.nextLine();

        System.out.print("Enter event location: ");
        String location = input.nextLine();

        System.out.print("Enter date (DD/MM/YYYY): ");
        String dateInput = input.nextLine();
        LocalDate date = LocalDate.parse(dateInput, DATE_FORMATTER);

        SwimEvent event = new  SwimEvent(eventName, discipline, location, date);
        eventList.add(event);

        System.out.println("Event saved!");

        while (true) {
            int back = InputValidation.ReadInt("Press 0 to return to the menu: ");
            if (back == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please press 0.");
            }
        }

        return event;
    } // createEvent()

    public void editEvent() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEditing event:");
        System.out.println(this);

        System.out.print("Enter new event name (or press ENTER to keep \"" + eventName + "\"): ");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            this.eventName = newName;
        }

        System.out.print("Enter new discipline (or press ENTER to keep \"" + discipline + "\"): ");
        String newDiscipline = input.nextLine();
        if (!newDiscipline.isEmpty()) {
            this.discipline = newDiscipline;
        }

        System.out.print("Enter new location (or press ENTER to keep \"" + location + "\"): ");
        String newLocation = input.nextLine();
        if (!newLocation.isEmpty()) {
            this.location = newLocation;
        }

        System.out.println("Enter a new date DD/MM/YYYY) or ENTER to keep \""
                + date.format(DATE_FORMATTER) + "\"): " );
        String dateInput = input.nextLine();
        if (!dateInput.isEmpty()) {
            this.date = LocalDate.parse(dateInput, DATE_FORMATTER);

        }

        System.out.println("Event updated!");

    } // editEvent()

    public static void editEventMenu() {
        if (eventList.isEmpty()) {
            System.out.println("No events to edit!");
            return;
        }

        System.out.println("\nChoose event to edit:");
        for (int i = 0; i < eventList.size(); i++) {
            System.out.println((i + 1) + ": " + eventList.get(i));
        }

        int choice = InputValidation.ReadInt("Enter event number: ") - 1;

        if (choice < 0 || choice >= eventList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        eventList.get(choice).editEvent();

        while (true) {
            int back = InputValidation.ReadInt("Press 0 to return to the menu: ");
            if (back == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please press 0.");
            }
        }
    } // editEventMenu

    public static void addMemberToEvent() {
        if (eventList.isEmpty()) {
            System.out.println("No events available! Please create an event first.");
            return;
        }

        System.out.println("Select event to add members to:");
        for (int i = 0; i < eventList.size(); i++) {
            System.out.println((i + 1) + ": " + eventList.get(i));
        }

        int eventChoice = InputValidation.ReadInt("Enter event number: ") - 1;
        if (eventChoice < 0 || eventChoice >= eventList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        SwimEvent selectedEvent = eventList.get(eventChoice);

        ArrayList<Members> fileMembers = new ArrayList<>();
        String[] files = {"src/DatabaseCompetitorsJunior.txt", "src/DatabaseCompetitorsSenior.txt"};

        for (String fileName : files) {
            try {
                Scanner fileScanner = new Scanner(new java.io.File(fileName));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String memberType = parts[2];
                        String paid = parts[3];
                        String swimType = parts[4];

                        Members m = new Members(name, age, memberType, paid, swimType);
                        fileMembers.add(m);
                    }
                }
                fileScanner.close();
            } catch (java.io.FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            }
        }

        if (fileMembers.isEmpty()) {
            System.out.println("No registered members found in the files!");
            return;
        }

        boolean continueAdding = true;
        while (continueAdding) {

            System.out.println("Members from file:");
            for (int i = 0; i < fileMembers.size(); i++) {
                System.out.println((i + 1) + ": " + fileMembers.get(i).memberDisplay());
            }

            int memberChoice = InputValidation.ReadInt("Enter member number to add: ") - 1;
            if (memberChoice < 0 || memberChoice >= fileMembers.size()) {
                System.out.println("Invalid choice.");
                return;
            }

            Members selectedMember = fileMembers.get(memberChoice);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter swim time for " + selectedMember.name + ": ");
            double time = input.nextDouble();
            System.out.print("Enter swim rank for " + selectedMember.name + ": ");
            int rank = input.nextInt();
            input.nextLine();

            EventMember eventMember = new EventMember(selectedMember);
            eventMember.time = time;
            eventMember.rank = rank;

            selectedEvent.eventMembers.add(eventMember);
            System.out.println(selectedMember.name + " has been added to event " + selectedEvent.eventName);

            int addAnother = InputValidation.ReadInt("Do you want to add another member? (1: Yes, 2: No): ");
            if (addAnother != 1) {
                continueAdding = false;
                System.out.println("Finished adding members.");
            }
        }

        while (true) {
            int back = InputValidation.ReadInt("Press 0 to return to the menu: ");
            if (back == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please press 0.");
            }
        }
    } // addMemberToEvent()

    public static void showEvent() {
        if (eventList.isEmpty()) {
            System.out.println("No events available!");
            return;
        }

        System.out.println("Select event to view members:");
        for (int i = 0; i < eventList.size(); i++) {
            System.out.println((i + 1) + ": " + eventList.get(i));
        }

        int eventChoice = InputValidation.ReadInt("Enter event number: ") - 1;
        if (eventChoice < 0 || eventChoice >= eventList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        SwimEvent selectedEvent = eventList.get(eventChoice);

        if (selectedEvent.eventMembers.isEmpty()) {
            System.out.println("No members registered for this event.");
            return;
        }

        System.out.println("\nMembers in event " + selectedEvent.eventName + ":");
        for (int i = 0; i < selectedEvent.eventMembers.size(); i++) {
            System.out.println((i + 1) + ": " + selectedEvent.eventMembers.get(i));
        }

        while (true) {
            int back = InputValidation.ReadInt("Press 0 to return to the menu: ");
            if (back == 0) {
                break;
            } else {
                System.out.println("Invalid input. Please press 0.");
            }
        }
    } //showEvent()


    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Event: " + eventName +
                " | Discipline: " + discipline +
                " | Location: " + location +
                " | Date: " + date.format(DATE_FORMATTER);
    }

    public static class EventMember {
        Members member;
        double time;
        int rank;

        public EventMember(Members member) {
            this.member = member;
        }

        @Override
        public String toString() {
            return member.name + " (" + member.age + " y) | Time: " + time + " | Rank: " + rank;
        }
    } //EventMember
}
