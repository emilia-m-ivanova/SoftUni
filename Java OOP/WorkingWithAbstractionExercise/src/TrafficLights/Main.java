package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLight[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e->TrafficLight.valueOf(e.toUpperCase()))
                .toArray(TrafficLight[]::new);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                int ordinal = lights[j].ordinal() + 1;
                lights[j] = TrafficLight.values()[ordinal%TrafficLight.values().length];
                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
