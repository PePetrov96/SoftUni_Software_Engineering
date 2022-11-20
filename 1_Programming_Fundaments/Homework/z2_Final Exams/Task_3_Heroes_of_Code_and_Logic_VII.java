import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_Heroes_of_Code_and_Logic_VII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Hero> heroList = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            addHero(heroList, scan.nextLine().split("\\s+"));
        }

        String input;

        while (!"End".equals(input = scan.nextLine())) {
            updateEntry(heroList, input.split("\\s+-\\s+"));
        }

        heroList.forEach((key1, value) -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", key1, value.HP, value.MP));
    }
    private static void updateEntry (Map<String, Hero> heroList, String[] input) {
        switch (input[0]) {
            case "CastSpell": castSpell(heroList, input); break;
            case "TakeDamage": takeDamage(heroList, input); break;
            case "Recharge": recharge(heroList, input); break;
            case "Heal": heal(heroList, input); break;
        }
    }
    private static void addHero (Map<String, Hero> heroList, String[] input) {
        Hero heroStats = new Hero();
        heroStats.HP = Integer.parseInt(input[1]);
        heroStats.MP = Integer.parseInt(input[2]);
        heroList.putIfAbsent(input[0], heroStats);
    }
    private static void castSpell (Map<String, Hero> heroList, String[] input) {
        String heroName = input[1];
        int MPneeded = Integer.parseInt(input[2]);
        String spellName = input[3];

        if (heroList.get(heroName).MP >= MPneeded) {
            heroList.get(heroName).MP -= MPneeded;
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroList.get(heroName).MP);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }
    private static void takeDamage (Map<String, Hero> heroList, String[] input) {
        String heroName = input[1];
        int damage = Integer.parseInt(input[2]);
        String attackerName = input[3];

        if (heroList.get(heroName).HP > damage) {
            heroList.get(heroName).HP -= damage;
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attackerName, heroList.get(heroName).HP);
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attackerName);
            heroList.remove(heroName);
        }
    }
    private static void recharge (Map<String, Hero> heroList, String[] input) {
        String heroName = input[1];
        int amount = Integer.parseInt(input[2]);

        if (heroList.get(heroName).MP + amount > 200) {
            amount = 200 - heroList.get(heroName).MP;
        }
        heroList.get(heroName).MP = heroList.get(heroName).MP + amount;
        System.out.printf("%s recharged for %d MP!%n", heroName, amount);
    }
    private static void heal (Map<String, Hero> heroList, String[] input) {
        String heroName = input[1];
        int amount = Integer.parseInt(input[2]);

        if (heroList.get(heroName).HP + amount > 100) {
            amount = 100 - heroList.get(heroName).HP;
        }
        heroList.get(heroName).HP = heroList.get(heroName).HP + amount;
        System.out.printf("%s healed for %d HP!%n", heroName, amount);
    }
    private static class Hero {
        int HP;
        int MP;
    }
}