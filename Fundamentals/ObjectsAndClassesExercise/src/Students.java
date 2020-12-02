import java.util.*;

public class Students {

    static class Student {
        String firstName;
        String secondName;
        double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public double getGrade() {
            return this.grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f",firstName,secondName,grade);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentArray = scanner.nextLine().split("\\s+");
            Student student = new Student(studentArray[0], studentArray[1], Double.parseDouble(studentArray[2]));
            studentList.add(student);
        }
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

    }
}
