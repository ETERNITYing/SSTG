package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class Circle {
    Constant CONST =new Constant();
    double x, y;
    double x_1, y_1;
    double x_2, y_2;
    double x_3, y_3;
    double x_4, y_4;
    double x_5, y_5;
    double x_6, y_6;
    double speed;
    private Rectangle hitbox1;
    private Rectangle hitbox2;
    private Rectangle hitbox3;
    private Rectangle hitbox4;
    private Rectangle hitbox5;
    private Rectangle hitbox6;
    private boolean hitbox1C = true;
    private boolean hitbox2C = true;
    private boolean hitbox3C = true;
    private boolean hitbox4C = true;
    private boolean hitbox5C = true;
    private boolean hitbox6C = true;
    private int atk = 1;
    Image im = Toolkit.getDefaultToolkit().getImage(("D:\\Java\\SSTG\\src\\main\\ressources\\littlepony.jpg"));

    public Circle(int x, int y) {
        this.x = x;
        this.x_1 = x;
        this.x_2 = x;
        this.x_3 = x;
        this.x_4 = x;
        this.x_5 = x;
        this.x_6 = x;
        this.y = y;
        this.y_1 = y;
        this.y_2 = y;
        this.y_3 = y;
        this.y_4 = y;
        this.y_5 = y;
        this.y_6 = y;
        hitbox1 = new Rectangle(x, y, 30,30);
        hitbox2 = new Rectangle(x, y, 30,30);
        hitbox3 = new Rectangle(x, y, 30,30);
        hitbox4 = new Rectangle(x, y, 30,30);
        hitbox5 = new Rectangle(x, y, 30,30);
        hitbox6 = new Rectangle(x, y, 30,30);
    }
    void drawCircle (Graphics g) {
        logicCircle();
        g.setColor(Color.red);
//        g.drawRect(x, y,  5 * (1 - w), 5 * w);
//        System.out.println("draw");
//        g.fillOval(x,y,15,15);
        if (hitbox1C) g.drawImage(im,(int)x_1,(int)y_1,15,15,null);
        if (hitbox2C) g.drawImage(im,(int)x_2,(int)y_2,15,15,null);
        if (hitbox3C) g.drawImage(im,(int)x_3,(int)y_3,15,15,null);
        if (hitbox4C) g.drawImage(im,(int)x_4,(int)y_4,15,15,null);
        if (hitbox5C) g.drawImage(im,(int)x_5,(int)y_5,15,15,null);
        if (hitbox6C) g.drawImage(im,(int)x_6,(int)y_6,15,15,null);
    }

    void logicCircle() {
        runCircle();
    }

    void runCircle() {
        x_1 += 10;
        y_1 += 0;

        x_2 += 5;
        y_2 += 8.66;

        x_3 -= 5;
        y_3 += 8.66;

        x_4 -= 10;
        y_4 += 0;

        x_5 -= 5;
        y_5 -= 8.66;

        x_6 += 5;
        y_6 -= 8.66;

        try {
            hitbox1.setLocation((int)x_1, (int)y_1);
            hitbox2.setLocation((int)x_2, (int)y_2);
            hitbox3.setLocation((int)x_3, (int)y_3);
            hitbox4.setLocation((int)x_4, (int)y_4);
            hitbox5.setLocation((int)x_5, (int)y_5);
            hitbox6.setLocation((int)x_6, (int)y_6);
        } catch (Exception e) {

        }
    }
    public Rectangle getHitbox(int i) {
        switch (i) {
            case 1:
                return hitbox1;
            case 2:
                return hitbox2;
            case 3:
                return hitbox3;
            case 4:
                return hitbox4;
            case 5:
                return hitbox5;
            case 6:
                return hitbox6;
        }
        return null;
    }

    public void setCheck(int i) {
        switch (i) {
            case 1 -> {
                hitbox1C = false;
                hitbox1 = null;
            }
            case 2 -> {
                hitbox2C = false;
                hitbox2 = null;
            }
            case 3 -> {
                hitbox3C = false;
                hitbox3 = null;
            }
            case 4 -> {
                hitbox4C = false;
                hitbox4 = null;
            }
            case 5 -> {
                hitbox5C = false;
                hitbox5 = null;
            }
            case 6 -> {
                hitbox6C = false;
                hitbox6 = null;
            }
        }
    }
    public int getAtk() {
        return atk;
    }
}

