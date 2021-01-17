package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        if(0 > age){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + System.lineSeparator() +
                this.name + " " + this.age + " " + this.gender + System.lineSeparator() +
                this.produceSound();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
