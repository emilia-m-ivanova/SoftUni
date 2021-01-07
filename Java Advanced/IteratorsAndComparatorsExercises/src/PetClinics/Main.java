package PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    create(clinics, pets, tokens);
                    break;
                case "Add":
                    addPet(clinics, pets, tokens);
                    break;
                case "Release":
                    releasePet(clinics, tokens[1]);
                    break;
                case "HasEmptyRooms":
                    hasEmptyRoooms(clinics, tokens[1]);
                    break;
                case "Print":
                    print(clinics, tokens);
                    break;
            }
        }
    }

    private static void print(List<Clinic> clinics, String[] tokens) {
        Clinic clinic = clinics.stream()
                .filter(c->c.getName().equals(tokens[1]))
                .findFirst()
                .get();
        if(tokens.length==2){
            System.out.print(clinic.toString());
        }else{
            System.out.println(clinic.getRoom(Integer.parseInt(tokens[2])));
        }
    }

    private static void hasEmptyRoooms(List<Clinic> clinics, String token) {
        Clinic clinic = clinics.stream()
                .filter(c->c.getName().equals(token))
                .findFirst()
                .get();
        System.out.println(clinic.hasEmptyRooms());
    }

    private static void releasePet(List<Clinic> clinics, String token) {
        Clinic clinic = clinics.stream()
                .filter(c->c.getName().equals(token))
                .findFirst()
                .get();
        System.out.println(clinic.release());
    }

    private static void addPet(List<Clinic> clinics, List<Pet> pets, String[] tokens) {
        Pet pet = pets.stream()
                .filter(p->p.getName().equals(tokens[1]))
                .findFirst()
                .get();
        Clinic clinic = clinics.stream()
                .filter(c->c.getName().equals(tokens[2]))
                .findFirst()
                .get();
        System.out.println(clinic.addPet(pet));
    }

    private static void create(List<Clinic> clinics, List<Pet> pets, String[] tokens) {
        if (tokens[1].equals("Clinic")) {
            try {
                Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                clinics.add(clinic);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
        pets.add(pet);
    }
}
