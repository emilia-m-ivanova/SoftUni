package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository<T> implements Repository<Player> {
    private List<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return this.models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return this.models.stream()
                .filter(e -> e.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
