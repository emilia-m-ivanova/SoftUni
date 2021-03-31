package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    protected int decreaseBullets(int bulletsCount) {
        bulletsCount = Math.min(bulletsCount, this.bulletsCount);
        this.bulletsCount -= bulletsCount;
        return bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

}
