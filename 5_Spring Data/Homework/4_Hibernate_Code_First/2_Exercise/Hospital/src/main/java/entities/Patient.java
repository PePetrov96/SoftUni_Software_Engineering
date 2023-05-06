package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @Column(name = "address", columnDefinition = "VARCHAR(225)")
    private String address;

    @Column(name = "email", columnDefinition = "VARCHAR(225)")
    private String email;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private Date dateOfBirth;

    @Column(name = "picture", columnDefinition = "BLOB")
    private byte picture;
    @Column(name = "medical_insurance", columnDefinition = "BOOLEAN")
    private int medicalInsurance;

    @OneToMany(mappedBy = "patient")
    private List<Visitation> visitations = new ArrayList<>();

    public Patient() {}

    public Patient(String firstName, String lastName, Date dateOfBirth, boolean medicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

        if (medicalInsurance) {
            this.medicalInsurance = 1;
        } else {
            this.medicalInsurance = 0;
        }

    }
    public void addVisitations(Visitation visitations) {
        this.visitations.add(visitations);
        visitations.setPatient(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte getPicture() {
        return picture;
    }

    public void setPicture(byte picture) {
        this.picture = picture;
    }

    public int isMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(boolean medicalInsurance) {
        if (medicalInsurance) {
            this.medicalInsurance = 1;
        } else {
            this.medicalInsurance = 0;
        }
    }

    public List<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(List<Visitation> visitations) {
        this.visitations = visitations;
    }
}