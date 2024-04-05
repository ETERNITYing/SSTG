package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class Sector {
    Constant CONST =new Constant();
    double x_Boss, y_Boss, x_Snake, y_Snake;
    double x_1, y_1;
    double x_2, y_2;
    double x_3, y_3;
    double speed = 7;
    private Rectangle hitbox1;
    private Rectangle hitbox2;
    private Rectangle hitbox3;
    private boolean hitbox1C = true;
    private boolean hitbox2C = true;
    private boolean hitbox3C = true;
    private int atk = 1;
    Image im = Toolkit.getDefaultToolkit().getImage(("E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources\\littlepony.jpg"));

    public Sector(int x_Boss, int y_Boss,int x_Snake, int y_Snake) {
        this.x_Boss = x_Boss;
        this.x_Snake = x_Snake;
        this.x_1 = x_Boss;
        this.x_2 = x_Boss;
        this.x_3 = x_Boss;
        this.y_Boss = y_Boss;
        this.y_Snake = y_Snake;
        this.y_1 = y_Boss;
        this.y_2 = y_Boss;
        this.y_3 = y_Boss;
        hitbox1 = new Rectangle(x_Boss, y_Boss, 30,30);
        hitbox2 = new Rectangle(x_Boss, y_Boss, 30,30);
        hitbox3 = new Rectangle(x_Boss, y_Boss, 30,30);
    }
    void drawSector (Graphics g) {
        logic();
        g.setColor(Color.red);
//        g.drawRect(x, y,  5 * (1 - w), 5 * w);
//        System.out.println("draw");
//        g.fillOval(x,y,15,15);
        if (hitbox1C) g.drawImage(im,(int)x_1,(int)y_1,15,15,null);
        if (hitbox2C) g.drawImage(im,(int)x_2,(int)y_2,15,15,null);
        if (hitbox3C) g.drawImage(im,(int)x_3,(int)y_3,15,15,null);

    }

    void logic() {
        move();
    }

    void move() {
        double x_m1, y_m1;
        x_m1 = x_Snake - x_Boss;
        y_m1 = y_Snake - y_Boss;
        double sqrt = Math.sqrt(Math.pow(x_m1, 2) + Math.pow(y_m1, 2));
        x_1 += speed * (x_m1/ sqrt);
        y_1 += speed * (y_m1/ sqrt);

        double x_m2, y_m2;
        x_m2 = x_m1 * 0.939 + y_m1 * (-0.342);
        y_m2 = x_m1 * 0.324 + y_m1 * 0.939;
        x_2 += speed * (x_m2/ sqrt);
        y_2 += speed * (y_m2/ sqrt);

        double x_m3, y_m3;
        x_m3 = x_m1 * 0.939 + y_m1 * 0.342;
        y_m3 = x_m1 * (-0.324) + y_m1 * 0.939;
        x_3 += speed * (x_m3/ sqrt);
        y_3 += speed * (y_m3/ sqrt);

        try {
            hitbox1.setLocation((int)x_1, (int)y_1);
            hitbox2.setLocation((int)x_2, (int)y_2);
            hitbox3.setLocation((int)x_3, (int)y_3);
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
        }
    }
    public int getAtk() {
        return atk;
    }
}
