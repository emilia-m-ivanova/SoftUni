package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if(this.capacity>this.employees.size()){
            this.employees.add(employee);
        }
    }

    public boolean remove (String name){
        return this.employees.removeIf(p->p.getName().equals(name));
    }

    public Employee getOldestEmployee(){
        return  this.employees.stream()
                .sorted((a,b)->b.getAge()-a.getAge())
                .findFirst()
                .get();
    }

    public Employee getEmployee(String name){
        return this.employees.stream()
                .filter(e->e.getName().equals(name))
                .findFirst()
                .get();
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
