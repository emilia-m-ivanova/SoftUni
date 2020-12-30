public class StreetExtraordinaire extends Cat{

    public StreetExtraordinaire (String name, double decibelsOfMeows){
        super(name,decibelsOfMeows);
    }

    @Override
    public String toString() {
        return "StreetExtraordinaire " +
                super.toString();
    }
}
