package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl extends RepositoryImpl implements TableRepository {
    @Override
    public Table getByNumber(int number) {
        Collection<Table> tables = super.getAll();
        Table result = null;
        for (Table table : tables) {
            if(table.getTableNumber() == number){
                result = table;
                break;
            }
        }
        return result;
    }
}
