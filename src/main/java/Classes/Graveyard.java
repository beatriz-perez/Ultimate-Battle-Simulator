package Classes;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    private List<Character> graveyard = new ArrayList<>();

    public Graveyard() {
    }

    public void addFighter(Character fighter) {
        graveyard.add(fighter);
    }

    public List<Character> getGraveyard() {
        return graveyard;
    }
}
