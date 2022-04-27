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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the number of warriors");
        int warriorsNumber = scanner.nextInt();
        System.out.println("Insert the number of wizards ");
        int wizardsNumber = scanner.nextInt();
        List<Character> customizedParty = new ArrayList<>();
        while (customizedParty.size() <= warriorsNumber) {
            System.out.println("Write the warrior's name");
            String warriorName = scanner.nextLine();
            for(int i = 0; i < customizedParty.size(); i ++){
                if(warriorName.equals(customizedParty.get(i).getName())){
                    warriorName = warriorName + "Jr";
                }
            }
            System.out.println("Insert health points");
            int warriorHp = scanner.nextInt();
            while (warriorHp < 100 || warriorHp > 200) {
                System.err.println("health points must be a number between 100-200 ");
                warriorHp = scanner.nextInt();
            }
            System.out.println("Insert stamina value");
            int stamina = scanner.nextInt();
            while (stamina < 10 || stamina > 50) {
                System.err.println("Stamina must be a number between 10-50 ");
                stamina = scanner.nextInt();
            }
            System.out.println("Insert strength value");
            int strength = scanner.nextInt();
            while (strength < 1 || strength > 10) {
                System.err.println("Strength must be a number between 1-10 ");
                strength = scanner.nextInt();
            }
            customizedParty.add(new Warrior(warriorName, warriorHp, stamina, strength));
        }
        while (customizedParty.size() <= warriorsNumber + wizardsNumber) {
            System.out.println("write the wizard's name");
            String wizardName = scanner.nextLine();
            for(int i = 0; i < customizedParty.size(); i ++){
                if(wizardName.equals(customizedParty.get(i).getName())){
                    wizardName = wizardName + "Jr";
                }
            }
            System.out.println("Insert health points");
            int wizardHp = scanner.nextInt();
            while (wizardHp < 50 || wizardHp > 100) {
                System.err.println("health points must be a number between 100-200 ");
                wizardHp = scanner.nextInt();
            }
            System.out.println("Insert mana value");
            int mana = scanner.nextInt();
            while (mana < 10 || mana > 50) {
                System.err.println("Mana must be a number between 10-50 ");
                mana = scanner.nextInt();
            }
            System.out.println("Insert intelligence value");
            int intelligence = scanner.nextInt();
            while (intelligence < 1 || intelligence > 10) {
                System.err.println("Intelligence must be a number between 1-10 ");
                intelligence = scanner.nextInt();
            }
            customizedParty.add(new Wizard(wizardName, wizardHp, mana, intelligence));
        }
        scanner.close();
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
            if(charData[0].equals("Warrior")){
                csvParty.add(new Warrior(charData[1], Integer.parseInt(charData[2]), Integer.parseInt(charData[3]), Integer.parseInt(charData[4])));
            }else if(charData[0].equals("Wizard")){
                csvParty.add(new Wizard(charData[1], Integer.parseInt(charData[2]), Integer.parseInt(charData[3]), Integer.parseInt(charData[4])));
            }
        }
        scanner.close();
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







