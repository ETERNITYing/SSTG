package main.java.display;

import main.java.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class levelPanel extends JPanel {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    JButton lastPage = new JButton("主選單");
    JPanel pageFlowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel levelFlowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,screen.width/16,screen.width/16));
    JButton level_1 = new JButton("第一關");
    JButton level_2 = new JButton("敬請期待");
    JButton level_3 = new JButton("第三關");
    JButton level_4 = new JButton("第四關");
    JButton level_5 = new JButton("第五關");
    Constant CONST = new Constant();
    Image background = Toolkit.getDefaultToolkit().getImage("E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources\\Acer_Wallpaper_03_5000x2814.jpg");
    public levelPanel (ActionListener actionListener) {
        super(true);
        repaint();
        this.setDoubleBuffered(true);
        levelPanelInitialization();
        lastPage.addActionListener(actionListener);
        level_1.addActionListener(actionListener);
        level_2.addActionListener(actionListener);
        level_3.addActionListener(actionListener);
        level_4.addActionListener(actionListener);
        level_5.addActionListener(actionListener);
    }
    private void levelPanelInitialization() {

//        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(pageFlowPanel,BorderLayout.NORTH);
        this.add(levelFlowPanel,BorderLayout.CENTER);

        pageFlowPanel.add(lastPage);
        Dimension levelButtonSize = new Dimension(screen.width*2/16,screen.width*2/16);
        level_1.setPreferredSize(levelButtonSize);
        level_2.setPreferredSize(levelButtonSize);
        level_3.setPreferredSize(levelButtonSize);
        level_4.setPreferredSize(levelButtonSize);
        level_5.setPreferredSize(levelButtonSize);

        levelFlowPanel.add(level_1);
        levelFlowPanel.add(level_2);
//        levelFlowPanel.add(level_3);
//        levelFlowPanel.add(level_4);
//        levelFlowPanel.add(level_5);

        lastPage.setFont(new fontConfig().getVERSION_FONT());
        level_1.setFont(new fontConfig().getTITAL_FONT());
        level_2.setFont(new fontConfig().getTITAL_FONT());
        level_3.setFont(new fontConfig().getTITAL_FONT());
        level_4.setFont(new fontConfig().getTITAL_FONT());
        level_5.setFont(new fontConfig().getTITAL_FONT());
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, CONST.SCREEN_WIDTH, CONST.SCREEN_HEIGHT, this);
//        super.paintChildren(g);
    }
}
