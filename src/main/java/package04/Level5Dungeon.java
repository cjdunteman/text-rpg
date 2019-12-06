package package04;

import package01.Game;
import package01.Player;
import package01.UI;
import package01.VisibilityManager;
import package03.Goblin;
import package03.Monster;

public class Level5Dungeon extends Dungeon {

    public Monster goblin;

    public Level5Dungeon(Game g, UI userInterface, VisibilityManager vManager, Player player, Monster m) {
        game = g;
        ui = userInterface;
        vm = vManager;
        name = "Level 5 Dungeon";
        lvl = 5;
        xpReward = 100;
    }

        public void selectPosition(String nextPosition, Player player, Game.ChoiceHandler cHandler) {
            switch (nextPosition) {
                case "initial":
                    chooseDirection(player, cHandler);
                    break;
                case "north":
                case "south":
                case "east":
                case "west":
                    goblin(player, cHandler);
                    break;
            }
        }

    public void chooseDirection(Player player, Game.ChoiceHandler cHandler) {
        ui.lvlNumberLabel.setText("" + player.getHP());
        ui.mainTextArea.setText("Which way will you go?");
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        game.nextPosition1 = "north";
        game.nextPosition2 = "south";
        game.nextPosition3 = "east";
        game.nextPosition4 = "west";
    }

        public void goblin(Player player, Game.ChoiceHandler cHandler) {
            goblin = new Goblin();
            ui.mainTextArea.setText("A Goblin appears!\nHP: " + goblin.getHP());
            ui.choice1.setText("Attack");
            ui.choice2.setText("Heal");
            ui.choice3.setText("Run");
            ui.choice4.setText("");

            game.nextPosition1 = "attack";
            game.nextPosition2 = "heal";
            game.nextPosition3 = "run";
            game.nextPosition4 = "";
        }

}
