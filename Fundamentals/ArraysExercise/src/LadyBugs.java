import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] indexAsString = line.split(" ");
        int[] index = new int[indexAsString.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = Integer.parseInt(indexAsString[i]);
        }
        int[] field = new int[fieldSize];
        for (int i = 0; i < field.length; i++) {
            for (int element : index) {
                if (element == i) {
                    field[i] = 1;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] arrayCommand = command.split(" ");
            int ladybugIndex = Integer.parseInt(arrayCommand[0]);
            int flyLength = Integer.parseInt(arrayCommand[2]);
            if ((0 <= ladybugIndex && ladybugIndex < field.length) && field[ladybugIndex] == 1) {

                field[ladybugIndex] = 0;

                if (arrayCommand[1].equals("right")) {

                    for (int i = ladybugIndex + flyLength; field.length > i && i >= 0; i+=flyLength) {
                        if (field[i] == 0) {
                            field[i] = 1;
                            break;
                        }
                    }
                } else if (arrayCommand[1].equals("left")) {

                    for (int i = ladybugIndex - flyLength; fieldSize > i && i >= 0; i-=flyLength) {
                        if (field[i] == 0) {
                            field[i] = 1;
                            break;
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }
        for (int element : field) {
            System.out.print(element + " ");
        }
    }
}
