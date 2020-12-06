import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List<Integer> >heroes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            String name = input[0];
            int hitPoints = Integer.parseInt(input[1]);
            int manaPoints = Integer.parseInt(input[2]);
            heroes.put(name,new ArrayList<>(){{add(hitPoints);add(manaPoints);}});
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String [] tokens = command.split(" - ");
            String hero = tokens[1];
            switch (tokens[0]){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    int mpDecreased = heroes.get(hero).get(1)-mpNeeded;
                    if(mpDecreased>=0){
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",hero,spellName,mpDecreased);
                        heroes.get(hero).set(1,mpDecreased);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",hero,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int damageDecreased = heroes.get(hero).get(0)-damage;
                    if(damageDecreased>0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",hero,damage,attacker,damageDecreased);
                        heroes.get(hero).set(0,damageDecreased);
                    }else{
                        System.out.printf("%s has been killed by %s!%n",hero,attacker);
                        heroes.remove(hero);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int mpIncreased = heroes.get(hero).get(1)+amount;
                    System.out.printf("%s recharged for %d MP!%n",hero,Math.min(mpIncreased,200)-heroes.get(hero).get(1));
                    heroes.get(hero).set(1,Math.min(mpIncreased,200));
                    break;
                case "Heal":
                    amount = Integer.parseInt(tokens[2]);
                    int hpIncreased = heroes.get(hero).get(0)+amount;
                    System.out.printf("%s healed for %d HP!%n",hero,Math.min(hpIncreased,100)-heroes.get(hero).get(0));
                    heroes.get(hero).set(0,Math.min(hpIncreased,100));
                    break;
            }
            command = scanner.nextLine();
        }

        heroes.entrySet()
                .stream()
                .sorted((a,b)->b.getValue().get(0).compareTo(a.getValue().get(0)))
                .forEach(h-> System.out.printf("%s%n  HP: %d%n  MP: %d%n",h.getKey(),h.getValue().get(0),h.getValue().get(1)));
    }
}
