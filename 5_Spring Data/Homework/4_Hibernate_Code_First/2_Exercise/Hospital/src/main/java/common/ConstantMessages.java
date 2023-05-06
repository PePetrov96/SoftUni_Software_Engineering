package common;

public class ConstantMessages {
    public static final String SCRIPT = """
            What do you want to do?
                1. AddPatient - adds a new patient
                2. AddVisitation - adds a new visitation to a patient
                3. GivePatientVisitations - gives off all the visitations of the selected patient
                4. End - ends the program""";
    public static final String PATIENT_ADDED = "Patient %s %s was added successfully";
    public static final String VISITATION_ADDED = "A new Visitation was added to Patient %s %s successfully";
    public static final String MEDICATION_ADDED = "Medication %s was added.";
    public static final String ONE_OF_4_COMMANDS = "Please enter 1 of the 4 Main commands: ";
    public static final String PATIENT_NOT_FOUND = "Invalid. Patient not found in the database!";
    public static final String FIRST_NAME = "-First Name: %s";
    public static final String LAST_NAME = "-Last Name: %s";
    public static final String DATE_OF_BIRTH = "-Date of birth: %s";
    public static final String INSURANCE = "-Medically Insured?: %s";
    public static final String VISITATION_COMMENTS = "%d. Visitation: %s";
    public static final String DIAGNOSIS_NAME = "--Diagnosis name: %s";
    public static final String DIAGNOSIS_COMMENTS = "--Diagnosis comment: %s";
    public static final String MEDICATION_NAME = "----Medication name: %s";
}