import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Students {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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

        public String getHometown(){
            return this.hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")){
            String[] studentInfo = input.split(" ");
            Student newStudent = new Student();
            newStudent.setFirstName(studentInfo[0]);
            newStudent.setLastName(studentInfo[1]);
            newStudent.setAge(studentInfo[2]);
            newStudent.setHometown(studentInfo[3]);
            students.add(newStudent);
            input=scanner.nextLine();
        }
        String filterTown = scanner.nextLine();
        for (Student student : students) {
            if(filterTown.equals(student.getHometown())){
                System.out.printf("%s %s is %s years old%n",
                        student.getFirstName(),student.getLastName(),student.getAge());
            }
        }


    }
}
