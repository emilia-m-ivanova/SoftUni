public class Cat {
    private String name;
    double specialParam;

    public Cat (String name, double specialParam){
        this.name = name;
        this.specialParam = specialParam;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name +
                " " +
                String.format("%.2f",this.specialParam);
    }
}
