package EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public int compareTo(Person that) {
        int result = this.getName().compareTo(that.getName());
        if(result==0){
            result = this.getAge() - that.getAge();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (this.name.hashCode() + Integer.hashCode(age))*73;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(!(obj instanceof Person)){
            return false;
        }
        Person that = (Person) obj;
        return this.compareTo(that) == 0;
    }
}
