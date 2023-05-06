package core;

import common.Command;
import common.ConstantMessages;
import entities.Visitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final BufferedReader reader;
    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println(ConstantMessages.SCRIPT);

        while (true) {
            String result;

            System.out.print(ConstantMessages.ONE_OF_4_COMMANDS);

            try {
                result = processInput();

                if (result.equals("End")) {
                    break;
                }
            } catch (RuntimeException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        Command command = Command.valueOf(this.reader.readLine().trim());
        String result = null;

        switch (command) {
            case AddPatient:
                result = addPatient();
                break;
            case AddVisitation:
                result = addVisitation();
                break;
            case GivePatientVisitations:
                result = givePatientVisitations();
                break;
            case End:
                result = Command.End.name();
                break;
        }

        return result;
    }

    private String addPatient() throws IOException{
        System.out.print("Patient first name: "); String firstName = reader.readLine();
        System.out.print("Patient last name: "); String lastName = reader.readLine();
        System.out.print("Patient date of birth (YYYY/MM/DD): "); String dateOfBirth = reader.readLine();
        System.out.print("Is the patient medically insured (Y/N): "); String medicalInsurance = reader.readLine();

        return this.controller.addPatient(firstName, lastName, dateOfBirth, medicalInsurance);
    }

    private String addVisitation() throws IOException {
        System.out.print("Patient first name: "); String firstName = reader.readLine();
        System.out.print("Patient last name: "); String lastName = reader.readLine();
        System.out.print("Comments about the visitation: "); String comments = reader.readLine();

        Visitation visitation = this.controller.addVisitation(firstName, lastName, comments);

        addDiagnosis(visitation);

        return String.format(ConstantMessages.VISITATION_ADDED, firstName, lastName);
    }

    private void addDiagnosis(Visitation visitation) throws IOException {
        System.out.print("Do you want to add a diagnosis (Y/N)? "); String answer = reader.readLine();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("Diagnosis name: "); String name = reader.readLine();
            System.out.print("Comments to the diagnosis: "); String comments = reader.readLine();

            this.controller.addDiagnosis(name, comments, visitation);
        } else {
            return;
        }

        addMedicine(visitation);
    }

    private void addMedicine(Visitation visitation) throws IOException {
        System.out.print("Do you want to add a medication (Y/N)? "); String answer = reader.readLine();
        String name;

        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("Enter medication name: "); name = reader.readLine();

            this.controller.addMedicine(name, visitation);
        } else {
            return;
        }

        addMedicine(visitation);
    }

    private String givePatientVisitations() throws IOException {
        System.out.print("Patient first name: "); String firstName = reader.readLine();
        System.out.print("Patient last name: "); String lastName = reader.readLine();

        return this.controller.givePatientVisitations(firstName, lastName);
    }
}
