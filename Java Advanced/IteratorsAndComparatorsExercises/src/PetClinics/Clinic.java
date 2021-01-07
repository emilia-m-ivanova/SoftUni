package PetClinics;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    String name;
    List<Pet> rooms;

    public Clinic(String name, int n) throws IllegalArgumentException {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(null);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPet(Pet pet) {
        if (this.rooms.size() == 1) {
            if (this.rooms.get(0) == null) {
                this.rooms.set(0, pet);
                return true;
            }
            return false;
        }
        int startIndex = this.rooms.size() / 2;
        for (int i = 0; i <= this.rooms.size() / 2; i++) {
            int index;
            index = startIndex - i;
            if (this.rooms.get(index) == null) {
                this.rooms.set(index, pet);
                return true;
            }
            index = startIndex + i;
            if (this.rooms.get(index) == null) {
                this.rooms.set(index, pet);
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int index = this.rooms.size() / 2;
        while (index < this.rooms.size()) {
            if (this.rooms.get(index) != null) {
                this.rooms.set(index, null);
                return true;
            }
            index++;
        }
        index = 0;
        while (index < this.rooms.size() / 2) {
            if (this.rooms.get(index) != null) {
                this.rooms.set(index, null);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet room : this.rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rooms.size(); i++) {
            sb.append(getRoom(i + 1)).append(System.lineSeparator());
        }

        return String.valueOf(sb);
    }

    public String getRoom(int index) {
        return this.rooms.get(index - 1) == null ? "Room empty" : this.rooms.get(index - 1).toString();
    }
}
