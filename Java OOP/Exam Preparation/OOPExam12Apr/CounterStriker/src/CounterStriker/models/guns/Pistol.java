package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    private static final int BULLETS_TO_FIRE = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        return this.decreaseBullets(BULLETS_TO_FIRE);
    }
}
