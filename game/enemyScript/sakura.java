package main.java.game.enemyScript;

import java.awt.*;

public class sakura {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = 0, y = 0, w = 0;
    int side = 2;
    double speed;

    public sakura() {
        switch (side) {
            case 1:
                x = 20;
                y = (int) (Math.random() * screen.height/2) + 1;
                w = 0;
            case 2:
                x = (int) (Math.random() * screen.width/2) + 1;
                y = 20;
                w = 1;
            case 3:
                x = screen.width/2;
                y = (int) (Math.random() * screen.width/2) + 1;
                w = 0;
            case 4:
                x = (int) (Math.random() * screen.width/2) + 1;
                y = screen.height/2;
                w = 1;
        }
    }
    void drawSakura( Graphics g) {
        logicSakura();
        g.setColor(Color.red);
        g.drawRect(x, y,  5 * (1 - w), 5 * w);
        System.out.println("draw");
        g.fillOval(x,y,10,10);

    }

    void logicSakura() {
        runSakura();
    }

    void runSakura() {
        switch (side) {
            case 1:
                x += 1;
            case 2:
                y += 1;
            case 3:
                x += -1;
            case 4:
                y += 1;
        }

    }
}