import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine implements Runnable{

    EntityManager em;
    Scanner in;
    PrintStream out;

    public Engine(EntityManager em, Scanner in, PrintStream out) {
        this.em = em;
        this.in = in;
        this.out = out;
    }

    public void run() {
        //ex 2
        //changeCasing();
        //ex 3
        //containsEmployee();
        //ex 4
        //employeesWithSalary();
        //ex 5
        //employeesFromDepartment();
        //ex 6
        //addNewAddress();
        //ex 7
        //addressesWithEmployeeCount();
        //ex 8
        //getEmployeeWithProject();
        //ex 9
        //findLatest10Projects();
        //ex 10
        //increaseSalaries();
        //ex 11
        //findEmployeesByFirstName();
        //ex 12
        //employeesMaxSalaries();
        //ex 13
        //removeTowns();
    }


    //ex 2
    private void changeCasing() {
        List<Town> towns = em.createQuery(
                "SELECT t FROM Town t",Town.class).getResultList();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        towns.stream()
                .filter(t->t.getName().length()<=5)
                .forEach(t->em.detach(t));
        towns.forEach(t->t.setName(t.getName().toLowerCase()));
        transaction.commit();
    }

    //ex 3
    private void containsEmployee() {
        out.println("Enter employee full name: ");
        String[] fullName = in.nextLine().split("\\s+");
        List<Long> result = em.createQuery("SELECT e.id FROM Employee e " +
                "WHERE e.firstName = ?1 AND e.lastName = ?2",Long.class)
                .setParameter(1, fullName[0])
                .setParameter(2, fullName[1])
                .getResultList();
        out.println(result.size()==0? "No" : "Yes");
    }

    //ex 4
    private void employeesWithSalary() {
        em.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000",String.class)
                .getResultList()
                .forEach(out::println);
    }

    //ex 5
    private void employeesFromDepartment() {
        em.createQuery("SELECT CONCAT(e.firstName, ' ', e.lastName, ' from Research and Development - $', e.salary) " +
                "FROM Employee e " +
                "WHERE e.department.name = 'Research and Development' " +
                "ORDER BY e.salary, e.id",String.class)
                .getResultList()
                .forEach(out::println);
    }

    // ex 6
    private void addNewAddress() {
        Address address = new Address();
        address.setText("Vitoshka 15");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(address);
        transaction.commit();
        out.println("Enter employee last name");
        String lastName = in.nextLine();
        Optional<Employee> employee = em.createQuery("SELECT e FROM Employee e WHERE e.lastName = ?1", Employee.class)
                .setParameter(1, lastName)
                .getResultList()
                .stream().findFirst();
        if(employee.isEmpty()){
            out.printf("Employee with last name %s doesn't exist", lastName);
        }else {
            transaction.begin();
            employee.get().setAddress(address);
            transaction.commit();
        }
    }

    //ex 7
    private void addressesWithEmployeeCount() {
        em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC ",Address.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .forEach(a->out.printf("%s, %s - %d employees%n",a.getText(),a.getTown().getName(),a.getEmployees().size()));
    }

    //ex 8

    private void getEmployeeWithProject() {
        out.println("Enter employee ID: ");
        int id = Integer.parseInt(in.nextLine());
        Optional<Employee> employeeByID = em.createQuery("SELECT e FROM Employee e WHERE e.id = ?1", Employee.class)
                .setParameter(1, id)
                .getResultList()
                .stream().findFirst();
        if(employeeByID.isEmpty()){
            out.printf("Employee with ID %d doesn't exist",id);
        }else {
            Employee e = employeeByID.get();
            String projects = e.getProjects().stream()
                    .map(Project::getName)
                    .sorted()
                    .collect(Collectors.joining(System.lineSeparator() + "\t"));
            out.printf("%s %s - %s%n\t%s%n",e.getFirstName(),e.getLastName(),e.getJobTitle(),projects);
        }
    }

    //ex 9
    private void findLatest10Projects() {
        em.createQuery("SELECT p FROM Project p " +
                "ORDER BY p.startDate desc ",Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().map(p->String.format(
                        "Project name: %s%n\tProject Description: %s%n\tProject Start Date:%s%n\tProject End Date:%s",
                p.getName(),p.getDescription(),p.getStartDate(),p.getEndDate()))
                .forEach(out::println);
    }

    //ex 10
    private void increaseSalaries(){
        List<Employee> resultList = em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name IN ('Engineering','Tool Design','Marketing','Information Services')", Employee.class)
                .getResultList();
        EntityTransaction transaction = em.getTransaction();
        for (Employee e : resultList) {
            transaction.begin();
            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
            transaction.commit();
        }
        resultList.forEach(e-> System.out.printf("%s %s ($%.2f)%n",e.getFirstName(),e.getLastName(),e.getSalary()));
    }

    //ex 11
    private void findEmployeesByFirstName(){
        out.println("Enter search pattern: ");
        String pattern = in.nextLine();
        em.createQuery("SELECT e FROM Employee e WHERE e.firstName like ?1",Employee.class)
                .setParameter(1,pattern+"%")
                .getResultList()
                .forEach(e-> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()));
    }

    //ex 12
    private void employeesMaxSalaries(){
        em.createQuery("SELECT CONCAT(e.department.name, ' ', MAX(e.salary)) FROM Employee e " +
                "GROUP BY e.department.name " +
                "HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000",String.class)
                .getResultList()
                .stream()
                .forEach(System.out::println);
    }

    //ex 13
    private void removeTowns(){
        out.println("Enter town name: ");
        String town = in.nextLine();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery("UPDATE Employee e " +
                "SET e.address = NULL " +
                "WHERE e.address.id IN (" +
                "SELECT a.id FROM Address a JOIN Town t ON t.id = a.town.id WHERE t.name = ?1)")
                .setParameter(1, town)
                .executeUpdate();
        int n = em.createQuery("DELETE FROM Address a WHERE a.town IN(" +
                "SELECT t FROM Town t WHERE t.name = ?1)")
                .setParameter(1, town)
                .executeUpdate();
        em.createQuery("DELETE FROM Town t where t.name = ?1")
                .setParameter(1, town)
                .executeUpdate();
        transaction.commit();
        out.println(n + " addresses in " + town + " deleted");
    }
}




























