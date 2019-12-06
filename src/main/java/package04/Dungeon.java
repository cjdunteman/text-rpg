package package04;

import package01.Game;
import package01.UI;
import package01.VisibilityManager;

public class Dungeon {
    Game game;
    UI ui;
    VisibilityManager vm;

    public String name;
    public int lvl;
    public int goldReward;
    public int xpReward;
    public boolean completed;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void displayDungeonDetails() {

    }
}


