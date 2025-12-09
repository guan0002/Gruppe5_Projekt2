import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            Members.membersRegister = DatabaseMember.loadDatabase();
        } catch (IOException e) {
            System.out.println("ERROR: Unable to locate Member Database");
            e.printStackTrace();
        }

        try {
            DatabaseMember.loadCompetitionDatabase();
        } catch (IOException e) {
            System.out.println("ERROR: Unable to locate Competitor Database");
        }

        try {
            DatabaseSwimEvent.loadEventDatabase();
        } catch (IOException e) {
            System.out.println("ERROR: Unable to locate Event Database");
        }

        MainMenu.PrintMenus();

    }
}
