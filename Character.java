public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int strength;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.maxHealth = health;
    }

    // Getter for the 'name' field
    public String getName() {
        return name;
    }

    // Getter for the 'health' field
    public int getHealth() {
        return health;
    }

    // Setter for the 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Setter for the 'health' field
    public void setHealth(int health) {
        this.health = health;
    }

    // Setter for the 'strength' field
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Method for the character to attack another character
    public void attack(Monster other) {
        System.out.println(this.name + " attacks " + other.getName() + " with strength " + this.strength);
        other.takeDamage(this.strength);
    }

    // Method for the character to take damage
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " takes " + damage + " damage and now has " + this.health + " health remaining.");
        if (this.health <= 0) {
            System.out.println(this.name + " has been defeated!");
        }
    }

    // Method to heal the character
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(this.name + " heals " + amount + " points and now has " + health + " health.");
    }

    // Method to represent the character object as a string
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                '}';
    }
}
