package main.java.game.enemyScript;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class barrage {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Graphics g;
    JFrame JF;
    public barrage(JFrame JF,Graphics g){
        this.JF = JF;
        this.g = g;
    }

    void sector(int x, int y, int side,double speed, double degree) {
        JButton sector_1 = new JButton();
        JButton sector_2 = new JButton();
        JButton sector_3 = new JButton();
        JButton sector_4 = new JButton();
        JButton sector_5 = new JButton();

        sector_1.setBounds(x, y, screen.width/80,screen.width/80);
        sector_2.setBounds(x, y, screen.width/80,screen.width/80);
        sector_3.setBounds(x, y, screen.width/80,screen.width/80);
        sector_4.setBounds(x, y, screen.width/80,screen.width/80);
        sector_5.setBounds(x, y, screen.width/80,screen.width/80);


    }

    void CompleteScreen(int side, double speed,Graphics g) {
        int x = 0, y = 0, w = 0;
        switch (side) {
            case 1:
                x = 0;
                y = (int)Math.random()*screen.height+1;
                w = 0;
            case 2:
                x = (int)Math.random()*screen.width+1;
                y = 0;
                w = 1;
            case 3:
                x = screen.width;
                y = (int)Math.random()*screen.width+1;
                w = 0;
            case 4:
                x = (int)Math.random()*screen.width+1;
                y = screen.height;
                w = 1;
        }
        g.drawRect(x,y,x+5*(1-w),y+5*w);
    }

    void circle(int x, int y, int side, double speed) {

    }

    void square(int x, int y, double density, double speed) {

    }

    void vortex(int x, int y, double density, double speed) {

    }


}
