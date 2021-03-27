package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.*;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double income = 0;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = null;
        if (type.equals("Cake")) {
            food = new Cake(name, price);
        } else if (type.equals("Bread")){
            food = new Bread(name, price);
        }
        BakedFood byName = this.foodRepository.getByName(name);
        if (byName != null) {
            throw new IllegalArgumentException(String.format
                    (ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        this.foodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED,
                name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = null;
        if (type.equals("Tea")) {
            drink = new Tea(name, portion, brand);
        } else if (type.equals("Water")){
            drink = new Water(name, portion, brand);
        }
        Drink byName = this.drinkRepository.getByNameAndBrand(name, brand);
        if (byName != null) {
            throw new IllegalArgumentException(String.format
                    (ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        this.drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED,
                name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (type.equals("InsideTable")) {
            table = new InsideTable(tableNumber, capacity);
        } else if (type.equals("OutsideTable")){
            table = new OutsideTable(tableNumber, capacity);
        }
        Table byNumber = this.tableRepository.getByNumber(tableNumber);
        if (byNumber != null) {
            throw new IllegalArgumentException(String.format
                    (ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        this.tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED,
                tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = null;
        Collection<Table> tables = this.tableRepository.getAll();
        for (Table t : tables) {
            if(!t.isReserved() && t.getCapacity() >= numberOfPeople){
                table = t;
                break;
            }
        }

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED,
                table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        BakedFood food = this.foodRepository.getByName(foodName);

        if (table == null || !table.isReserved()) {
            return "Could not find table " + tableNumber;
        }

        if(food==null){
            return String.format(OutputMessages.NONE_EXISTENT_FOOD,foodName);
        }

        table.orderFood(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL,tableNumber,foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        Drink drink = this.drinkRepository.getByNameAndBrand(drinkName,drinkBrand);

        if (table == null || !table.isReserved()) {
            return "Could not find table " + tableNumber;
        }

        if(drink==null){
            return String.format(OutputMessages.NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }

        table.orderDrink(drink);
        return String.format(OutputMessages.DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        income+=bill;
        table.clear();
        return String.format(OutputMessages.BILL,tableNumber,bill);
    }

    @Override
    public String getFreeTablesInfo() {
        Collection<Table> list = tableRepository.getAll();
        StringBuilder sb = new StringBuilder();
        for (Table table : list) {
            if(!table.isReserved()){
                sb.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessages.TOTAL_INCOME,this.income);
    }
}
