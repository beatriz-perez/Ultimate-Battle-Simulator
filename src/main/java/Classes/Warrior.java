package Classes;

import Interfaces.Attacker;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    private final int minHp = 100;
    private final int maxHp = 200;

    private final int minStamina = 10;
    private final int maxStamina = 50;
    private final int minStrength = 1;
    private final int maxStrength = 10;

    //    Constructor for customized parties.
    public Warrior(String name, int hp, int stamina, int strength) {
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
        if (stamina > maxStamina) {
            stamina = maxStamina;
        } else if (stamina < minStamina) {
            stamina = minStamina;
        } else {
            stamina = stamina;
        }
        this.stamina = stamina;
        setStrength(strength);
    }

    //    Constructor for randomized parties.
    public Warrior() {
        String[] names = {"If", "Tyunn", "Aun", "Tyorgrirn", "Vorrus", "Grafralf", "Raslerd", "Thrunskulr", "Eirkmuvoth", "Stappaekkag"};
        setName(names[GameUtils.random(0, names.length - 1)]);
        super.setHp(GameUtils.random(minHp, maxHp));
        this.stamina = GameUtils.random(minStamina, maxStamina);
        this.strength = GameUtils.random(minStrength, maxStrength);
    }

    public void setName(String name) {
        super.setName("Warrior " + name);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    //    Modify the setter so that the strength is inside de range required.
    public void setStrength(int strength) {
        if (strength > maxStrength) {
            strength = maxStrength;
        } else if (strength < minStrength) {
            strength = minStrength;
        } else {
            strength = strength;
        }
        this.strength = strength;
    }

    //    Warrior's attack
    public int attack() {
        int damage = 0;
        if (stamina >= 5) {
            System.out.println(getName() + " performed a " + getStrength() + " point Heavy attack ");
            damage = strength;
            stamina = stamina - 5;
            return damage;
        } else {
            System.out.println(getName() + " performed a " + getStrength() / 2 + " point Weak attack");
            damage = strength / 2;
            stamina = stamina + 1;
            return damage;
        }
    }
}