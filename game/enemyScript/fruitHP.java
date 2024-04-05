package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class fruitHP {
    private Constant CONST = new Constant();
    private int hp_fruit;
    private int atk_fruit;
    private int x_f;
    private int y_f;
    private Rectangle hitbox_head;
    String resUrl = "E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources";
    Image fruitHP = Toolkit.getDefaultToolkit().getImage(resUrl+"\\HP_potion.png");

    public fruitHP() {
        x_f = (int) (Math.random() * (CONST.SCREEN_WIDTH-40));
        y_f = (int) (Math.random() * (CONST.SCREEN_HEIGHT-40));
        hp_fruit = 1;
        hitbox_head = new Rectangle(x_f,y_f,40,40);
    }
    public void drawfuncfruit(Graphics g) {
        g.drawImage(fruitHP, x_f, y_f, 40, 40, null);
    }
    public void setHitbox_head(Rectangle hitbox_head) {
        this.hitbox_head = hitbox_head;
    }

    public Rectangle getHitbox_head() {
        return hitbox_head;
    }
    public int getHp_fruit() {
        return hp_fruit;
    }
}


