package ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person (String name, Integer age, String town){
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person that) {

        int result = this.getName().compareTo(that.getName());
        if(result==0){
            result = this.getAge().compareTo(that.getAge());
        }
        if(result==0){
            result = this.getTown().compareTo(that.getTown());
        }
        return result;
    }
}
