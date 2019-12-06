package package01;

public class VisibilityManager {

//    public Player player;
    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;
//        player = new Player();
    }

    public void showTitleScreen() {

        // Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide the game screen
        ui.playerViewPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.questsPanel.setVisible(false);
        ui.menuPanel.setVisible(false);
        ui.dungeonPanel.setVisible(false);
    }
    public void menuScreen(String view, Player player, Game.ChoiceHandler cHandler) {
        if (view == "viewQuests") {
            ui.questsPanel.setVisible(true);
            ui.playerViewPanel.setVisible(false);
        }
        else if (view == "viewPlayer") {
            ui.hpNumberLabel.setText("" + player.getHP());
            ui.playerViewPanel.setVisible(true);
            ui.questsPanel.setVisible(false);
        }
        else if (view == "viewDungeons") {
            ui.dungeonView(cHandler);
            ui.dungeonPanel.setVisible(true);
            ui.playerViewPanel.setVisible(false);
            ui.questsPanel.setVisible(false);
        }
        // Show menu screen
        ui.menuPanel.setVisible(true);

        // Hide other content
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void dungeon() {
        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.questsPanel.setVisible(false);
        ui.menuPanel.setVisible(false);
        ui.playerViewPanel.setVisible(false);
        ui.dungeonPanel.setVisible(false);

        // Show the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
