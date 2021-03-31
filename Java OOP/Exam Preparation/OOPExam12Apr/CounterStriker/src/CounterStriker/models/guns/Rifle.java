package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_TO_FIRE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        return this.decreaseBullets(BULLETS_TO_FIRE);
    }
}