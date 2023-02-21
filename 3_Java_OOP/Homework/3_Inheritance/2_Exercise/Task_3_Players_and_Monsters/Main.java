package Task_3_Players_and_Monsters;

public class Main {
    public static void main(String[] args) {
        SoulMaster soulMaster = new SoulMaster("PussySlayer69", 9001);
        System.out.println(soulMaster.getUsername());
        System.out.println(soulMaster.getLevel());
        System.out.println(soulMaster);
    }
}