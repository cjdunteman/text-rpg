package package01;

import package04.Level5Dungeon;
import package03.Monster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
//    Story story = new Story(this, ui, vm);
    Monster monster = new Monster();
    Player player = new Player();
    Level5Dungeon dungeon = new Level5Dungeon(this, ui, vm, player, monster);

    public String nextPosition1;
    public String nextPosition2;
    public String nextPosition3;
    public String nextPosition4;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createUI(cHandler);
        vm.showTitleScreen();
//        story.defaultSetup();

        player.initialStats();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(yourChoice) {
                case "start": vm.menuScreen(null, player, cHandler); break;
                case "viewQuests": vm.menuScreen("viewQuests", player, cHandler); break;
                case "viewPlayer": vm.menuScreen("viewPlayer", player, cHandler); break;
                case "viewDungeons": vm.menuScreen("viewDungeons", player, cHandler); break;
                case "doLvl5Dungeon": vm.dungeon(); dungeon.selectPosition("initial", player, cHandler); break;
                case "c1": dungeon.selectPosition(nextPosition1, player, cHandler); break;
                case "c2": dungeon.selectPosition(nextPosition2, player, cHandler); break;
                case "c3": dungeon.selectPosition(nextPosition3, player, cHandler); break;
                case "c4": dungeon.selectPosition(nextPosition4, player, cHandler); break;
                default:
                    throw new IllegalStateException("Unexpected value: " + yourChoice);
            }
        }


    }
}
