package Classes;

public abstract class Character {
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;
    private static int characterCounter;


    public Character(String name, int hp) {
        characterCounter++;
        this.id = characterCounter;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public Character() {
        characterCounter++;
        this.id = characterCounter;
        this.isAlive = true;
    }

    public Character(String[] csvData) {
        characterCounter++;
        this.id = characterCounter;
        this.name = csvData[2];
        this.hp = Integer.parseInt(csvData[3]);
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

    public void setHp(int hp) {
        this.hp = hp;
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
    public int random(int min, int max) {
        int randomNumber = ((int) Math.floor(Math.random() * (max - min + 1) + min));
        return randomNumber;
    }

    public String toString (){
        return "Character { "+
                "id : " + id +
                ", name : '" + name + '\'' +
                ", hp : " + hp +
                ", isAlive : " + isAlive +
                '}';
    }
    public boolean equals (Object o){
        if(this.name.equals(((Character)o).getName())){
            return true;
        }else{
            return false;
        }
    }
}
