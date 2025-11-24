import java.util.InputMismatchException;
import java.util.Scanner;

public class Members {
    String name;
    int age;
    String memberType;
    String paid;

    public Members(String name, int age, String memberType, String paid) {
        this.name = name;
        this.age = age;
        this.memberType = memberType;
        this.paid=paid;

    }

    public void registerMember() {
        Scanner input = new Scanner(System.in);
        boolean correctIntFormat = false;
        boolean correctMemberType = false;
        boolean correctPaid = false;

        System.out.println("Write member name");
        String name = input.nextLine();

        while (!correctIntFormat) {
            System.out.println("Write age");
            try {
               int age = input.nextInt();           // Vi laver senere en loop
                correctIntFormat = true;
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("We only accept numbers, not letters. Try again!");
                input.nextLine();
            }
        }

        while (!correctMemberType) {
            System.out.println("Write membertype: \n Junior Member \n Senior Member \n Retired Member \n Passive Member");
            String memberType = input.nextLine();
            if (memberType.equalsIgnoreCase("Junior Member") || memberType.equalsIgnoreCase("Senior Member") || memberType.equalsIgnoreCase("Retired Member") || memberType.equalsIgnoreCase("Passive Member")) {
                correctMemberType=true;
            }
            else {
                System.out.println("👇You have to choose one of the Member types that are offered below👇");
            }
        }

        while (!correctPaid) {
            System.out.println("Write yes if the member has paid or no for not paid");
            String paid = input.nextLine();
            if (paid.equalsIgnoreCase("Yes") || (paid.equalsIgnoreCase("No"))) {
                correctPaid = true;
            }
            else {
                System.out.println("You have to write yes or no");
            }
        }



        Members m = new Members(name, age, memberType, paid);
    }
}

