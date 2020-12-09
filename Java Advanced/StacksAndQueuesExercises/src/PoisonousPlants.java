import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            plants.push(scanner.nextInt());
        }
        int days = 0;
        ArrayDeque<Integer> plantsSurvived = new ArrayDeque<>();
        for (int i = 0; i < n; i++)  {
            boolean deadPlant = false;
            while (!plants.isEmpty()) {
                int current = plants.pop();
                if (plants.isEmpty()||plants.peek() > current) {
                    plantsSurvived.offer(current);
                }else{
                    deadPlant = true;
                }
            }
            if(!deadPlant){
                break;
            }
            plants.clear();
            plants.addAll(plantsSurvived);
            plantsSurvived.clear();
            days++;
        }
        System.out.println(days);
    }
}
