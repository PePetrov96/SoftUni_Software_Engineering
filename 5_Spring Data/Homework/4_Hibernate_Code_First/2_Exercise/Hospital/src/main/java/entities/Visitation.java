package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @OneToOne(mappedBy = "visitation")
    private Diagnosis diagnosis;
    @OneToMany(mappedBy = "visitation")
    private List<Medication> medications = new ArrayList<>();

    public Visitation() {
    }

    public Visitation(Date date, String comments) {
        this.date = date;
        this.comments = comments;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
        diagnosis.setVisitation(this);
    }
    public void addMedication(Medication medication) {
        this.medications.add(medication);
        medication.setVisitation(this);
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public List<Medication> getMedications() {
        return medications;
    }
}