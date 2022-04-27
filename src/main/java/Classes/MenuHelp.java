package Classes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuHelp {

    //Print List
    public static void printList(String[] optionsList){
        for(int i = 0; i < optionsList.length; i++){
            System.out.println("\t\t" + (i+1) + "." + optionsList[i]);
        }
    }
    public static void printList(List<Character> optionsList){
        for(int i = 0; i<optionsList.size(); i++) {
            System.out.println("\t" + (i+1) + ". " + optionsList.get(i));
        }
    }

    //Select an option from a list
    public static int selectOption(String instruction, String[] optionsList) {
        //Show menu
        System.out.println("\n" + instruction);
        printList(optionsList);
        //Ask for selected option
        int response = askForIntInRange("\n-> Type a number from 1 to " + (optionsList.length), 1, 4);
        //Show selected option
        if (response > 0 && response < optionsList.length + 1) {
            System.out.println("You have selected option " + response + ": " + optionsList[response-1] + "\n");
        }
        return response-1;
    }

    public static Character selectOption(String instruction, List<Character> optionsList) {
        //Show menu
        System.out.println("\n" + instruction);
        printList(optionsList);
        //Ask for selected option
        int response = askForIntInRange("\n-> Type a number from 1 to " + (optionsList.size()), 1, optionsList.size() + 1);
        //Show selected option
        if (response > 0 && response < optionsList.size() + 1) {
            System.out.println("You have selected option " + response + ": " + optionsList.get(response-1).getName() + "\n");
        }
        return optionsList.get(response-1);
    }

    // Ask for enter
    public static void askForEnter(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    //Ask for a string
    public static String askForString(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String entry = "";
        boolean done = false;
        do {
            try {
                entry = scanner.nextLine();
                while(entry.length() < 1 || entry.length() > 20) {
                    System.err.println("Please introduce 1 to 20 characters");
                    entry = scanner.nextLine();
                }
                done = true;
            } catch (Exception var5) {
                System.out.println("You did not introduce a valid text");
                scanner.next();
            }
        } while(!done);
        return entry;
    }

    // Ask for an integer within a range
    public static int askForIntInRange(String question, int min, int max) {
        boolean done = false;
        int entry = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(question);
                entry = scanner.nextInt();
                while(entry < min || entry > max) {
                    System.err.println(entry + " is not a valid option");
                    entry = scanner.nextInt();
                }
                done = true;
            } catch(Exception e){
                System.err.println("You did not introduce a valid integer. Please try again.");
                scanner.next();
            }
        }while(!done);
        return entry;
    }


}