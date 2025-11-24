import java.util.Scanner;

public class Members {
    String name;
    int age;
    String memberType;

    public Members(String name, int age, String memberType){
        this.name=name;
        this.age=age;
        this.memberType=memberType;

    }
    public static void registerMember(){
        Scanner input = new Scanner(System.in);

        System.out.println("Write member name");
        String name = input.nextLine();

        System.out.println("Write age");
        int age = input.nextInt();           // Vi laver senere en loop

        System.out.println("Write membertype \n Junior Member \n Senior Member \n Retired Member \n Passiv Member");
        String memberType = input.nextLine();
    }
}

