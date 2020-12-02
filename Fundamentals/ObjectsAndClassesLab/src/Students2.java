import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

        public Student(String firstName, String lastName, String age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getHometown() {
            return this.hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentInfo = input.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            String age = studentInfo[2];
            String town = studentInfo[3];
            boolean studentExists = false;
            for (Student student : students) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    student.setAge(age);
                    student.setHometown(town);
                    studentExists = true;
                }
            }
            if (!studentExists) {
                Student newStudent = new Student(firstName, lastName, age, town);
                students.add(newStudent);
            }
            input = scanner.nextLine();

        }
        String filterTown = scanner.nextLine();
        for (Student student : students) {
            if (filterTown.equals(student.getHometown())) {
                System.out.printf("%s %s is %s years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
}
