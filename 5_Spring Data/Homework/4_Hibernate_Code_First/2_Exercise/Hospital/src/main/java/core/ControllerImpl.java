package core;

import common.ConstantMessages;
import common.ExceptionMessages;
import entities.Diagnosis;
import entities.Medication;
import entities.Patient;
import entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class ControllerImpl implements Controller {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("hospital_database");
    private static final EntityManager em = factory.createEntityManager();

    @Override
    public String addPatient(String firstName, String lastName, String dateOfBirth, String medicalInsurance) {
        em.getTransaction().begin();

        try {
//            Date formattedDateOfBirth = new SimpleDateFormat("yyyy/MM/dd").parse(dateOfBirth);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = dateFormat.parse(dateOfBirth);

            boolean booleanMedicalInsurance = medicalInsurance.equalsIgnoreCase("Y");

            Patient patient = new Patient(firstName, lastName, date, booleanMedicalInsurance);

            em.persist(patient);

        } catch (ParseException e) {
            em.getTransaction().rollback();
            throw new RuntimeException(ExceptionMessages.WRONG_PATIENT_FORMAT);
        }

        em.getTransaction().commit();

        return String.format(ConstantMessages.PATIENT_ADDED, firstName, lastName);
    }

    @Override
    public Visitation addVisitation(String firstName, String lastName, String comments) {
        //split the input into names and comments & add a date (the current date)
        String dataValue = String.valueOf(LocalDate.now()).replaceAll("-", "/");
        Date date;

        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(dataValue);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //find if the Patient is present in the DB
        Patient patient = getPatient(firstName, lastName);

        if (patient == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.PATIENT_NOT_IN_DATABASE, firstName, lastName));
        }

        //begin the translation to include a new visitation on the patient
        em.getTransaction().begin();

        Visitation visitation = new Visitation(date, comments);
        visitation.setPatient(patient);


        em.persist(visitation);

        em.getTransaction().commit();

        return visitation;
    }

    @Override
    public void addDiagnosis(String name, String comments, Visitation visitation) {
        em.getTransaction().begin();

        Diagnosis diagnosis = new Diagnosis(name, comments);

        visitation.setDiagnosis(diagnosis);

        em.persist(diagnosis);

        em.getTransaction().commit();
    }

    @Override
    public void addMedicine(String data, Visitation visitation) {
        em.getTransaction().begin();

        Medication medication = new Medication(data);

        visitation.addMedication(medication);

        em.persist(medication);

        em.getTransaction().commit();
    }

    @Override
    public String givePatientVisitations(String firstName, String lastName) {
        Patient patient = getPatient(firstName, lastName);

        em.merge(patient);

        if (patient == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.PATIENT_NOT_IN_DATABASE, firstName, lastName));
        }

        StringBuilder out = new StringBuilder();
        String insurance;

        if (patient.isMedicalInsurance() == 1) {
            insurance = "Yes";
        } else {
            insurance = "No";
        }

        Date dateOfBirth = patient.getDateOfBirth();
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateOfBirth = outputFormat.format(dateOfBirth);

        out
                .append(String.format(ConstantMessages.FIRST_NAME, firstName))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.LAST_NAME, lastName))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.DATE_OF_BIRTH, formattedDateOfBirth))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.INSURANCE, insurance))
                .append(System.lineSeparator());

        int count = 1;

        for (Visitation visitation : patient.getVisitations()) {
            out
                    .append(String.format(ConstantMessages.VISITATION_COMMENTS, count++, visitation.getComments()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.DIAGNOSIS_NAME, visitation.getDiagnosis().getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.DIAGNOSIS_COMMENTS, visitation.getDiagnosis().getComments()))
                    .append(System.lineSeparator());

            for (Medication medication : visitation.getMedications()) {
                out
                        .append(String.format(ConstantMessages.MEDICATION_NAME, medication.getName()))
                        .append(System.lineSeparator());
            }

        }

        return out.toString().trim();
    }

    private Patient getPatient(String firstName, String lastName) {
        String sqlQuery = "SELECT p " +
                "FROM Patient p " +
                "WHERE p.firstName = :firstName AND p.lastName = :lastName";

        try {
            return em.createQuery(sqlQuery, Patient.class)
                    .setParameter("firstName", firstName)
                    .setParameter("lastName",lastName)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}