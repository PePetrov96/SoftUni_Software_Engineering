import core.Engine;
import core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();

        engine.run();

        // This program features a console with simple commands that can be used to add patients and visitations,
        // as well as set diagnosis and include medicaments.
        // We can also extract information regarding all the visitations of a patient.
        // Naturally in a real hospital program we'd use EGN, to identify patients, rather than name,
        // but in this case we don't have EGN, so we can instead test this by inputting only unique first + last name


        // quick test lines for the console on this program, to see all functionality:

        //AddPatient
        //Ivan
        //Ivanov
        //1996/11/04
        //Y
        //AddVisitation
        //Ivan
        //Ivanov
        //patient has some complaints about throat pain
        //Y
        //Faringitis
        //patient has a strep throat and needs a few days of treatment
        //Y
        //Vitamin C
        //Y
        //Paracetamol
        //Y
        //Coldrex
        //N
        //GivePatientVisitations
        //Ivan
        //Ivanov
        //End
    }
}