package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository<T> implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add(gun);
    }

    @Override
    public boolean remove(Gun gun) {
        return this.models.remove(gun);
    }

    @Override
    public Gun findByName(String name) {
        return this.models.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
