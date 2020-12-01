import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] integersAsStrings = scanner.nextLine().split("\\|");
        int[] array = new int[integersAsStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(integersAsStrings[i]);
        }
        String input = scanner.nextLine();
        int points = 0;
        while (!input.equals("Game over")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Shoot":
                    points += shootTarget(commands[1], array);
                    break;
                case "Reverse":
                    for (int i = 0; i < array.length / 2; i++) {
                        int temp = array[i];
                        array[i] = array[array.length - 1 - i];
                        array[array.length - 1 - i] = temp;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + " - ");
            } else {
                System.out.println(array[i]);
            }
        }
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }

    private static int shootTarget(String commands, int[] array) {
        String[] ints = commands.split("@");
        int startIndex = Integer.parseInt(ints[1]);
        int length = Integer.parseInt(ints[2]);
        int points = 0;
        if (0 <= startIndex && startIndex < array.length) {
            int index = 0;
            switch (ints[0]) {
                case "Left":
                    index = startIndex - length;
                    if (index < 0) {
                        length = length % array.length;
                        index = array.length + (startIndex - length);
                    }
                    break;
                case "Right":
                    index = startIndex + length;
                    if (index >= array.length) {
                        index = index % array.length;
                    }
                    break;
            }
            if (array[index] >= 5) {
                array[index] -= 5;
                points = 5;
            } else {
                points = array[index];
                array[index] = 0;
            }
        }
        return points;
    }
}
