package main.java.game.enemyScript;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import main.java.Constant;
import main.java.display.mainFrame;

public class level_1 extends JPanel implements Runnable{
    Constant CONST = new Constant();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private int timer = 0;
    JLabel snakeHP = new JLabel();
    JLabel snakeAttackTimes = new JLabel();
    JLabel bossHP = new JLabel();
    private List<CompleteScreen> completeScreens = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();
    private List<Sector> sectors = new ArrayList<>();
    private List<fruitHP> fruitHPS = new ArrayList<>();
    private List<fruitAttack> fruitAttacks = new ArrayList<>();

    private snakeBody snakeBody = new snakeBody(900,500,0);
    private  boss boss = new boss();
    private bossHP drawBossHP = new bossHP();
    private snakeHP drawSnakeHP = new snakeHP();
    private snakeAtkTime drawSnakeAtkTimes = new snakeAtkTime();
    private int timerState = 0;
    private int timerInsideState = 0;
    mainFrame mF;
    JPanel panel;
    public level_1 (mainFrame mF, JPanel panel) {
        this.addKeyListener(new move());
        this.addMouseListener(new attack());
        this.setFocusable(true);
        this.requestFocus();
        this.setLayout(null);
        this.initLevel_1();
        this.mF = mF;
        this.panel = panel;
        new Thread(this).start();
    }

    private void initLevel_1 () {
        this.add(snakeHP);
        this.add(snakeAttackTimes);
        this.add(bossHP);
        snakeHP.setBounds(CONST.SCREEN_WIDTH-100,0,100,40);
        snakeAttackTimes.setBounds(CONST.SCREEN_WIDTH-100,40,100,40);
        bossHP.setBounds(CONST.SCREEN_WIDTH-200,40,100,40);
    }

    private void script() {
        if ((timer/59)%15 == 8) {
            createFruitHP();
        }
        if (((timer/59) + 4)%15 == 8) {
            createFruitAttack();
        }
        if (timer > 177 && timer/59 <= 4 ) {
            createCircle((int)boss.getX_c(),(int)boss.getY_c());
            createCompleteScreen(CONST.SIDE_UP);

        } else if (timer/59 >=4 && timer/59 <= 10) {
            createSector();
        } else if ((timer/59 >=13 && timer/59 <= 14) || (timer/59 >=16 && timer/59 <= 17)) {
            createCompleteScreen((int)(Math.random()*4));
        } else if (timer/59 >= 17 && timer/59 <= 20) {
            createCircle(0,0);
            createCircle(0,CONST.SCREEN_HEIGHT);
            createCircle(CONST.SCREEN_WIDTH,0);
            createCircle(CONST.SCREEN_WIDTH,CONST.SCREEN_HEIGHT);
            createSector();
        } else if (timer/59  >= 20) {
            if (timerState == 0 || (timer/59)%10 == 0) {
                timerState = (int)(Math.random()*4)+1;
                timerInsideState = 0;
            } else if (timerState == 1) {
                if(timerInsideState/3 >= 3 && timerInsideState/3 <= 5) {
                    createCompleteScreen(CONST.SIDE_LEFT);
//                    createSector();
                } else if (timerInsideState/3 >= 7 && timerInsideState/3 <= 9) {
                    createCompleteScreen(CONST.SIDE_LEFT);
                    createCompleteScreen(CONST.SIDE_RIGHT);
                }
                timerInsideState++;
            } else if (timerState == 2) {
                if (timerInsideState/3 >= 1 && timerInsideState/3 <= 3) {
                    createCircle(0,0);
                    createCircle(0,CONST.SCREEN_HEIGHT);
                    createCircle(CONST.SCREEN_WIDTH,0);
                    createCircle(CONST.SCREEN_WIDTH,CONST.SCREEN_HEIGHT);
                    createSector();
                } else if (timerInsideState/3 >= 7 && timerInsideState/3 <= 8) {
                    createCircle((int)boss.getX_c(),(int)boss.getY_c());
                    createSector();
                }
                timerInsideState++;
            } else if (timerState == 3) {
                if(timerInsideState == 9 || timerInsideState == 12 || timerInsideState == 15) {
                    createSector(0,0);
                    createSector(0,CONST.SCREEN_HEIGHT);
                    createSector(CONST.SCREEN_WIDTH,0);
                    createSector(CONST.SCREEN_WIDTH,CONST.SCREEN_HEIGHT);
                    createSector();
                } else if (timerInsideState/3 >= 7 && timerInsideState/3 <= 9) {
                    createCompleteScreen(CONST.SIDE_UP);
                    createCompleteScreen(CONST.SIDE_DOWN);
                }
                timerInsideState++;
            } else if (timerState == 4) {
                if (timerInsideState/3 >= 1 && timerInsideState/3 <= 3) {
                    createCompleteScreen((int)(Math.random()*4));
                } else if (timerInsideState/3 >= 7 && timerInsideState/3 <= 8) {
                    createSector(0,0);
                    createSector(0,CONST.SCREEN_HEIGHT);
                    createSector();
                }
                timerInsideState++;
            }
        }
    }

    private void checkHitbox(){
        fruitHPHitbox();
        fruitAttacksHitbox();
        enemyAttackHitbox();
        snakeHP.setText(""+snakeBody.getHP());
        snakeAttackTimes.setText((""+ snakeBody.getAtkTimes()));
        bossHP.setText(""+boss.getHp());
        drawBossHP.setHp(boss.getHp());
        drawSnakeHP.setHp(snakeBody.getHP());
        drawSnakeAtkTimes.setAtkTimes(snakeBody.getAtkTimes());
    }
    private void fruitHPHitbox(){
        for (int j = 0; j < fruitHPS.size(); j++) {
            try {
                boolean tmpS = snakeBody.getHitbox_head().intersects(fruitHPS.get(j).getHitbox_head());
                if (tmpS) {
                    snakeBody.setHP(snakeBody.getHP() + fruitHPS.get(j).getHp_fruit());
                    fruitHPS.remove(j);
                    drawSnakeHP.setHp(snakeBody.getHP());
                }
//                boolean tmpB = boss.getBody().intersects(fruitHPS.get(j).getHitbox_head());
//                if (tmpB) {
//                    fruitHPS.remove(j);
//                    createFruitHP();
//                }
            } catch (Exception e) {

            }
        }

    }
    private void fruitAttacksHitbox(){
        for (int j = 0; j < fruitAttacks.size(); j++) {
            try {
                boolean tmp = snakeBody.getHitbox_head().intersects(fruitAttacks.get(j).getHitbox_head());
                if (tmp) {
                    snakeBody.setAtkTimes(snakeBody.getAtkTimes() + 1);
                    fruitAttacks.remove(j);
                    drawSnakeAtkTimes.setAtkTimes(snakeBody.getAtkTimes());
                }
//                boolean tmpB = boss.getBody().intersects(fruitAttacks.get(j).getHitbox_head());
//                if (tmpB) {
//                    fruitAttacks.remove(j);
//                    createFruitAttack();
//                }
            } catch (Exception e) {

            }
        }
    }

    private void enemyAttackHitbox () {
        for (int j = 0; j < completeScreens.size(); j++) {
            boolean tmp1 = snakeBody.getHitbox_head().intersects(completeScreens.get(j).getHitbox());
            boolean tmp2 = snakeBody.getHitbox_body_1().intersects(completeScreens.get(j).getHitbox());
            boolean tmp3 = snakeBody.getHitbox_body_2().intersects(completeScreens.get(j).getHitbox());
            boolean tmp4 = snakeBody.getHitbox_tail().intersects(completeScreens.get(j).getHitbox());
            if (tmp1||tmp2||tmp3||tmp4) {
                snakeBody.setHP(snakeBody.getHP()-completeScreens.get(j).getAtk());
                completeScreens.remove(j);
            }
        }
        for (int j = 0; j < circles.size(); j++) {
            for (int i = 1; i < 7; i++) {
                try {
                    boolean tmp1 = snakeBody.getHitbox_head().intersects(circles.get(j).getHitbox(i));
                    boolean tmp2 = snakeBody.getHitbox_body_1().intersects(circles.get(j).getHitbox(i));
                    boolean tmp3 = snakeBody.getHitbox_body_2().intersects(circles.get(j).getHitbox(i));
                    boolean tmp4 = snakeBody.getHitbox_tail().intersects(circles.get(j).getHitbox(i));
                    if (tmp1||tmp2||tmp3||tmp4) {
                        snakeBody.setHP(snakeBody.getHP()-circles.get(j).getAtk());
                        circles.get(j).setCheck(i);
                    }
                } catch (Exception e) {}
            }
        }
        for (int j = 0; j < sectors.size(); j++) {
            for (int i = 1; i < 4; i++) {
                try {
                    boolean tmp1 = snakeBody.getHitbox_head().intersects(sectors.get(j).getHitbox(i));
                    boolean tmp2 = snakeBody.getHitbox_body_1().intersects(sectors.get(j).getHitbox(i));
                    boolean tmp3 = snakeBody.getHitbox_body_2().intersects(sectors.get(j).getHitbox(i));
                    boolean tmp4 = snakeBody.getHitbox_tail().intersects(sectors.get(j).getHitbox(i));
                    if (tmp1 || tmp2 || tmp3 || tmp4) {
                        snakeBody.setHP(snakeBody.getHP() - sectors.get(j).getAtk());
                        sectors.get(j).setCheck(i);
                    }
                } catch (Exception e) {}
            }
        }
    }

    class move extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
                snakeBody.headDir = CONST.SIDE_UP;
                snakeBody.coordinate.dir[0] = CONST.SIDE_UP;
            }else if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S){
                snakeBody.headDir = CONST.SIDE_DOWN;
                snakeBody.coordinate.dir[0] = CONST.SIDE_DOWN;
            }else if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D){
                snakeBody.headDir = CONST.SIDE_RIGHT;
                snakeBody.coordinate.dir[0] = CONST.SIDE_RIGHT;
            }else if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A){
                snakeBody.headDir = CONST.SIDE_LEFT;
                snakeBody.coordinate.dir[0] = CONST.SIDE_LEFT;
            }
        }
    }

    class attack extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) { //按左鍵
                if (snakeBody.getAtkTimes() > 0 && snakeBody.getHitbox_head().intersects(boss.getHitedBox())) {
                    snakeBody.setAtkTimes(snakeBody.getAtkTimes()-1);
                    boss.setHp(boss.getHp()-snakeBody.getAtk());
                    drawBossHP.setHp(boss.getHp());
                }
                requestFocus();
            } else if (e.getButton() == MouseEvent.BUTTON3) { //按右鍵

            } else if (e.getButton() == 2) {

            }
        }
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage offScreenImage = new BufferedImage(CONST.SCREEN_WIDTH, CONST.SCREEN_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics gOff = offScreenImage.getGraphics();
        this.draw(gOff);
        super.paint(g);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources\\background_1.png");
        img.paintIcon(this, g, 0, 0);
    }
    public synchronized void draw (Graphics g) {
        boss.drawBoss(g);
        drawBossHP.drawBossHp(g);
        drawSnakeHP.drawSnakeHp(g);
        drawSnakeAtkTimes.drawSnakeAtkTimes(g);
        snakeBody.drawSnakebody(g);
//        for (CompleteScreen completeScreen: b) {
//            completeScreen.drawCompleteScreen(g);
//            if (completeScreen.x > 1940||completeScreen.x<-20||completeScreen.y>1100||completeScreen.y<-20) {
//                b.remove(completeScreen);
//            }
//        }
        for (int i = 0; i < completeScreens.size(); i++) {
            completeScreens.get(i).drawCompleteScreen(g);
            if (completeScreens.get(i).x > 1940||completeScreens.get(i).x<-20||completeScreens.get(i).y>1100||completeScreens.get(i).y<-20) {
                completeScreens.remove(completeScreens.get(i));
            }
        }
        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).drawCircle(g);
            if (circles.get(i).x > 1940||circles.get(i).x<-20||circles.get(i).y>1100||circles.get(i).y<-20) {
                circles.remove(circles.get(i));
            }
        }
        for (int i = 0; i < sectors.size(); i++) {
            System.out.println("draw");
            sectors.get(i).drawSector(g);
            if (sectors.get(i).x_1 > 1940||sectors.get(i).x_1<-20||sectors.get(i).y_1>1100||sectors.get(i).x_1<-20) {
                System.out.println(sectors.get(i).x_1);
                System.out.println(sectors.get(i).y_1);
                sectors.remove(sectors.get(i));
            }
        }
        for (int i = 0; i < fruitHPS.size(); i++) {
            fruitHPS.get(i).drawfuncfruit(g);
        }
        for (int i = 0; i < fruitAttacks.size(); i++) {
            fruitAttacks.get(i).drawfuncfruit(g);
        }





    }
    public void createCompleteScreen(int side) {
        for (int i = 0; i < 2; i++) {
            CompleteScreen a = new CompleteScreen(side);
            completeScreens.add(a);
        }
    }

    public void createCircle(int x, int y) {
        Circle a = new Circle(x,y);
        circles.add(a);
    }

    public void createSector() {
        Sector a = new Sector((int)boss.getX_c(), (int)boss.getY_c(), snakeBody.getX_s(), snakeBody.getY_s());
        sectors.add(a);
    }
    public void createSector(int x, int y) {
        Sector a = new Sector(x, y, snakeBody.getX_s(), snakeBody.getY_s());
        sectors.add(a);
    }

    public void createFruitHP() {
        fruitHP fruit = new fruitHP();
        fruitHPS.add(fruit);
    }

    public void createFruitAttack() {
        fruitAttack fruit = new fruitAttack();
        fruitAttacks.add(fruit);
    }

    @Override
    public void run() {
        while (boss.getHp()>0 && snakeBody.getHP() > 0) {
            System.out.println("run");
            timer ++;
            if(timer % 59 == 0 || timer % 59 == 20 || timer % 59 == 40) {
                script();
            }
            repaint();
            checkHitbox();
            this.requestFocus();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (boss.getHp()>0) {
            JButton end = new JButton("失敗");
            end.setFont(CONST.ENDGAME_FONT);
            this.add(end);
            end.setBounds(CONST.SCREEN_WIDTH/3,CONST.SCREEN_HEIGHT/3,CONST.SCREEN_WIDTH/3,CONST.SCREEN_HEIGHT/3);
            end.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mF.switchContentPanel(panel);
                }
            });
        } else if (snakeBody.getHP() > 0) {
            JButton end = new JButton("成功");
            end.setFont(CONST.ENDGAME_FONT);
            this.add(end);
            end.setBounds(CONST.SCREEN_WIDTH/3,CONST.SCREEN_HEIGHT/3,CONST.SCREEN_WIDTH/3,CONST.SCREEN_HEIGHT/3);
            end.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mF.switchContentPanel(panel);
                }
            });
        }

    }
}