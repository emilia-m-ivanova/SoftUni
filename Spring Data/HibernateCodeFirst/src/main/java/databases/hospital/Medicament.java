package databases.hospital;

import databases.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medicament extends BaseEntity {
    private String name;

    public Medicament() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
