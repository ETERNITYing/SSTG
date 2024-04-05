package main.java.game.enemyScript;

import main.java.Constant;

import javax.swing.*;
import java.awt.*;

public class boss {
    Constant CONST = new Constant();
    private double x = 50, y = -300;
    int timer = 180;
    double x_c, y_c;
    private int hp;
    private Rectangle body = new Rectangle();
    private Rectangle hitedBox = new Rectangle();
    Image boss = Toolkit.getDefaultToolkit().getImage("E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources\\boss-modified.png");
    public boss () {
        body.setBounds((int)x, (int)y,CONST.SCREEN_HEIGHT/4, CONST.SCREEN_HEIGHT/4);
        hitedBox.setBounds((int)x-CONST.SCREEN_HEIGHT/4, (int)y-CONST.SCREEN_HEIGHT/4, CONST.SCREEN_HEIGHT*3/4, CONST.SCREEN_HEIGHT*3/4);
        hp = 48;
    }
    public void drawBoss(Graphics g){
        logic();
        g.drawImage(boss,(int)x, (int)y-CONST.SCREEN_HEIGHT/8, CONST.SCREEN_HEIGHT/4, CONST.SCREEN_HEIGHT/2, null);
    }
    public void logic() {
        move();
    }
    public void move() {
        if (timer > 0) {
            y+=3;
            timer -= 1;
        }
        body.setLocation((int)x, (int)y);
        hitedBox.setLocation((int)x-CONST.SCREEN_HEIGHT/4, (int)y-CONST.SCREEN_HEIGHT/4);
        x_c = x+(double) CONST.SCREEN_HEIGHT/8;
        y_c = y+(double) CONST.SCREEN_HEIGHT/4;
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Rectangle getBody() {
        return body;
    }

    public void setBody(Rectangle body) {
        this.body = body;
    }

    public Rectangle getHitedBox() {
        return hitedBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitedBox = hitBox;
    }
    public double getX_c() {
        return x_c;
    }

    public double getY_c() {
        return y_c;
    }
}
