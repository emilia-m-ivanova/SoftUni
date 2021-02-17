package CarShopExtended;

public abstract class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String country;

    protected CarImpl(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }


    @Override
    public String toString() {
        return "This is " + model + " produced in " + country + " and have " + TIRES + " tires";
    }
}
