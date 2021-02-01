package FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.checkLetters(firstName,"First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.checkLetters(lastName,"Last");
        this.lastName = lastName;
    }

    private void checkLetters(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if(this.age<30){
            bonus/=2;
        }
        this.setSalary(this.salary + this.salary*bonus/100);
    }


    @Override
    public String toString() {
        return String.format("%s %s gets %s leva.", this.firstName, this.lastName, this.salary);
    }
}
