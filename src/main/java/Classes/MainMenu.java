package Classes;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MainMenu {

    // SHOW MAIN MENU
    public static void showMainMenu() {
        boolean exit = false;
        do {
            int battlesPlayed = 0;
            Graveyard graveyard = new Graveyard();
            Player player1 = new Player("Leader 1", graveyard);
            Player player2 = new Player("Leader 2", graveyard);

            // 1. SHOW GAME INTRO
            showIntro();

            // 2. CREATE PLAYERS AND PARTIES:
            setPlayer(player1);
            setPlayer(player2);

            // 3. START BATTLES AND SHOW RESULTS + SHOW GRAVEYARD
            showBattlesIntro();

            do {
                battlesPlayed = battle(battlesPlayed, player1, player2, graveyard);
            } while(player1.getParty().size() > 0 && player2.getParty().size() > 0);

            // 4. DECLARE A WINNER + EXPORT WINNER PARTY
            declareWinner(battlesPlayed, player1, player2);

            // 5. END GAME OR START AGAIN
            exit = endOrRestart();
        } while(!exit);
    }


    // SHOW GAME INTRO
    public static void showIntro() {
        System.out.println("\n");
        System.out.println("--------------------------- Hello players! ----------------------------");
        System.out.println("----------------------------- welcome to ------------------------------");
        System.out.println("-------------------- THE ULTIMATE BATTLE SIMULATOR --------------------");
        System.out.println("\n");
        System.out.println(" **** We warn you it is an adventure only for the most courageous **** ");
        System.out.println("\n");
        MenuHelp.askForEnter("Press \"ENTER\" to continue...");
        System.out.println("Let's start by introducing the leaders of each of the fighting parties");
    }

    // CREATE PLAYERS AND PARTIES
    public static void setPlayer(Player player) {

        // Set player's name:
        player.setName(MenuHelp.askForString(player.getName() + ", please introduce your name"));
        System.out.println("We salute you Leader " + player.getName());

        // Set player's party:
        String[] partyOptions = new String[3];
        partyOptions[0] = "Create your party randomly";
        partyOptions[1] = "Create Warriors and Wizards individually";
        partyOptions[2] = "Import a party using a CSV file";

        int selected = MenuHelp.selectOption("Please select the way you want to create your party:", partyOptions);
        System.out.println("Let's get this party started!!!!");

        GameUtils partyGenerator = new GameUtils();
        switch(selected){
            case 0:
                System.out.println("\t***************************************************");
                System.out.println("\tCreating party randomly...");
                System.out.println("\t***************************************************");
                player.setParty(partyGenerator.createRandomParty());
                break;
            case 1:
                System.out.println("\t***************************************************");
                System.out.println("\tCreating Warriors and Wizards individually...");
                System.out.println("\t***************************************************");
                player.setParty(partyGenerator.createCustomizedParty());
                break;
            case 2:
                System.out.println("\t***************************************************");
                System.out.println("\tImporting party using a CSV file...");
                System.out.println("\t***************************************************");
                try{
                    player.setParty(partyGenerator.createCsvParty());
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found, we will create your party manually");
                    player.setParty(partyGenerator.createCustomizedParty());
                }
                break;
            default:
                System.out.println("\nOption not available.");
        }
        // Show player's party:
        System.out.println("\tFighters added:");
        MenuHelp.printList(player.getParty());
        System.out.println("\nParty completed. Good job " + player.getName() + "!!!!");
        System.out.println("\n");
    }

    // SHOW BATTLES INTRO
    public static void showBattlesIntro() {
        System.out.println("\n");
        System.out.println("Looks like we are all set now, so...");
        System.out.println("Let the battles begin!!!");
        MenuHelp.askForEnter("Press \"ENTER\" to continue...");
    }

    // BATTLE
    public static int battle(int battlesPlayed, Player p1, Player p2, Graveyard graveyard) {
        System.out.println("***************************************************");
        System.out.println("BATTLE " + (battlesPlayed+1));
        System.out.println("***************************************************");

        // Select combatants
        selectCombatants(p1);
        selectCombatants(p2);

        System.out.println("\n");
        System.out.println("You have selected your combatant on both sides...");
        System.out.println("Combatants get ready, the battle starts now!");
        MenuHelp.askForEnter("Press \"ENTER\" to continue...");

        // Start battle:
        Battle battle = new Battle();
        int battleResult = battle.initBattle(p1.getCurrentCombatant(), p2.getCurrentCombatant());

        // Show result + declare battle winner
        switch(battleResult){
            case 0:
                System.out.println("\n");
                System.out.println("There was a tie!" );
                System.out.println("No party won, no party lost his fighter." );
                break;
            case 1:
                System.out.println("\n");
                System.out.println(p1.getCurrentCombatant().getName() + " from " + p1.getName() + "'s party has won this battle. Congratulations!" );
                p1.winBattle();
                System.out.println(p2.getName() + "'s party lost his fighter " + p2.getCurrentCombatant().getName());
                p2.loseBattle();
                // TAKE TO GRAVEYARD -----------------------------------------------------------------------------------------------!

                break;
            case 2:
                System.out.println("\n");
                System.out.println(p2.getCurrentCombatant().getName() + " from " + p2.getName() + "'s party has won this battle. Congratulations!" );
                p2.winBattle();
                System.out.println(p1.getName() + "'s party lost his fighter " + p1.getCurrentCombatant().getName());
                p1.loseBattle();
                // TAKE TO GRAVEYARD -----------------------------------------------------------------------------------------------!

                break;
            default:
                System.out.println("\nOption not available.");
        }


        // COUNT:
        System.out.println("\nAfter this hard battle this is how both parties came out:" );
        System.out.println("\t---------------------------------------------------------------------");
        System.out.println("\t" + p1.getName() +  "'s party has won " + p1.getBattlesWon() + " battles and has " + p1.getParty().size() + " members");
        System.out.println("\t" + p2.getName() +  "'s party has won " + p2.getBattlesWon() + " battles and has " + p2.getParty().size() + " members");
        showGraveyard(graveyard);
        System.out.println("\t---------------------------------------------------------------------");
        MenuHelp.askForEnter("\nPress \"ENTER\" to continue...");
        return battlesPlayed + 1;
    }

    public static void selectCombatants(Player p) {
        System.out.println("Who will be the brave combatants this time for " + p.getName() + "?");
        p.setCurrentCombatant(MenuHelp.selectOption(p.getName() + ", please select the combatant you want to fight for your party:", p.getParty()));
        System.out.println("Good choice " + p.getName() + "!");
        System.out.println("\n");
    }
    public static void showGraveyard(Graveyard graveyard) {
        System.out.println("\n\tThere are " + graveyard.getGraveyard().size() + " fighters in the graveyard: ");
        MenuHelp.printList(graveyard.getGraveyard());
    }

    // DECLARE A WINNER
    public static void declareWinner(int battlesPlayed, Player p1, Player p2) {

        Player winner = p1.getParty().size() > 0 ? p1 : p2;

        System.out.println("\n");
        System.out.println("After " + battlesPlayed + " great battles one of the parties has run out of members.");
        System.out.println("This means the war has ended and we have a winner...");
        System.out.println("\n");
        System.out.println("Congratulations " + winner.getName() + " for you are the final winner!!!");
        System.out.println("\n");
        exportOrContinue(winner.getParty());

    }


    // export party
    public static void exportOrContinue(List<Character> party){

        String[] partyOptions = new String[2];
        partyOptions[0] = "Export winner party";
        partyOptions[1] = "Let them break ranks";

        boolean result = false;
        int selected = MenuHelp.selectOption("Yours is certainly a valuable party... would you like to export it for future adventures?", partyOptions);
        switch(selected){
            case 0:
                System.out.println("Great, we have saved it to a csv file!");
                try{
                    GameUtils.exportToCsv(party);
                } catch (IOException ex) {
                    System.out.println("Oops, looks like they need a rest... the file could not be created");
                }

                break;
            case 1:
                System.out.println("You're right, they've already worked a lot!");
                break;

        }
    }
    public static boolean endOrRestart(){

        String[] partyOptions = new String[2];
        partyOptions[0] = "Start a new game!";
        partyOptions[1] = "Exit";

        boolean result = false;
        int selected = MenuHelp.selectOption("What would you like to do now?", partyOptions);
        switch(selected){
            case 0:
                System.out.println("Great, let's start again!");
                break;
            case 1:
                System.out.println("Hope you enjoyed!");
                System.out.println("Bye!!!");
                result = true;
                break;

        }
        return result;
    }




}