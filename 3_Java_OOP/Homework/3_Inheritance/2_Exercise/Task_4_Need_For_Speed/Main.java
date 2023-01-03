package Task_4_Need_For_Speed;

public class Main {
    public static void main(String[] args) {
        RaceMotorcycle bike = new RaceMotorcycle(100, 300);
        System.out.println(bike.getFuel());

        bike.drive(10);
        System.out.println(bike.getFuel());
    }
}