import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Character hero;
    private static Monster monster;
    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        System.out.println("Enter your character's name:");
        String name = scanner.nextLine();
        hero = new Character(name, 100, 20);

        while (hero.getHealth() > 0) {
            monster = spawnMonster();
            System.out.println("A wild " + monster.getType() + " appears!");

            while (hero.getHealth() > 0 && monster.getHealth() > 0) {
                System.out.println(hero);
                System.out.println(monster);

                System.out.println("Do you want to 'attack' or 'heal'?");
                String input = scanner.nextLine();

                if ("attack".equalsIgnoreCase(input)) {
                    hero.attack(monster);
                } else if ("heal".equalsIgnoreCase(input)) {
                    hero.heal(30); // Assume the heal amount is 30 points
                    System.out.println(hero.getName() + " heals and now has " + hero.getHealth() + " health.");
                } else {
                    System.out.println(hero.getName() + " hesitates... and does nothing.");
                }

                if (monster.getHealth() > 0) {
                    monster.attack(hero);
                }
            }

            if (hero.getHealth() <= 0) {
                System.out.println("You have been defeated by the " + monster.getType() + ".");
            } else if (monster.getHealth() <= 0) {
                System.out.println("You have defeated the " + monster.getType() + "!");
                // Optionally, heal the hero a bit after a victory
                hero.heal(10);
            }
        }

        System.out.println("Game Over. Thank you for playing!");

        scanner.close();
    }

    private static Monster spawnMonster() {
        // Randomly create a new monster
        int monsterType = random.nextInt(3);
        switch (monsterType) {
            case 0:
                return new Monster("Goblin", 50, 10, "Goblin"); // Goblin's type is "Goblin"
            case 1:
                return new Monster("Orc", 80, 15, "Orc"); // Orc's type is "Orc"
            case 2:
                return new Monster("Troll", 120, 20, "Troll"); // Troll's type is "Troll"
            default:
                return new Monster("Goblin", 50, 10, "Goblin"); // Default to "Goblin"
        }
    }
}
