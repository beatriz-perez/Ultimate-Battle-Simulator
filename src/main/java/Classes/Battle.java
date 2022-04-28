package Classes;

public class Battle {
    private int rounds = 1;
    private int damage1 = 0;
    private int damage2 = 0;

    // Method to show initial log
    public void initialLog(Character fighter) {
        if (fighter instanceof Warrior) { // If is a warrior
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println(fighter.getName());
            System.out.print(TextColor.YELLOW_BRIGHT);
            System.out.println("You have " + fighter.getHp() + " healthy points");
            System.out.println(((Warrior) fighter).getStamina() + " of stamina");
            System.out.println(((Warrior) fighter).getStrength() + " of strength");
        } else if (fighter instanceof Wizard) { // If is a wizard
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println(fighter.getName());
            System.out.print(TextColor.YELLOW_BRIGHT);
            System.out.println("You have " + + fighter.getHp() + " healthy points");
            System.out.println(((Wizard) fighter).getMana() + " of mana");
            System.out.println(((Wizard) fighter).getIntelligence() + " of intelligence");
        }
    }

    // Method to show final log
    public void finalLog(Character fighter) {
        if (fighter instanceof Warrior) { // If is a warrior
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println(fighter.getName());
            System.out.print(TextColor.YELLOW_BRIGHT);
            System.out.println("You ended the battle with " + + fighter.getHp() + " healthy points" + " and " + ((Warrior) fighter).getStamina() + " of stamina");
        } else if (fighter instanceof Wizard) { // If is a wizard
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println(fighter.getName());
            System.out.print(TextColor.YELLOW_BRIGHT);
            System.out.println("You ended the battle with " + + fighter.getHp() + " healthy points" + "and " + ((Wizard) fighter).getMana() + " of mana");
        }
    }

    // Method to show attack log
    public void attackLog(Character fighter, int damage) {
        if (fighter instanceof Warrior) { // If is a warrior
            System.out.println(fighter.getName() + " you have been attack and lost " + damage + " healthy points");
            System.out.println("Your current status is...");
            System.out.println("Healthy Points: " + fighter.getHp());
            System.out.println("Stamina: " + ((Warrior) fighter).getStamina());
        } else if (fighter instanceof Wizard) { // If is a wizard
            System.out.println(fighter.getName() + " you have been attack and lost " + damage + " healthy points");
            System.out.println("Your current status is...");
            System.out.println("Healthy Points: " + fighter.getHp());
            System.out.println("Mana: " + ((Wizard) fighter).getMana());
        }
    }

    public int initBattle(Character fighter1, Character fighter2) {
        System.out.print(TextColor.ORANGE_BRIGHT);
        System.out.println("Hello fighters, before the battle begins, let's see your initial statuses...\n");
        System.out.print(TextColor.YELLOW_BRIGHT);
        // Show initial values of fighters
        initialLog(fighter1);
        System.out.println("=============================");
        initialLog(fighter2);

        System.out.print(TextColor.ORANGE_BRIGHT);
        System.out.println("\nLet's begin the battle...");
        System.out.println("Good luck fighters!");
        System.out.print(TextColor.YELLOW_BRIGHT);
        MenuHelp.askForEnter("\nPress \"ENTER\" to continue...");

        // While one of the fighters is alive
        while (fighter1.isAlive() || fighter2.isAlive()) {
            // Numbers of the round
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println("\n****** Round " + rounds + " ******");
            System.out.print(TextColor.YELLOW_BRIGHT);
            if (fighter1 instanceof Warrior && fighter2 instanceof Warrior) { // If both fighters are warriors
                // Attack
                System.out.println("Attack!");
                damage1 = ((Warrior) fighter1).attack(); // Damage caused by fighter 1
                damage2 = ((Warrior) fighter2).attack(); // Damage caused by fighter 2

                fighter1.decreaseHp(damage2); // Subtract the damage to the healthy points
                fighter2.decreaseHp(damage1);

                // Show the log of the attacks
                System.out.println();
                attackLog(fighter1, damage2);
                System.out.println();
                attackLog(fighter2, damage1);
            } else if (fighter1 instanceof Warrior && fighter2 instanceof Wizard) { // If fighter 1 is a warrior and fighter 2 is a wizard
                // Attack
                System.out.println("Attack!");
                damage1 = ((Warrior) fighter1).attack(); // Damage caused by fighter 1
                damage2 = ((Wizard) fighter2).attack(); // Damage caused by fighter 2

                fighter1.decreaseHp(damage2); // Subtract the damage to the healthy points
                fighter2.decreaseHp(damage1);

                // Show the log of the attacks
                System.out.println();
                attackLog(fighter1, damage2);
                System.out.println();
                attackLog(fighter2, damage1);
            } else if (fighter1 instanceof Wizard && fighter2 instanceof Wizard) { // If both fighters are wizards
                // Attack
                System.out.println("Attack!");
                damage1 = ((Wizard) fighter1).attack(); // Damage caused by fighter 1
                damage2 = ((Wizard) fighter2).attack(); // Damage caused by fighter 2

                fighter1.decreaseHp(damage2); // Subtract the damage to the healthy points
                fighter2.decreaseHp(damage1);

                // Show the log of the attacks
                System.out.println();
                attackLog(fighter1, damage2);
                System.out.println();
                attackLog(fighter2, damage1);
            } else if (fighter1 instanceof Wizard && fighter2 instanceof Warrior) { // If fighter 1 is a wizard and fighter 2 is a warrior
                // Attack
                System.out.println("Attack!");
                damage1 = ((Wizard) fighter1).attack(); // Damage caused by fighter 1
                damage2 = ((Warrior) fighter2).attack(); // Damage caused by fighter 2

                fighter1.decreaseHp(damage2); // Subtract the damage to the healthy points
                fighter2.decreaseHp(damage1);

                // Show the log of the attacks
                System.out.println();
                attackLog(fighter1, damage2);
                System.out.println();
                attackLog(fighter2, damage1);
            }

            // Check hp of the fighters
            if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) { // If the hp of both fighters is 0, it's a tie
                System.out.print(TextColor.ORANGE_BRIGHT);
                System.out.println("\n****** Battle Over ******");
                System.out.print(TextColor.YELLOW_BRIGHT);
                System.out.println("This is the end of the battle, your final statuses are...");

                // Show the final log
                finalLog(fighter1);
                System.out.println("=============================");
                finalLog(fighter2);
                return 0;
            } else if (fighter1.getHp() <= 0) { // If the hp of fighter 1 is 0, fighter 2 wins
                fighter1.setAlive(false); // setAlive to false of fighter1
                System.out.print(TextColor.ORANGE_BRIGHT);
                System.out.println("\n****** Battle Over ******");
                System.out.print(TextColor.YELLOW_BRIGHT);
                System.out.println("This is the end of the battle, your final statuses are...");

                // Show the final log
                finalLog(fighter1);
                System.out.println("=============================");
                finalLog(fighter2);
                return 2; // Return the winner
            } else if (fighter2.getHp() <= 0) { // If the hp of fighter 2 is 0, fighter 1 wins
                fighter2.setAlive(false); //setAlive to false of fighter2
                System.out.print(TextColor.ORANGE_BRIGHT);
                System.out.println("\n****** Battle Over ******");
                System.out.print(TextColor.YELLOW_BRIGHT);
                System.out.println("This is the end of the battle, your final statuses are...");

                // Show the final log
                finalLog(fighter1);
                System.out.println("=============================");
                finalLog(fighter2);
                return 1;
            }

            // Increment the number of rounds
            rounds++;
            System.out.print(TextColor.ORANGE_BRIGHT);
            System.out.println("\nGet ready for the next round...");
            MenuHelp.askForEnter("Press \"ENTER\" to continue...");
        }
        return 0;
    }
}
