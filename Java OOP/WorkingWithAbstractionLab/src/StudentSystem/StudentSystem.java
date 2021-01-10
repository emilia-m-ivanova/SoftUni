package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {
        String name = args[1];
        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            showStudent(name);
        }
    }

    private void showStudent(String name) {
        if (repo.containsKey(name)) {
            Student student = repo.get(name);
            String output = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                output = output.concat(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output = output.concat(" Average student.");
            } else {
                output = output.concat(" Very nice person.");
            }

            System.out.println(output);
        }
    }

    private void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name)) {
            Student student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }
}