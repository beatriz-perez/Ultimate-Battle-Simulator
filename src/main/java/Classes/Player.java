package Classes;

import java.util.List;

public class Player {

    // Properties
    private String name;
    private List<Character> party;
    private List<Character> graveyard;
    private Character currentCombatant;
    private int battlesWon;

    // Constructors
    public Player(String name) {
        this.name = name;
        this.battlesWon = 0;
    }

    //METHODS:
    public void winBattle() {
        this.battlesWon++;
    }
    public void loseBattle() {
        this.getParty().remove(this.getCurrentCombatant());
        this.getGraveyard().add(this.getCurrentCombatant());
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    //public void setParty(Party party) {this.party = party; }
    public void setParty(List<Character> party) {this.party = party; }
    public void setCurrentCombatant(Character currentCombatant) {this.currentCombatant = currentCombatant; }

    // Getters
    public String getName() {
        return name;
    }
    public List<Character> getParty() {return party; }

    public List<Character> getGraveyard() {return graveyard; }

    public int getBattlesWon() {return battlesWon; }
    public Character getCurrentCombatant() {return currentCombatant; }
}