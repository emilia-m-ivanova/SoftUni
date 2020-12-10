import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<String>> pieces = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String [] piece = scanner.nextLine().split("\\|");
            pieces.put(piece[0],new ArrayList<>(){{add(piece[1]);add(piece[2]);}});
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String[]command = input.split("\\|");
            String piece = command[1];
            switch (command[0]){
                case "Add":
                    String composer = command[2];
                    String key = command[3];
                    if(pieces.containsKey(piece)){
                        System.out.println(piece + " is already in the collection!");
                    }else{
                        pieces.put(piece,new ArrayList<>(){{add(composer);add(key);}});
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }
                    break;
                case "Remove":
                    if(pieces.containsKey(piece)){
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = command [2];
                    if(pieces.containsKey(piece)){
                        pieces.get(piece).set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        pieces.forEach((k,v)-> System.out.printf("%s -> Composer: %s, Key: %s%n",k,v.get(0),v.get(1)));
    }
}

