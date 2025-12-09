import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            Members.membersRegister = DatabaseMember.loadDatabase();
        } catch (IOException e) {
            System.out.println("Failed to load members database.");
            e.printStackTrace();
        }

        try {
            DatabaseMember.loadCompetitionDatabase();
        } catch (IOException e) {
            System.out.println("Failed to load competition database.");
        }

        try {
            DatabaseSwimEvent.loadEventDatabase();
        } catch (IOException e) {
            System.out.println("Failed to load event database.");
        }

        MainMenu.PrintMenus();

    }
}
