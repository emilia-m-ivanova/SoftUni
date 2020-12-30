import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String name;
    private List<Employee> employeesList;

    public Department(String name) {
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public double getAverageSalary() {
        return employeesList
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }

    @Override
    public String toString() {
        LinkedHashSet<String> set = employeesList.stream()
                .sorted((a,b)->Double.compare(b.getSalary(),a.getSalary()))
                .map(Employee::toString)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return String.format("Highest Average Salary: %s%n",this.name) + String.join(System.lineSeparator(),set);

    }
}
