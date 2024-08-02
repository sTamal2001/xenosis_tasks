import java.util.ArrayList;
import java.util.Scanner;

// Class representing the Player
class Player {
    private String name;
    private int health;
    private int attackPower;
    private int score;
    private ArrayList<String> inventory;

    // Constructor to initialize player properties
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attackPower = 10;
        this.score = 0;
        this.inventory = new ArrayList<>();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    // Setter methods
    public void setHealth(int health) {
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Method to add an item to the inventory
    public void addItem(String item) {
        inventory.add(item);
    }

    // Method to display player details
    public void displayStatus() {
        System.out.println("Player: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Score: " + score);
        System.out.println("Inventory: " + inventory);
        System.out.println();
    }

    // Method for player to attack an enemy
    public void attack(Enemy enemy) {
        System.out.println(name + " attacks " + enemy.getName() + "!");
        enemy.takeDamage(attackPower);
    }

    // Method for player to take damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
    }
}

// Class representing an Enemy
class Enemy {
    private String name;
    private int health;
    private int attackPower;

    // Constructor to initialize enemy properties
    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Method to take damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
    }

    // Method for enemy to attack the player
    public void attack(Player player) {
        System.out.println(name + " attacks " + player.getName() + "!");
        player.takeDamage(attackPower);
    }

    // Method to check if enemy is defeated
    public boolean isDefeated() {
        return health <= 0;
    }
}

// Class representing an Item
class Item {
    private String name;

    // Constructor to initialize item name
    public Item(String name) {
        this.name = name;
    }

    // Getter method for item name
    public String getName() {
        return name;
    }
}

// Main class for the game world
public class GameWorld {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Item> items;
    private int level;

    // Constructor to initialize game world
    public GameWorld(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.level = 1;
        generateEnemies();
        generateItems();
    }

    // Method to generate enemies for the current level
    private void generateEnemies() {
        enemies.clear();
        for (int i = 1; i <= level; i++) {
            enemies.add(new Enemy("Enemy " + i, 20 * level, 5 * level));
        }
    }

    // Method to generate items for the current level
    private void generateItems() {
        items.clear();
        for (int i = 1; i <= level; i++) {
            items.add(new Item("Item " + i));
        }
    }

    // Method to start the game
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game, " + player.getName() + "!");
        player.displayStatus();
        
        // Game loop
        while (true) {
            System.out.println("1. Fight Enemies");
            System.out.println("2. Collect Items");
            System.out.println("3. Check Status");
            System.out.println("4. Next Level");
            System.out.println("5. Quit");
            System.out.print("Choose an action: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    fightEnemies();
                    break;
                case 2:
                    collectItems();
                    break;
                case 3:
                    player.displayStatus();
                    break;
                case 4:
                    nextLevel();
                    break;
                case 5:
                    System.out.println("Thanks for playing! Goodbye.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated. Game Over.");
                break;
            }
        }
        sc.close();
    }

    // Method to fight enemies
    private void fightEnemies() {
        for (Enemy enemy : enemies) {
            while (!enemy.isDefeated() && player.getHealth() > 0) {
                player.attack(enemy);
                if (!enemy.isDefeated()) {
                    enemy.attack(player);
                }
            }
            if (enemy.isDefeated()) {
                player.setScore(player.getScore() + 10);
                System.out.println(enemy.getName() + " defeated!");
            }
            if (player.getHealth() <= 0) {
                break;
            }
        }
        System.out.println("All enemies defeated or player is dead.");
    }

    // Method to collect items
    private void collectItems() {
        if (items.isEmpty()) {
            System.out.println("No items available to collect.");
            return;
        }
        for (Item item : items) {
            player.addItem(item.getName());
            System.out.println("Collected " + item.getName());
        }
        items.clear();
    }

    // Method to proceed to the next level
    private void nextLevel() {
        level++;
        System.out.println("Proceeding to level " + level + "...");
        generateEnemies();
        generateItems();
        player.setHealth(100); // Restore player's health
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);
        GameWorld game = new GameWorld(player);
        game.startGame();
    }
}
