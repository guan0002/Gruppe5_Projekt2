/* import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    private void addMember(Member m) {
        members.add(m);
    }

    public boolean registerMember(Member m) {
        if (m.isPassive()) {
            System.out.println("Error: You're not able to join the team");
            return false;

        }

        addMember(m);
        return true;

    }

    public void printMembers() {
        for (Member m : members) {
            System.out.println(m.getName());
        }
    }
}

 */