import java.util.ArrayList;

public class CompetitionMember extends Members {

    private String swimType;
    ArrayList<CompetitionMember> juniorCompetitionList = new ArrayList<>();
    ArrayList<CompetitionMember> seniorCompetitionList = new ArrayList<>();

    public CompetitionMember(String name, int age, String memberType, String paid, String swimType) {
        super(name, age, memberType, paid);
        this.swimType = swimType;
    }

    public String getSwimType() {
        return swimType = "";
    }

    @Override
    public String toString() {
        return super.toString() + ", Swim Type: " + swimType;
    }

    public boolean tryAddToCompetition() {
        String mt = this.memberType == null ? "" : this.memberType;

        if (mt.equalsIgnoreCase("Passive") || mt.toLowerCase().contains("retired")) {
            return false;
        }

        if (!this.swimType.equalsIgnoreCase("Competition")) {
            return false;
        }

        if (this.age < 18) {
            juniorCompetitionList.add(this);
            return true;
        }
        else if (this.age>=18 && this.age<60){
            seniorCompetitionList.add(this);
            return true;
        }
        else {
            return false;
        }
    }
}
