package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GameUtils {

    private final int MAX_CHAR = 10;

    public static int random (int min, int max){
        int randomNumber = ((int) Math.floor(Math.random() * (max - min + 1) + min));
        return randomNumber;
    }

    /**
     * this method creates a party with a random number of characters
     * @return The list of characters
     */
    public List<Character> createRandomParty(){
        int wizardNumber = random(1,MAX_CHAR);
        int warriorNumber = random(1,MAX_CHAR);

        List<Character> randomParty = new ArrayList<>();
        while(randomParty.size() <= wizardNumber) {
            Wizard wizardAux = new Wizard();
            // the contains method calls to equals method that has been changed in character class
            if(randomParty.contains(wizardAux)){
                String[] name = wizardAux.getName().split(" ");
                wizardAux.setName( name[1] + " Jr.");
            }
            randomParty.add(wizardAux);
        }
        while(randomParty.size() <= warriorNumber + wizardNumber){
            Warrior warriorAux = new Warrior();
            if(randomParty.contains(warriorAux)){
                String[] name = warriorAux.getName().split(" ");
                warriorAux.setName( name[1] + " Jr.");
            }
            randomParty.add(warriorAux);
        }

        return randomParty;
    }

    /**
     * This method creates a list of customized characters
     * @return
     */
    public List<Character> createCustomizedParty() {
        int warriorsNumber = MenuHelp.askForIntInRange("Insert the number of warriors (1 to 100)", 1, 100);

        int wizardsNumber = MenuHelp.askForIntInRange("Insert the number of wizards (1 to 100)", 1, 100);

        List<Character> customizedParty = new ArrayList<>();

        while (customizedParty.size() < warriorsNumber) {
            String warriorName = MenuHelp.askForString("Write the warrior's name");

            for(int i = 0; i < customizedParty.size(); i ++){
                if(warriorName.equals(customizedParty.get(i).getName())){
                    warriorName = warriorName + "Jr";
                }
            }
            int warriorHp = MenuHelp.askForIntInRange("Insert health (between 100-200 points)", 100, 200);

            int stamina = MenuHelp.askForIntInRange("Insert stamina value (between 10-50 points)", 10, 50);

            int strength = MenuHelp.askForIntInRange("Insert strength value (between 1-10 points)", 1, 10);

            customizedParty.add(new Warrior(warriorName, warriorHp, stamina, strength));
        }
        while (customizedParty.size() < warriorsNumber + wizardsNumber) {
            String wizardName = MenuHelp.askForString("Write the wizard's name");

            for(int i = 0; i < customizedParty.size(); i ++){
                if(wizardName.equals(customizedParty.get(i).getName())){
                    wizardName = wizardName + "Jr";
                }
            }

            int wizardHp = MenuHelp.askForIntInRange("Insert health (between 50-100 points)", 50, 100);

            int mana = MenuHelp.askForIntInRange("Insert mana value (between 10-50 points)", 10, 50);

            int intelligence = MenuHelp.askForIntInRange("Insert intelligence value (between 1-10 points)", 1, 10);

            customizedParty.add(new Wizard(wizardName, wizardHp, mana, intelligence));
        }

        return customizedParty;
    }

    /**
     *
     * @return this method creates a list from a csv file
     * @throws FileNotFoundException
     */
    public List<Character> createCsvParty() throws FileNotFoundException {
        List<Character> csvParty = new ArrayList<>();
        File file = new File("character_creator.csv");
        Scanner scanner = new Scanner(file);
        String data = scanner.nextLine();//starting in the second line
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            String[] charData = data.split(",");
            if(charData[0].toLowerCase().equals("warrior")){
                csvParty.add(new Warrior(charData[1], Integer.parseInt(charData[2]), Integer.parseInt(charData[3]), Integer.parseInt(charData[4])));
            }else if(charData[0].toLowerCase().equals("wizard")){
                csvParty.add(new Wizard(charData[1], Integer.parseInt(charData[2]), Integer.parseInt(charData[3]), Integer.parseInt(charData[4])));
            }
        }

        return csvParty;
    }
    public static void exportToCsv(List<Character> party) throws IOException {
        FileWriter writer = new FileWriter("Party.txt",true);
        for (int i = 0; i < party.size(); i++) {
            writer.write(party.get(i)+" \n");
        }
        writer.close();
    }

}







