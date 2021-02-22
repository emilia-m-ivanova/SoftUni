package MilitaryElite;

import java.util.Arrays;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void completeMission(){
        this.state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: ",this.codeName,
                this.state.toString().charAt(0) )+ this.state.toString();
    }
}
