package Classes;

public abstract class Character {
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;
    private static int characterCounter;

    //    Constructor for customized parties.
    public Character(String name, int hp) {
        characterCounter++;
        this.id = characterCounter;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    //    Constructor for randomized parties.
    public Character() {
        characterCounter++;
        this.id = characterCounter;
        this.isAlive = true;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    //    Modify the setter so that there's no negative health points.
    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int decreaseHp(int damage) {
        setHp(getHp() - damage);
        return getHp();
    }

    public String toString() {
        return "Character { " +
                "id : " + id +
                ", name : '" + name + '\'' +
                ", hp : " + hp +
                ", isAlive : " + isAlive +
                '}';
    }

    public boolean equals(Object o) {
        if (this.name.equals(((Character) o).getName())) {
            return true;
        } else {
            return false;
        }
    }
}
