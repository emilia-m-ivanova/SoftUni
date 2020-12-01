import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite2 {
    static class Dwarf{
        String name;
        String hat;
        public Dwarf(String name, String hat){
            this.name = name;
            this.hat = hat;
        }
        public String getName(){
            return this.name;
        }
        public String getHat(){
            return this.hat;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Dwarf,Integer> dwarfs = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] tokens = input.split(" <:> ");
            String name = tokens[0];
            String hat = tokens[1];
            int physics = Integer.parseInt(tokens[2]);
            Dwarf dwarf = new Dwarf(name,hat);
            boolean dwarfExists = false;
            for (Map.Entry<Dwarf, Integer> entry : dwarfs.entrySet()) {
                if(entry.getKey().name.equals(name)
                &&entry.getKey().hat.equals(hat)){
                    dwarfExists=true;
                    if(entry.getValue()<physics){
                        entry.setValue(physics);
                    }
                    break;
                }
            }
            if(!dwarfExists){
                dwarfs.put(dwarf,physics);
            }
            input = scanner.nextLine();
        }
        dwarfs.entrySet()
                .stream()
                .sorted((v1,v2)->{
                    int int1 = 0;
                    int int2 = 0;
                    for (Dwarf dwarf : dwarfs.keySet()) {
                        if(dwarf.getHat().equals(v1.getKey().getHat())){
                            int1++;
                        }else if(dwarf.getHat().equals(v2.getKey().getHat())){
                            int2++;
                        }
                    }
                    return Integer.compare(int2,int1);
                })
                .sorted((v1,v2)->Integer.compare(v2.getValue(),v1.getValue()))
                .forEach(v-> System.out.printf("(%s) %s <-> %d%n",v.getKey().getHat(),v.getKey().getName(),v.getValue()));
    }
}
