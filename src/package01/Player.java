package package01;

import package02.Knife;
import package02.Weapon;

public class Player {
//    public Knife currentWeapon = new Knife();
    private String name;
    private int lvl;
    private int xp;
    private int hp;
    private int attackDmg;
    private int stamina;

    public void initialStats() {
        this.hp = 10;
        this.xp = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int newLvl) {
        this.lvl = newLvl;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int newHP) {
        this.hp = newHP;
    }

    public int getXP() {
        return xp;
    }

    public void setXP(int newXP) {
        this.xp = newXP;
    }

//    public Object currentWeapon() {
//        Weapon currentWeapon = new Knife();
//        return currentWeapon;
//    }
}
