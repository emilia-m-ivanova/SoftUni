import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> forceBook = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            String forceSide = null;
            String forceUser = null;
            if (input.contains("|")) {
                String[] array = input.split("\\s+\\|\\s+");
                forceSide = array[0];
                forceUser = array[1];
            } else if(input.contains("->")){
                String[] array = input.split("\\s+->\\s+");
                forceUser = array[0];
                forceSide = array[1];
                String key = "";
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    for (String s : entry.getValue()) {
                        if (s.equals(forceUser)) {
                            key = entry.getKey();
                            break;
                        }
                    }
                }
                if (!key.equals("")) {
                    forceBook.get(key).remove(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            forceBook.putIfAbsent(forceSide, new ArrayList<>());
            String finalForceUser = forceUser;
            boolean userExists = forceBook.values()
                    .stream()
                    .anyMatch(v->v.contains(finalForceUser));
            if(!userExists){
                forceBook.get(forceSide).add(forceUser);
            }

            input = scanner.nextLine();
        }

        forceBook.entrySet()
                .stream()
                .filter(e->e.getValue().size()>0)
                .sorted((a,b)->Integer.compare(b.getValue().size(),a.getValue().size()))
                .forEach(e->{
                    System.out.printf("Side: %s, Members: %d%n",e.getKey(),
                    e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted()
                            .forEach(v-> System.out.println("! "+v));
                });
    }
}