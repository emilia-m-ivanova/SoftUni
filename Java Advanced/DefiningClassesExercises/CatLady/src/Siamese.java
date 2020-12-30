public class Siamese extends Cat{


    public Siamese (String name, double earSize){
        super(name,earSize);
    }

    @Override
    public String toString() {
        return "Siamese " +
                super.toString();
    }
}
