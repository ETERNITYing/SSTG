package main.java.game.enemyScript;

import main.java.Constant;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.Random;

public class CompleteScreen{
    Constant CONST =new Constant();
    int x = 0, y = 0, w = 0;
    int side = 0;
    double speed;
    private Rectangle hitbox;
    private int atk = 1;

    public CompleteScreen (int side) {
        this.side = side; //(int)(Math.random() * 4) +1;
        switch (side) {
            case 3:
                x = -20;
                y = (int) (Math.random() * (CONST.SCREEN_HEIGHT-30)) + 1;
                w = 0;
                break;
            case 0:
                x = (int) (Math.random() * (CONST.SCREEN_WIDTH-30)) + 1;
                y = -20;
                w = 1;
                break;
            case 2:
                x = CONST.SCREEN_WIDTH+20;
                y = (int) (Math.random() * (CONST.SCREEN_HEIGHT-30)) + 1;
                w = 0;
                break;
            case 1:
                x = (int) (Math.random() * (CONST.SCREEN_WIDTH-30)) + 1;
                y = CONST.SCREEN_HEIGHT+20;
                w = 1;
                break;
        }
        hitbox = new Rectangle(x, y, 20,20);
    }
    void drawCompleteScreen( Graphics g) {
        logicCompleteScreen();
        g.setColor(Color.red);
        g.drawOval(x, y,20,20);
//        g.drawRect(x, y,  5 * (1 - w), 5 * w);
//        System.out.println("draw");
//        g.fillOval(x,y,15,15);
//        Image im = Toolkit.getDefaultToolkit().getImage(("C:\\Users\\steve\\OneDrive\\圖片\\278805904_4953606611399282_3522028787925398853_n.jpg"));
//        g.drawImage(im,x,y,15,15,null);

    }

    void logicCompleteScreen() {
        runCompleteScreen();
    }

    void runCompleteScreen() {
        switch (side) {
            case 3:
                x += 8;
                break;
            case 0:
                y += 8;
                break;
            case 2:
                x += -8;
                break;
            case 1:
                y += -8;
                break;
        }
        hitbox.setLocation(x, y);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public int getAtk() {
        return atk;
    }
}
