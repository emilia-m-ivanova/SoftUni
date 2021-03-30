package bakery.repositories;

import bakery.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public abstract class RepositoryImpl<T> implements Repository<T> {
    private final LinkedHashSet<T> models;

    public RepositoryImpl() {
        this.models = new LinkedHashSet<>();
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T o) {
        models.add(o);
    }
}
