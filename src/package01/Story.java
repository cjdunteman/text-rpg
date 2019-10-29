package package01;

import package02.Knife;
import package03.Gandalf;
import package03.Goblin;
import package03.Monster;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    Monster monster;

    public String name = "quest";
    int silverRing;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.lvl = 1;
        ui.lvlNumberLabel.setText("" + player.lvl);

        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Knife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        silverRing = 0;
    }

    public void selectPosition(String nextPosition) {
        switch(nextPosition) {
            case "townGate": townGate(); break;
            case "talkGuard": talkGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "fight": fight(); break;
            case "playerAttack": playerAttack(); break;
            case "monsterAttack": monsterAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "ending": ending(); break;
            case "toTitle": toTitle(); break;
        }
    }

    public void townGate() {
        ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void talkGuard() {
        if (silverRing == 0) {
            ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town");
            ui.choice1.setText("");
            ui.choice2.setText("Attack the guard");
            ui.choice3.setText("Leave");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "attackGuard";
            game.nextPosition3 = "crossRoad";
            game.nextPosition4 = "";
        }
        else if (silverRing == 1) {
            ending();
        }
    }

    public void attackGuard() {
        ui.mainTextArea.setText("Guard: Hey don't be stupid! \n\nThe guard attacked you so hard and gave up. \n(You received 3 damage)");
        player.hp = player.hp - 3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void crossRoad() {
        ui.mainTextArea.setText("You are at the crossroad. \nIf you go south, you will go back to the town");
        ui.choice1.setText("Go north");
        ui.choice2.setText("Go south");
        ui.choice3.setText("Go east");
        ui.choice4.setText("Go west");

        game.nextPosition1 = "north";
        game.nextPosition2 = "south";
        game.nextPosition3 = "east";
        game.nextPosition4 = "west";
    }

    public void north() {
        int i = new java.util.Random().nextInt(100+1);
        if (i<90) {
            monster = new Goblin();
        } else {
            monster = new Gandalf();
        }
        ui.mainTextArea.setText("You encountered a " + monster.name + "!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossroad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void south() {

    }

    public void east() {

    }

    public void west() {

    }

    public void fight() {
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "crossroad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack() {
        int playerDamage = 0;
        playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);

        ui.mainTextArea.setText("You attacked the monster " + monster.name + " and gave " + playerDamage + " damage!");

        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.hp <= 0) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void monsterAttack() {
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText(monster.attackMessage + "\nYou received " + monsterDamage + " damage    !");

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (player.hp <= 0) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

        public void win() {
            ui.mainTextArea.setText("You've defeated the " + monster.name + "!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring!");

            silverRing = 1;

            ui.choice1.setText("Go east");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossroad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        public void lose() {
            ui.mainTextArea.setText("You are dead!\n\nGame Over.");

            ui.choice1.setText("To the title screen");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "toTitle";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        public void ending() {
            ui.mainTextArea.setText("Oh, you killed that goblin!?\nThank you so much. You are a true hero!\nWelcome to our town!\n\nThe end");

            ui.choice1.setVisible(false);
            ui.choice2.setVisible(false);
            ui.choice3.setVisible(false);
            ui.choice4.setVisible(false);
        }

        public void toTitle() {
            defaultSetup();
            vm.showTitleScreen();
        }
}
