public class Monster {
    private String name;
    private int health;
    private int strength;
    private String type;

    public Monster(String name, int health, int strength, String type) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.type = type;
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

    // Getter for the 'type' field
    public String getType() {
        return type;
    }

    // Setter for the 'type' field
    public void setType(String type) {
        this.type = type;
    }

    // Method for the monster to attack another character
    public void attack(Character other) {
        System.out.println(this.name + " attacks " + other.getName() + " with strength " + this.strength);
        other.takeDamage(this.strength);
    }

    // Method for the monster to take damage
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " takes " + damage + " damage and now has " + this.health + " health remaining.");
        if (this.health <= 0) {
            System.out.println(this.name + " has been defeated!");
        }
    }

    // Method to represent the monster object as a string
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", type='" + type + '\'' +
                '}';
    }
}
