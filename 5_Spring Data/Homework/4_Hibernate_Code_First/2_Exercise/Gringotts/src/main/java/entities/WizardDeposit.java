package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {
    long id;
    String firstName;
    String lastName;
    String notes;
    int age;
    String magicWandCreator;
    int magicWandSize;
    String depositGroup;
    LocalDateTime depositStartDate;
    double depositAmount;
    double depositInterest;
    double depositCharge;
    LocalDateTime depositExpirationDate;
    boolean isDepositExpired;

    public WizardDeposit() {
    }

    public WizardDeposit(String last_name, int age) {
        this.lastName = last_name;
        this.age = age;
    }

    //Primary Key (number in range [1, 231-1]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    //Text field with max length of 50 symbols
    @Column(name = "first_name", length = 50, columnDefinition = "VARCHAR(50)")
    public String getFirstName() {
        return firstName;
    }

    //Text field with max length of 60 symbols. Required
    @Column(name = "last_name", length = 60, nullable = false, columnDefinition = "VARCHAR(60)")
    public String getLastName() {
        return lastName;
    }

    // Text field with max length of 1000 symbols
    @Column(name = "notes", length = 100, columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    //Required
    @Column(name = "age", nullable = false, columnDefinition = "INT")
    public int getAge() {
        return age;
    }

    //Text field with max length of 100 symbols
    @Column(name = "magic_wand_creator", length = 100, columnDefinition = "TEXT")
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    // Number in range [1, 215-1]
    @Column(name = "magic_wand_size")
    public int getMagicWandSize() {
        return magicWandSize;
    }

    //Text field with max length of 20 symbols
    @Column(name = "deposit_group", length = 20, columnDefinition = "VARCHAR(20)")
    public String getDepositGroup() {
        return depositGroup;
    }

    //Date and time field
    @Column(name = "deposit_start_date", columnDefinition = "DATETIME")
    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    //Floating point number field
    @Column(name = "deposit_amount", columnDefinition = "FLOAT")
    public double getDepositAmount() {
        return depositAmount;
    }

    //Floating point number field
    @Column(name = "deposit_interest", columnDefinition = "FLOAT")
    public double getDepositInterest() {
        return depositInterest;
    }

    //Floating point number field
    @Column(name = "deposit_charge", columnDefinition = "FLOAT")
    public double getDepositCharge() {
        return depositCharge;
    }

    //Date and time field
    @Column(name = "deposit_expiration_date", columnDefinition = "DATETIME")
    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    //Boolean field
    @Column(name = "is_deposit_expired", columnDefinition = "BOOLEAN")
    public boolean isIsDepositExpired() {
        return isDepositExpired;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMagicWandCreator(String magic_wand_creator) {
        this.magicWandCreator = magic_wand_creator;
    }

    public void setMagicWandSize(int magic_wand_size) {
        this.magicWandSize = magic_wand_size;
    }

    public void setDepositGroup(String deposit_group) {
        this.depositGroup = deposit_group;
    }

    public void setDepositStartDate(LocalDateTime deposit_start_date) {
        this.depositStartDate = deposit_start_date;
    }

    public void setDepositAmount(double deposit_amount) {
        this.depositAmount = deposit_amount;
    }

    public void setDepositInterest(double deposit_interest) {
        this.depositInterest = deposit_interest;
    }

    public void setDepositCharge(double deposit_charge) {
        this.depositCharge = deposit_charge;
    }

    public void setDepositExpirationDate(LocalDateTime deposit_expiration_date) {
        this.depositExpirationDate = deposit_expiration_date;
    }

    public void setIsDepositExpired(boolean is_deposit_expired) {
        this.isDepositExpired = is_deposit_expired;
    }
}
