package main.java.game.enemyScript;

import main.java.display.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class level_1 {
    public level_1 () {


    }

    public void create(Graphics g) {
        for (int i = 0; i < 10; i++) {
            CompleteScreen a = new CompleteScreen(g);
            b.add(a);
        }

    }

    public void draw (Graphics g) {
        for (CompleteScreen completeScreen: b) {
            completeScreen.drawCompleteScreen(g);
        }
    }
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    private List<CompleteScreen> b = new ArrayList<>();


}