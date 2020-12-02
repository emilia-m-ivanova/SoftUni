import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email = "n/a";
        int age = -1;

        public Employee(String name,double salary, String position,
                        String department){
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setAge (int age){
            this.age = age;
        }
        public String getName(){
            return this.name;
        }
        public double getSalary(){
            return this.salary;
        }
        public String getEmail(){
            return this.email;
        }
        public String getDepartment(){
            return this.department;
        }
        public int getAge(){
            return this.age;
        }
    }
    static class Department{
        String name;
        int numberOfEmployees = 1;
        double sumSalaries;
        public void setName(String name){
            this.name = name;
        }
        public void addEmployee (){
            numberOfEmployees+=1;
        }
        public void addSalary (double salary){
            sumSalaries+=salary;
        }
        public String getName(){
            return this.name;
        }
        public double getAvSalary(){
            return sumSalaries/numberOfEmployees;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            Employee employee = new Employee(input[0],Double.parseDouble(input[1]),input[2],input[3]);
            if(input.length==5){
                if(input[4].contains("@")){
                    employee.setEmail(input[4]);
                }else{
                    employee.setAge(Integer.parseInt(input[4]));
                }
            }else if(input.length==6){
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            }
            employees.add(employee);
        }
        List<Department> departments = new ArrayList<>();
        for (Employee employee : employees) {
            String departmentName = employee.getDepartment();
            double salary = employee.getSalary();
            boolean departmentExists = false;
            for (Department department : departments) {
                if(department.getName().equals(departmentName)){
                    departmentExists=true;
                    department.setName(departmentName);
                    department.addEmployee();
                    department.addSalary(salary);
                }
            }
            if(!departmentExists){
                Department department = new Department();
                departments.add(department);
                department.setName(departmentName);
                department.addSalary(salary);
            }

        }
        double highestAv = 0;
        String bestDepartment ="";
        for (Department department : departments) {
            if (department.getAvSalary() > highestAv) {
                highestAv = department.getAvSalary();
                bestDepartment = department.getName();
            }
        }
        System.out.println("Highest Average Salary: "+bestDepartment);
        employees.sort((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary()));
        for (Employee employee : employees) {
            if(employee.getDepartment().equals(bestDepartment)){
                System.out.printf("%s %.2f %s %d%n",employee.getName(),employee.getSalary(),employee.getEmail(),employee.getAge());
            }
        }
    }
}
