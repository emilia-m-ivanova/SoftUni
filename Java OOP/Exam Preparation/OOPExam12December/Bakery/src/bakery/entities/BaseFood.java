package bakery.entities;

import bakery.common.ExceptionMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;

    protected BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f",
                this.name,this.portion,this.price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
