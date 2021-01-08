package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add (Pet pet){
        if(data.size() < capacity){
            data.add(pet);
        }
    }

    public boolean remove (String name){
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet (String name, String owner){
        return data.stream()
                .filter(p->p.getName().equals(name)&& p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public Pet getOldestPet (){
        return data.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (int i = 0; i < data.size()-1; i++) {
            Pet pet = data.get(i);
            sb.append(pet.getName()).append(" ")
                    .append(pet.getOwner()).append(System.lineSeparator());
        }
        Pet pet = data.get(data.size()-1);
        sb.append(pet.getName()).append(" ")
                .append(pet.getOwner());
        return String.valueOf(sb);
    }
}
