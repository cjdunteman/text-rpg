package package03;

public class Monster {

    public int hp;
    public String name;
    public int attack;
    public String attackMessage;


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int newHP) {
        this.hp = newHP;
    }

}