package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStat(endurance,"Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStat(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStat(dribble,"Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStat(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStat(shooting,"Shooting");
        this.shooting = shooting;
    }

    private void validateStat(int value, String statName) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }

    public double overallSkillLevel() {
        return (double) (endurance + sprint + dribble + passing + shooting) / 5;
    }
}
