package main.java.display;

import main.java.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class setPanel extends JPanel {
    Constant CONST = new Constant();
    JButton lastPage = new JButton("主選單");
    Image background = Toolkit.getDefaultToolkit().getImage("D:\\Java\\SSTG\\src\\main\\ressources\\遊玩方式.png");
    public setPanel (ActionListener actionListener){
        repaint();
        this.setLayout(null);
        this.add(lastPage);
        lastPage.setBounds(10,10,70,25);
        lastPage.addActionListener(actionListener);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 40, CONST.SCREEN_WIDTH, CONST.SCREEN_HEIGHT, this);
        super.paintChildren(g);
    }
}
