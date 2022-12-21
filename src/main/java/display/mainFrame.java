package main.java.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame {
    public mainFrame () {
        this.mainFrameInitialization();
    }
    menuPanel menu = new menuPanel(new menuListener(),"ver 0.0.1");
    setPanel set = new setPanel();
    levelPanel level = new levelPanel(new levelListener());

    void mainFrameInitialization() {
        this.setUndecorated(true);
        this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
        mainFrame.setDefaultLookAndFeelDecorated(true);
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

            } else if (e.getSource() == level.level_2) {

            } else if (e.getSource() == level.level_3) {

            } else if (e.getSource() == level.level_4) {

            } else if (e.getSource() == level.level_5) {

            }
        }
    }
    public void switchContentPane(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
    }
}
