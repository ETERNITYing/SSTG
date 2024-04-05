package main.java.game.enemyScript;

import main.java.Constant;

import java.awt.*;

public class snakeAtkTime {
    Constant CONST = new Constant();
    private int atkTimes = 0;
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
    public snakeAtkTime () {
    }
    public void drawSnakeAtkTimes (Graphics g){
        logic();
        if (atkTimes%10 == 0) {
            g.drawImage(url._0,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 1) {
            g.drawImage(url._1,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 2) {
            g.drawImage(url._2,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 3) {
            g.drawImage(url._3,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 4) {
            g.drawImage(url._4,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 5) {
            g.drawImage(url._5,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 6) {
            g.drawImage(url._6,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 7) {
            g.drawImage(url._7,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 8) {
            g.drawImage(url._8,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        } else if (atkTimes%10 == 9) {
            g.drawImage(url._9,CONST.SCREEN_WIDTH-60, 60, 50, 50, null);
        }
    }

    public void logic() {

    }

    public void setAtkTimes(int atkTimes) {
        this.atkTimes = atkTimes;
    }
}
