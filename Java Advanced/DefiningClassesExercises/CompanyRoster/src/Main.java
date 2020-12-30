import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Department> departments = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee employee;
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email;
            int age;
            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }
            Department currentDepartment;
            boolean departmentExists = departments.stream()
                    .anyMatch(d -> d.getName().equals(employee.getDepartment()));
            if (!departmentExists) {
                currentDepartment = new Department(employee.getDepartment());
                departments.add(currentDepartment);
            }
            currentDepartment = departments.stream()
                    .filter(d->d.getName().equals(employee.getDepartment()))
                    .findAny()
                    .get();
            currentDepartment.getEmployeesList().add(employee);
        }
        Department bestDepartment = departments.stream()
                .max(Comparator.comparingDouble(Department::getAverageSalary))
                .get();
        System.out.println(bestDepartment.toString());
    }
}
