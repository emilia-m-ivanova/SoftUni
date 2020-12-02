import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        String typeList;
        String name;
        String time;

        public String getTypeList() {
            return this.typeList;
        }

        public String getName() {
            return this.name;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("_");
            Song s = new Song();
            s.setTypeList(input[0]);
            s.setName(input[1]);
            s.setTime(input[2]);
            songsList.add(s);
        }
        String printCommand = scanner.nextLine();
        for (Song song : songsList) {
            if (printCommand.equals(song.getTypeList()) || printCommand.equals("all")) {
                System.out.println(song.getName());
            }
        }
    }
}
