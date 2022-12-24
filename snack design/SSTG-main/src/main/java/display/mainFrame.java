package main.java.display;

import javax.swing.*;
import java.awt.*;
import main.java.game.*;
import main.java.game.enemyScript.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

public class mainFrame extends JFrame implements Runnable{

    public mainFrame () {
        this.mainFrameInitialization();
        new Thread(this).start();
    }
    menuPanel menu = new menuPanel(new menuListener(),"ver 0.0.1");
    setPanel set = new setPanel();
    levelPanel level = new levelPanel(new levelListener());

    void mainFrameInitialization(){
       this.setUndecorated(true);
       this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
//        this.setBounds(100,100,1300,1300);
        this.setVisible(true);
        this.switchContentPane(menu);
    }

    class menuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu.start) {
                switchContentPane(level);
            } else if (e.getSource() == menu.set) {
                switchContentPane(set);
            } else if (e.getSource() == menu.leave) {
                System.exit(0);
            }
        }
    }
    class levelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == level.lastPage) {
                switchContentPane(menu);
            } else if (e.getSource() == level.level_1) {
                state = 1;
                level.setVisible(false);
                l1.create(getGraphics());

            } else if (e.getSource() == level.level_2) {

            } else if (e.getSource() == level.level_3) {

            } else if (e.getSource() == level.level_4) {

            } else if (e.getSource() == level.level_5) {

            }
        }
    }
    level_1 l1 = new level_1();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

/*
    @Override
    public void update(Graphics g) {
        super.update(g);
        System.out.println("update");
        //if(state == 1) {
        BufferedImage offScreenImage = new BufferedImage(screen.width,screen.height,BufferedImage.TYPE_4BYTE_ABGR);
            Graphics gOff = offScreenImage.getGraphics();
            l1.draw(gOff);//调用paint()传入缓冲图象
            g.drawImage(offScreenImage, 0, 0, null);

        //}
    }
*/

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("update");
        //if(state == 1) {
        BufferedImage offScreenImage = new BufferedImage(screen.width, screen.height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics gOff = offScreenImage.getGraphics();
        l1.draw(gOff);//调用paint()传入缓冲图象
//    }
        g.drawImage(offScreenImage, 0, 0, null);

    }

    int state = 0;
    public void switchContentPane(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("run");
            repaint();

//            update(getGraphics());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
