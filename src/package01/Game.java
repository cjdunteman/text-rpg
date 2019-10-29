package package01;

import package04.Dungeon;
import package04.Level5Dungeon;
import package03.Monster;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);
    Player player = new Player();
    Monster monster = new Monster();
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
        story.defaultSetup();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(yourChoice) {
                case "start": vm.menuScreen(null); story.defaultSetup(); break;
                case "viewQuests": vm.menuScreen("viewQuests"); break;
                case "viewPlayer": vm.menuScreen("viewPlayer"); break;
                case "viewDungeons": vm.menuScreen("viewDungeons"); break;
                case "doLvl5Dungeon": vm.titleToTown(); dungeon.selectPosition("townGate"); break;
                case "c1": story.selectPosition(nextPosition1); break;
                case "c2": story.selectPosition(nextPosition2); break;
                case "c3": story.selectPosition(nextPosition3); break;
                case "c4": story.selectPosition(nextPosition4); break;
            }
        }


    }
}
