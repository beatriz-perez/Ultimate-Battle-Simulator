package Classes;

public class Battle {
    private int rounds = 1;

    // Method to show detailed log
    public void detailedLog(Character fighter) {
        if (fighter instanceof Warrior) {
            System.out.println(fighter.getName());
            System.out.println("Health Points: " + fighter.getHp());
            System.out.println("Stamina: " + ((Warrior) fighter).getStamina());
            System.out.println("Strength: " + ((Warrior) fighter).getStrength());
        } else if (fighter instanceof Wizard) {
            System.out.println("Name: " + fighter.getName());
            System.out.println("Health Points: " + fighter.getHp());
            System.out.println("Mana: " + ((Wizard) fighter).getMana());
            System.out.println("Intelligence: " + ((Wizard) fighter).getIntelligence());
        }
    }

    // Method to show attack log
    public void attackLog(Character fighter) {
        if (fighter instanceof Warrior) {
            System.out.println("Health Points: " + fighter.getHp());
            System.out.println("Stamina: " + ((Warrior) fighter).getStamina());
        } else if (fighter instanceof Wizard) {
            System.out.println("Health Points: " + fighter.getHp());
            System.out.println("Mana: " + ((Wizard) fighter).getMana());
        }
    }

    public int initBattle(Character fighter1, Character fighter2) {
        System.out.println("Hello fighters, before you begin your status are...");
        // Show initial values of fighters
        System.out.println("··· Fighter 1 ···");
        detailedLog(fighter1);

        System.out.println("··· Fighter 2 ···");
        detailedLog(fighter2);

        while (fighter1.isAlive() || fighter2.isAlive()) {
            // Numbers of the round
            System.out.println("\n****** Round " + rounds + " ******");
            if (fighter1 instanceof Warrior && fighter2 instanceof Warrior) { // If both fighters are warriors
                // Attack
                System.out.println("\nAttack!");
                fighter1.setHp(fighter1.getHp() - ((Warrior) fighter1).attack()); // Damage caused by fighter 1
                fighter2.setHp(fighter2.getHp() - ((Warrior) fighter2).attack()); // Damage caused by fighter 2
            } else if (fighter1 instanceof Warrior && fighter2 instanceof Wizard) { // If fighter 1 is a warrior and fighter 2 is a wizard
                // Attack
                System.out.println("\nAttack!");
                fighter1.setHp(fighter1.getHp() - ((Warrior) fighter1).attack()); // Damage caused by fighter 1
                fighter2.setHp(fighter2.getHp() - ((Wizard) fighter2).attack()); // Damage caused by fighter 2
            } else if (fighter1 instanceof Wizard && fighter2 instanceof Wizard) { // If both fighters are wizards
                // Attack
                System.out.println("\nAttack!");
                fighter1.setHp(fighter1.getHp() - ((Wizard) fighter1).attack()); // Damage caused by fighter 1
                fighter2.setHp(fighter2.getHp() - ((Wizard) fighter2).attack()); // Damage caused by fighter 2
            } else if (fighter1 instanceof Wizard && fighter2 instanceof Warrior) { // If fighter 1 is a wizard and fighter 2 is a warrior
                // Attack
                System.out.println("\nAttack!");
                fighter1.setHp(fighter1.getHp() - ((Wizard) fighter1).attack()); // Damage caused by fighter 1
                fighter2.setHp(fighter2.getHp() - ((Warrior) fighter2).attack()); // Damage caused by fighter 2
            }

            // Check hp of the fighters
            if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) { // If the hp of both fighters is 0, it's a tie
                System.out.println("\n****** Game Over ******");
                System.out.println("··· Fighter 1 ···");
                detailedLog(fighter1);

                System.out.println("··· Fighter 2 ···");
                detailedLog(fighter2);
                return 0;
            } else if (fighter1.getHp() <= 0) { // If the hp of fighter 1 is 0, fighter 2 wins
                fighter1.setAlive(false);
                System.out.println("\n****** Game Over ******");
                System.out.println("··· Fighter 1 ···");
                detailedLog(fighter1);

                System.out.println("··· Fighter 2 ···");
                detailedLog(fighter2);
                return 2; // Return the winner
            } else if (fighter2.getHp() <= 0) { // If the hp of fighter 2 is 0, fighter 1 wins
                fighter2.setAlive(false);
                System.out.println("\n****** Game Over ******");
                System.out.println("··· Fighter 1 ···");
                detailedLog(fighter1);

                System.out.println("··· Fighter 2 ···");
                detailedLog(fighter2);
                return 1;
            }

            // Increment the number of rounds
            rounds++;
            MenuHelp.askForEnter("Press \"ENTER\" to continue...");
        }
        return 0;
    }
}