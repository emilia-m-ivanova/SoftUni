public class Cymric extends Cat{

    public Cymric (String name, double furLength){
        super(name,furLength);
    }

    @Override
    public String toString() {
        return "Cymric " +
                super.toString();
    }
}
