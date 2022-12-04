import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_Heroes_of_Code_and_Logic_VII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Stats> heroes = new LinkedHashMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            addHero(heroes, scan.nextLine().split("\\s"));
        }

        while (!"End".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s-\\s");
            switch (tokens[0]) {
                case "CastSpell": CastSpell(heroes, tokens[1], Integer.parseInt(tokens[2]), tokens[3]); break;
                case "TakeDamage": TakeDamage(heroes, tokens[1], Integer.parseInt(tokens[2]), tokens[3]); break;
                case "Recharge": Recharge(heroes, tokens[1], Integer.parseInt(tokens[2])); break;
                case "Heal": Heal(heroes, tokens[1], Integer.parseInt(tokens[2])); break;
            }
        }

        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.println("  HP: " + value.HP);
            System.out.println("  MP: " + value.MP);
        });
    }
    private static void CastSpell (Map<String, Stats> heroes, String heroName, int requiredMP, String spellName) {
        if (heroes.get(heroName).MP >= requiredMP) {
            heroes.get(heroName).MP -= requiredMP;
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName).MP);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }
    private static void TakeDamage (Map<String, Stats> heroes, String heroName, int damage, String attackerName) {
        heroes.get(heroName).HP -= damage;
        if (heroes.get(heroName).HP >0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attackerName, heroes.get(heroName).HP);
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attackerName);
            heroes.remove(heroName);
        }
    }
    private static void Recharge (Map<String, Stats> heroes, String heroName, int MPamount) {
        if (heroes.get(heroName).MP + MPamount > 200) {
            MPamount = 200 - heroes.get(heroName).MP;
        }
        heroes.get(heroName).MP += MPamount;
        System.out.printf("%s recharged for %d MP!%n", heroName, MPamount);
    }
    private static void Heal (Map<String, Stats> heroes, String heroName, int HPamount) {
        if (heroes.get(heroName).HP + HPamount > 100) {
            HPamount = 100 - heroes.get(heroName).HP;
        }
        heroes.get(heroName).HP += HPamount;
        System.out.printf("%s healed for %d HP!%n", heroName, HPamount);
    }
    private static void addHero (Map<String, Stats> heroes, String[] input) {
        Stats stats = new Stats(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        heroes.put(input[0], stats);
    }
    private static class Stats {
        int HP;
        int MP;
        public Stats(int HP, int MP) {
            this.HP = HP;
            this.MP = MP;
        }
    }
}