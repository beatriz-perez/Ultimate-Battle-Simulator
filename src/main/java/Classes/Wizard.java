package Classes;

import Interfaces.Attacker;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;
    private final int minMana = 10;
    private final int maxMana = 50;

    private final int minHp = 50;
    private final int maxHp = 100;

    private final int minIntelligence = 1;
    private final int maxIntelligence = 50;

    //    Constructor for customized parties.
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setName(name);
        if (hp > maxHp) {
            hp = maxHp;
        } else if (hp < minHp) {
            hp = minHp;
        } else {
            hp = hp;
        }
        super.setHp(hp);
        if (mana > maxMana) {
            mana = maxMana;
        } else if (mana < minMana) {
            mana = minMana;
        } else {
            mana = mana;
        }
        this.mana = mana;
        setIntelligence(intelligence);
    }

    //    Constructor for randomized parties.
    public Wizard() {
        String[] names = {"Urhan", "Ejamar", "Qrutrix", "Oruxeor", "Ushan", "Ugovras", "Igoxium", "Ataz", "Ilrolius", "Azadium"};
        setName(names[GameUtils.random(0, names.length - 1)]);
        super.setHp(GameUtils.random(minHp, maxHp));
        this.mana = GameUtils.random(minMana, maxMana);
        this.intelligence = GameUtils.random(minIntelligence, maxIntelligence);
    }

    public void setName(String name) {
        super.setName("Wizard " + name);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    //    Modify the setter so that the intelligence is inside de range required.
    public void setIntelligence(int intelligence) {
        if (intelligence > maxIntelligence) {
            intelligence = maxIntelligence;
        } else if (intelligence < minIntelligence) {
            intelligence = minIntelligence;
        } else {
            intelligence = intelligence;
        }
        this.intelligence = intelligence;
    }

    //    Wizard's attack
    public int attack() {
        int damage = 0;
        if (mana >= 5) {
            System.out.println(getName() + " performed a " + getIntelligence() + " point Fireball");
            damage = intelligence;
            mana = mana - 5;
            return damage;
        } else {
            System.out.println(getName() + " performed a 2 point Staff hit");
            damage = 2;
            mana = mana + 1;
            return damage;
        }
    }
}