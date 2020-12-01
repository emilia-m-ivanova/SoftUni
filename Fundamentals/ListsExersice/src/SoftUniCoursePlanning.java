import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lessons = readList(scanner);
        String input = scanner.nextLine();
        while (!input.equals("course start")){
            String [] command = input.split(":");
            String lesson = command[1];
            String exercise = lesson+"-Exercise";
            switch (command[0]){
                case "Add":
                    if(!lessons.contains(lesson)){
                        lessons.add(lesson);
                    }
                    break;
                case "Insert":
                    if(!lessons.contains(lesson)){
                        lessons.add(Integer.parseInt(command[2]),lesson);
                    }
                    break;
                case "Remove":
                        lessons.remove(lesson);
                        lessons.remove(exercise);
                    break;
                case "Swap":
                    swapLessons(lessons, command, lesson,exercise);
                    break;
                case "Exercise":
                    addExercise(lessons, lesson, exercise);
                    break;
            }

            input=scanner.nextLine();
        }
        for (int i = 1; i <= lessons.size(); i++) {
            System.out.printf("%d.%s%n",i,lessons.get(i-1));
        }
    }

    private static void swapLessons(List<String> lessons, String[] command, String lesson,String exercise) {
        if(lessons.contains(lesson)&& lessons.contains(command[2])){
            for (int i = 0; i < lessons.size(); i++) {
                String exerciseSecond = command[2]+"-Exercise";
                String element = lessons.get(i);
                if(element.equals(lesson)){
                    lessons.set(i, command[2]);
                    if(lessons.contains(exerciseSecond)){
                        lessons.remove(exerciseSecond);
                        lessons.add(i+1,exerciseSecond);
                    }
                }else if(element.equals(command[2])){
                    lessons.set(i, lesson);
                    if(lessons.contains(exercise)){
                        lessons.remove(exercise);
                        lessons.add(i+1,exercise);
                    }
                }
            }
        }
    }

    private static void addExercise(List<String> lessons, String lesson, String exercise) {
        if(!lessons.contains(lesson)){
            lessons.add(lesson);
            lessons.add(exercise);
        }else if (!lessons.contains(exercise)){
            for (int i = 0; i < lessons.size(); i++) {
                String element = lessons.get(i);
                if(element.equals(lesson)){
                    lessons.add(i+1, exercise);
                }
            }
        }
    }

    private static List<String> readList(Scanner scanner) {
        String[] stringsArray = scanner.nextLine().split(", ");
        List<String> lessons = new ArrayList<>();
        for (String element : stringsArray) {
            lessons.add(element);
        }
        return lessons;
    }
}
