package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(this.capacity>this.roster.size()){
            this.roster.add(player);
        }
    }

    public boolean removePlayer (String name){
        return this.roster.removeIf(p->p.getName().equals(name));
    }

    public void promotePlayer (String name){
        Player player = this.roster.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .orElse(null);
        assert player != null;
        player.setRank("Member");
    }

    public void demotePlayer (String name){
        Player player = this.roster.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .orElse(null);
        assert player != null;
        player.setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz){

        Player[] kickedPlayers = this.roster.stream()
                .filter(p->p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        this.roster.removeIf(p->p.getClazz().equals(clazz));
        return kickedPlayers;
    }

    public int count(){
        return this.roster.size();
    }

    public String report() {
     StringBuilder sb = new StringBuilder();
     sb.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player player : this.roster) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
