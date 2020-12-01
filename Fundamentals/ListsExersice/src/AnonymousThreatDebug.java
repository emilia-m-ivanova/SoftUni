import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreatDebug {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        List<String> line = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            line.add(input[i]);
        }

        String[] inputCommand = scan.nextLine().split("\\s+");
        String command = inputCommand[0];
        while (!command.equals("3:1")) {
            int startIndex;
            int endIndex;
            int index;
            int partitions;
            switch (command) {
                case "merge":
                    startIndex = Integer.parseInt(inputCommand[1]);
                    endIndex = Integer.parseInt(inputCommand[2]);
                    if (startIndex < 0 && line.size() - 1 < endIndex) {
                        startIndex = 0;
                        endIndex = line.size() - 1;
                    } else if (0 <= startIndex && startIndex <= line.size() - 1 && line.size() - 1 < endIndex) {
                        endIndex = line.size() - 1;
                    } else if (startIndex < 0 && endIndex <= line.size() - 1 && endIndex >= 0) {
                        startIndex = 0;
                    }

                    if (0 <= startIndex && endIndex < line.size()) {
                        String tempStr = "";
                        int counter = 0;
                        for (int i = startIndex; i <= endIndex; i++) {
                            counter++;
                            tempStr += line.get(i);
                        }
                        for (int i = 0; i < counter; i++) {
                            line.remove(startIndex);
                        }
                        line.add(startIndex, tempStr);
                    }
                    break;
                case "divide":
                    index = Integer.parseInt(inputCommand[1]);
                    partitions = Integer.parseInt(inputCommand[2]);

                    StringBuilder temp = new StringBuilder();
                    temp.append(line.get(index));
                    if(partitions==0||partitions>temp.length()){
                        break;
                    }
                    String result = insertCharEachPartitionDistance(temp, partitions);
                    line.set(index, result);

                    break;
            }

            inputCommand = scan.nextLine().split("\\s+");
            command = inputCommand[0];
        }

        String[] output = new String[line.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = line.get(i);
            if (i == output.length - 1) {
                System.out.print(output[i] + "");
                break;
            }
            System.out.print(output[i] + " ");
        }
    }

    private static String insertCharEachPartitionDistance(StringBuilder temp, int partitions) {
        if (partitions <= temp.length()) {
            int partSize = temp.length() / partitions;
            int idx = partSize;
            char space = ' ';
            int counter = partitions - 1;
            while (idx <= temp.length() - 1) {
                if (counter == 0) {
                    break;
                }
                temp.insert(idx, space);
                counter--;
                idx = idx + partSize + 1;
            }
        }
        return temp.toString();
    }
}