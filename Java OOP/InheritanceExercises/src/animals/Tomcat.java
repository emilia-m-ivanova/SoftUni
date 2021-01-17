package animals;

public class Tomcat extends Cat{
    public final static String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    public Tomcat(String name, int age, String gender) {
        this(name,age);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
