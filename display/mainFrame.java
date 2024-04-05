package main.java.display;

import javax.swing.*;
import java.awt.*;

import main.java.Constant;
import main.java.Main;
import main.java.game.enemyScript.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

public class mainFrame extends JFrame implements ActionListener  {

    Constant CONST = new Constant();
    menuPanel menu = new menuPanel(this,"ver 0.0.1");
    setPanel set = new setPanel(this);
    levelPanel level = new levelPanel(this);
    level_1 l1;

    public mainFrame () {
        this.mainFrameInitialization();
    }

    void mainFrameInitialization(){
        this.setUndecorated(true);
        this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
//        this.setBounds(100,100,1300,1300);
        this.setVisible(true);
        this.switchContentPanel(menu);
        menu.repaint();
    }
//    class menuListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == menu.start) {
//                switchContentPanel(level);
//                level.repaint();
//            } else if (e.getSource() == menu.set) {
//                switchContentPanel(set);
//            } else if (e.getSource() == menu.leave) {
//                System.exit(0);
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.start) {
            switchContentPanel(level);
            level.repaint();
        } else if (e.getSource() == menu.set) {
            switchContentPanel(set);
        } else if (e.getSource() == menu.leave) {
            System.exit(0);
        } else if (e.getSource() == level.lastPage) {
            switchContentPanel(menu);
            menu.repaint();
        } else if (e.getSource() == level.level_1) {
            l1 = new level_1(this, this.level);
            switchContentPanel(l1);
        } else if (e.getSource() == level.level_2) {
            level.repaint();
        } else if (e.getSource() == level.level_3) {

        } else if (e.getSource() == level.level_4) {

        } else if (e.getSource() == level.level_5) {

        } else if (e.getSource() == set.lastPage) {
            switchContentPanel(menu);
            menu.repaint();
        }
    }

    public void switchContentPanel(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
        try {
            l1 = null;
        } catch (Exception e) {

        }
    }
}