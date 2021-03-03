package MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<SoldierImpl> soldiers = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Private":
                    soldiers.add(new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "LeutenantGeneral":
                    addLieutenant(soldiers, tokens);
                    break;
                case "Engineer":
                    addEngineer(soldiers, tokens);
                    break;
                case "Commando":
                    addCommando(soldiers, tokens);
                    break;
                case "Spy":
                    soldiers.add(new SpyImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]));
                    break;
            }
            input = scanner.nextLine();
        }

        soldiers.forEach(System.out::println);
    }

    private static void addCommando(List<SoldierImpl> soldiers, String[] tokens) {
        try {
            CommandoImpl commando = new CommandoImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
            soldiers.add(commando);
            for (int i = 6; i < tokens.length; i += 2) {
                try {
                    Mission mission = new Mission(tokens[i], State.valueOf(tokens[i + 1]));
                    commando.addMission(mission);
                } catch (Exception ex) {

                }
            }
        } catch (Exception ex) {

        }
    }

    private static void addLieutenant(List<SoldierImpl> soldiers, String[] tokens) {
        LeutenantGeneralImpl lieutenant = new LeutenantGeneralImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
        soldiers.add(lieutenant);
        for (int i = 5; i < tokens.length; i++) {
            int finalI = i;
            PrivateImpl pr = (PrivateImpl) soldiers.stream()
                    .filter(e -> e.getId() == Integer.parseInt(tokens[finalI])).findAny().get();
            lieutenant.addPrivate(pr);
        }
    }

    private static void addEngineer(List<SoldierImpl> soldiers, String[] tokens) {
        try {
            EngineerImpl engineer = new EngineerImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
            soldiers.add(engineer);
            for (int i = 6; i < tokens.length; i += 2) {
                Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                engineer.addRepair(repair);
            }
        } catch (Exception ex) {

        }
    }
}
