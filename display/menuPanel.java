package main.java.display;

import main.java.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class menuPanel extends JPanel {
    JButton start   = new JButton("開始遊戲");
    JButton set     = new JButton("遊玩方式");
    JButton leave   = new JButton("離開");
    JLabel version  = new JLabel();
    Constant CONST = new Constant();
    Image background = Toolkit.getDefaultToolkit().getImage("E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources\\Acer_Wallpaper_03_5000x2814.jpg");
    public menuPanel (ActionListener actionListener,String version) {
        super(true);
        menuPanelInitialization();
        this.setDoubleBuffered(true);
        this.version.setText(version);
        start.addActionListener(actionListener);
        set.addActionListener(actionListener);
        leave.addActionListener(actionListener);

    }

    private void menuPanelInitialization() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        GridBagLayout gridBagLayout = new GridBagLayout();

        //panel setting
        this.setLayout(gridBagLayout);
        GridBagConstraints gbc;

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(screen.height*3/24,screen.width*7/12,screen.height/24,screen.width*2/12);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = screen.width*3/24;
        gbc.ipady = screen.height*2/16;
        this.add(start,gbc);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(screen.height/24,screen.width*7/12,screen.height/24,screen.width*2/12);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = screen.width*3/24;
        gbc.ipady = screen.height*2/16;
        this.add(set,gbc);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(screen.height/24,screen.width*7/12,screen.height*2/24,screen.width*2/12);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = screen.width*3/24;
        gbc.ipady = screen.height*2/16;
        this.add(leave,gbc);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0, screen.width,0,screen.width/24);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(version,gbc);

        start.setFont(new fontConfig().getTITAL_FONT());
        set.setFont(new fontConfig().getTITAL_FONT());
        leave.setFont(new fontConfig().getTITAL_FONT());
        version.setFont(new fontConfig().getVERSION_FONT());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, CONST.SCREEN_WIDTH, CONST.SCREEN_HEIGHT, this);
        super.paintChildren(g);
    }
}

