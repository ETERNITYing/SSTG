package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class fruitAttack {
    private Constant CONST = new Constant();
    private int hp_fruit;
    private int atk_fruit;
    private int x_f;
    private int y_f;
    private Rectangle hitbox_head;
    String resUrl = "E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources";
    Image fruitAtk = Toolkit.getDefaultToolkit().getImage(resUrl+"\\Attack_potion.png");
    public fruitAttack() {
        x_f = (int) (Math.random() * CONST.SCREEN_WIDTH);
        y_f = (int) (Math.random() * CONST.SCREEN_HEIGHT);
        atk_fruit = 1;
        hitbox_head = new Rectangle(x_f,y_f,40,40);
    }
    public void drawfuncfruit(Graphics g) {
        g.drawImage(fruitAtk, x_f, y_f, 40, 40, null);
    }
    public void setHitbox_head(Rectangle hitbox_head) {
        this.hitbox_head = hitbox_head;
    }

    public Rectangle getHitbox_head() {
        return hitbox_head;
    }
    public int getAtk_fruit() {
        return atk_fruit;
    }
}