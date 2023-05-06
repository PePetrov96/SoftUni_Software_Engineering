package core;

import entities.Diagnosis;
import entities.Visitation;

public interface Controller {
    String addPatient(String firstName, String lastName, String dateOfBirth, String medicalInsurance);
    Visitation addVisitation(String firstName, String lastName, String comments);
    void addDiagnosis(String name, String comments, Visitation visitation);
    void addMedicine(String data, Visitation visitation);
    String givePatientVisitations(String firstName, String lastName);
}
