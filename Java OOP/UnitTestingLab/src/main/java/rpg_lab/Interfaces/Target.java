package rpg_lab.Interfaces;

public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
