package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class bossHP {
    Constant CONST = new Constant();
    private int hp;
    class url {
        String resUrl = "E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources";
        Image _0 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\0.png");
        Image _1 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\1.png");
        Image _2 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\2.png");
        Image _3 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\3.png");
        Image _4 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\4.png");
        Image _5 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\5.png");
        Image _6 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\6.png");
        Image _7 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\7.png");
        Image _8 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\8.png");
        Image _9 = Toolkit.getDefaultToolkit().getImage(resUrl+"\\9.png");
    }
    url url = new url();
    public bossHP () {
    }
    public void drawBossHp(Graphics g){
        logic();
        if (hp%10 == 0) {
            g.drawImage(url._0,60, 10, 50, 50, null);
        } else if (hp%10 == 1) {
            g.drawImage(url._1,60, 10, 50, 50, null);
        } else if (hp%10 == 2) {
            g.drawImage(url._2,60, 10, 50, 50, null);
        } else if (hp%10 == 3) {
            g.drawImage(url._3,60, 10, 50, 50, null);
        } else if (hp%10 == 4) {
            g.drawImage(url._4,60, 10, 50, 50, null);
        } else if (hp%10 == 5) {
            g.drawImage(url._5,60, 10, 50, 50, null);
        } else if (hp%10 == 6) {
            g.drawImage(url._6,60, 10, 50, 50, null);
        } else if (hp%10 == 7) {
            g.drawImage(url._7,60, 10, 50, 50, null);
        } else if (hp%10 == 8) {
            g.drawImage(url._8,60, 10, 50, 50, null);
        } else if (hp%10 == 9) {
            g.drawImage(url._9,60, 10, 50, 50, null);
        }
        int tmphp = hp/10;
        if (tmphp%10 == 0) {
            g.drawImage(url._0,10, 10, 50, 50, null);
        } else if (tmphp%10 == 1) {
            g.drawImage(url._1,10, 10, 50, 50, null);
        } else if (tmphp%10 == 2) {
            g.drawImage(url._2,10, 10, 50, 50, null);
        } else if (tmphp%10 == 3) {
            g.drawImage(url._3,10, 10, 50, 50, null);
        } else if (tmphp%10 == 4) {
            g.drawImage(url._4,10, 10, 50, 50, null);
        } else if (tmphp%10 == 5) {
            g.drawImage(url._5,10, 10, 50, 50, null);
        } else if (tmphp%10 == 6) {
            g.drawImage(url._6,10, 10, 50, 50, null);
        } else if (tmphp%10 == 7) {
            g.drawImage(url._7,10, 10, 50, 50, null);
        } else if (tmphp%10 == 8) {
            g.drawImage(url._8,10, 10, 50, 50, null);
        } else if (tmphp%10 == 9) {
            g.drawImage(url._9,10, 10, 50, 50, null);
        }
    }

    public void logic() {

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
