package databases.gringotts;

import databases.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "wizzard_deposits")
public class WizardDeposit extends BaseEntity {
    private int id;// – Primary Key (number in range [1, 231-1].
    private String firstName; //– Text field with max length of 50 symbols.
    private String lastName;// - Text field with max length of 60 symbols. Required
    private String notes;// – Text field with max length of 1000 symbols
    private String age;// – Non-negative number. Required
    private String magicWandCreator;// – Text field with max length of 100 symbols
    private int magicWandSize;// – Number in range [1, 215-1]
    private String depositGroup;// - Text field with max length of 20 symbols
    private LocalDateTime depositStartDate;// – Date and time field
    private double depositAmount;// – Floating point number field
    private double depositInterest;// - Floating point number field
    private double depositCharge;// - Floating point number field
    private LocalDateTime depositExpirationDate;// – Date and time field
    private boolean isDepositExpired;// – Boolean field

    public WizardDeposit() {
    }


    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name",length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name",length = 60, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(length = 1000)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Column(name = "magic_wand_creator",length = 100)
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    @Column(name = "magic_wand_size", columnDefinition = "INT UNSIGNED")

    public int getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(int magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    @Column(name = "deposit_group", length = 20)
    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    @Column(name = "deposit_start_date")
    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    @Column(name = "deposit_amount")
    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Column(name = "deposit_interest")
    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    @Column(name = "deposit_charge")
    public double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    @Column(name = "deposit_expiration_date")
    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    @Column(name = "is_deposit_expired")
    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
