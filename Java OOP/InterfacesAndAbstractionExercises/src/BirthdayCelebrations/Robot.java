package BirthdayCelebrations;

public class Robot implements Identifiable,Machine{
    private String model;
    private String id;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getModel(){
        return model;
    }
}
