package main.java.game.enemyScript;
import main.java.Constant;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class snakeBody  {
    private Constant CONST = new Constant();
    //方向
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;
    //20px
    public static final int RADIUS= 20;
    //速度
    public static final int SPEED = 4;
    //蛇移動
    public static final int STAND = 0;
    public static final int MOVE = 1;
    public static final int DIE = 2;
    private int HP = 1040;//CONST.INIT_SNAKE_HP;
    private int atkTimes = 0;
    private int atk = 4;

    class coordinate {
        private Constant CONST = new Constant();
        private int x_s[] = {900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900};
        private int y_s[] = {500,505,510,515,520,525,530,535,540,545,550,555,560,565,570,575,580,585,590,595,600,605,610,615,620};
        int dir[] = new int[25];
        public coordinate () {
            for (int iDir = 0; iDir < 25; iDir++) {
                dir[iDir] = CONST.SIDE_UP;
            }
        }
    }

    coordinate coordinate = new coordinate();


    private Rectangle hitbox_head = new Rectangle(coordinate.x_s[0],coordinate.y_s[0],40,40);
    private Rectangle hitbox_body_1 = new Rectangle(coordinate.x_s[8],coordinate.y_s[8],40,40);
    private Rectangle hitbox_body_2 = new Rectangle(coordinate.x_s[16],coordinate.y_s[16],40,40);
    private Rectangle hitbox_tail = new Rectangle(coordinate.x_s[24],coordinate.y_s[24],40,40);
    private int x,y;
    public int headDir; //方向
    private int state = STAND; //狀態


    class url {
        String resUrl = "E:\\NTUE\\2nd\\Java\\SSTG\\src\\main\\ressources";
        Image snake_head_up = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_up.png");
        Image snake_head_down = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_down.png");
        Image snake_head_right = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_right.png");
        Image snake_head_left = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_left.png");
        Image snake_body_up = Toolkit.getDefaultToolkit().getImage(resUrl+"\\body_up.png");
        Image snake_body_down = Toolkit.getDefaultToolkit().getImage(resUrl+"\\body_down.png");
        Image snake_body_right = Toolkit.getDefaultToolkit().getImage(resUrl+"\\body_right.png");
        Image snake_body_left = Toolkit.getDefaultToolkit().getImage(resUrl+"\\body_left.png");
        Image snake_body_es = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_es.png");
        Image snake_body_ws = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_ws.png");
        Image snake_body_en = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_en.png");
        Image snake_body_wn = Toolkit.getDefaultToolkit().getImage(resUrl+"\\head_wn.png");
        Image snake_tail_up = Toolkit.getDefaultToolkit().getImage(resUrl+"\\tail_up.png");
        Image snake_tail_down = Toolkit.getDefaultToolkit().getImage(resUrl+"\\tail_down.png");
        Image snake_tail_right = Toolkit.getDefaultToolkit().getImage(resUrl+"\\tail_right.png");
        Image snake_tail_left = Toolkit.getDefaultToolkit().getImage(resUrl+"\\tail_left.png");
    }

    url url = new url();


    //攻擊子彈
//    private List<> bullets =new ArrayList();



    public snakeBody(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.headDir=dir;
    }




    //蛇頭繪製
    public synchronized void drawSnakebody(Graphics g ){
        //繪製snackhead
        switch (coordinate.dir[0]) {
            case 0 -> g.drawImage(url.snake_head_up, coordinate.x_s[0], coordinate.y_s[0], 40, 40, null);
            case 1 -> g.drawImage(url.snake_head_down, coordinate.x_s[0], coordinate.y_s[0], 40, 40, null);
            case 2 -> g.drawImage(url.snake_head_right, coordinate.x_s[0], coordinate.y_s[0], 40, 40, null);
            case 3 -> g.drawImage(url.snake_head_left, coordinate.x_s[0], coordinate.y_s[0], 40, 40, null);
        }
        switch (coordinate.dir[8]) {
            case 0 -> g.drawImage(url.snake_body_up, coordinate.x_s[8], coordinate.y_s[8], 40, 40, null);
            case 1 -> g.drawImage(url.snake_body_down, coordinate.x_s[8], coordinate.y_s[8], 40, 40, null);
            case 2 -> g.drawImage(url.snake_body_right, coordinate.x_s[8], coordinate.y_s[8], 40, 40, null);
            case 3 -> g.drawImage(url.snake_body_left, coordinate.x_s[8], coordinate.y_s[8], 40, 40, null);
        }
        switch (coordinate.dir[16]) {
            case 0 -> g.drawImage(url.snake_body_up, coordinate.x_s[16], coordinate.y_s[16], 40, 40, null);
            case 1 -> g.drawImage(url.snake_body_down, coordinate.x_s[16], coordinate.y_s[16], 40, 40, null);
            case 2 -> g.drawImage(url.snake_body_right, coordinate.x_s[16], coordinate.y_s[16], 40, 40, null);
            case 3 -> g.drawImage(url.snake_body_left, coordinate.x_s[16], coordinate.y_s[16], 40, 40, null);
        }
        switch (coordinate.dir[24]) {
            case 0 -> g.drawImage(url.snake_tail_up, coordinate.x_s[24], coordinate.y_s[24], 40, 40, null);
            case 1 -> g.drawImage(url.snake_tail_down, coordinate.x_s[24], coordinate.y_s[24], 40, 40, null);
            case 2 -> g.drawImage(url.snake_tail_right, coordinate.x_s[24], coordinate.y_s[24], 40, 40, null);
            case 3 -> g.drawImage(url.snake_tail_left, coordinate.x_s[24], coordinate.y_s[24], 40, 40, null);
        }
        logic();
    }
    private void logic () {
        move();
        this.boundary(coordinate.x_s[0],coordinate.y_s[0]);
        rectangleMove();
    }

    private void move () {
        switch (headDir){
            case UP:
                for (int i = 24; i > 0; i--) {
                    coordinate.x_s[i] = coordinate.x_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.y_s[i] = coordinate.y_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.dir[i] = coordinate.dir[i-1];
                }
                coordinate.x_s[0] = coordinate.x_s[1];
                coordinate.y_s[0] = coordinate.y_s[1] - 5;

                break;
            case DOWN:
                for (int i = 24; i > 0; i--) {
                    coordinate.x_s[i] = coordinate.x_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.y_s[i] = coordinate.y_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.dir[i] = coordinate.dir[i-1];
                }
                coordinate.x_s[0] = coordinate.x_s[1];
                coordinate.y_s[0] = coordinate.y_s[1] +5;
                break;
            case LEFT:
                for (int i = 24; i > 0; i--) {
                    coordinate.x_s[i] = coordinate.x_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.y_s[i] = coordinate.y_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.dir[i] = coordinate.dir[i-1];
                }
                coordinate.x_s[0] = coordinate.x_s[1] - 5;
                coordinate.y_s[0] = coordinate.y_s[1];
                break;
            case RIGHT:
                for (int i = 24; i > 0; i--) {
                    coordinate.x_s[i] = coordinate.x_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.y_s[i] = coordinate.y_s[i-1];
                }
                for (int i = 24; i > 0; i--) {
                    coordinate.dir[i] = coordinate.dir[i-1];
                }
                coordinate.x_s[0] = coordinate.x_s[1] + 5;
                coordinate.y_s[0] = coordinate.y_s[1];
                break;
        }
    }
    private void rectangleMove () {
        this.hitbox_head.setLocation(coordinate.x_s[0],coordinate.y_s[0]);
        this.hitbox_body_1.setLocation(coordinate.x_s[8],coordinate.y_s[8]);
        this.hitbox_body_2.setLocation(coordinate.x_s[16],coordinate.y_s[16]);
        this.hitbox_tail.setLocation(coordinate.x_s[24],coordinate.y_s[24]);
    }
    private void boundary(int x,int y){
        if(x+39>CONST.SCREEN_WIDTH){
            coordinate.x_s[0]-=5;
            if((y)>(CONST.SCREEN_HEIGHT-y)){
                headDir=UP;
                coordinate.dir[0] = CONST.SIDE_UP;
                coordinate.y_s[0]-=5;
            }else if((y)<=(CONST.SCREEN_HEIGHT-y)){
                headDir=DOWN;
                coordinate.dir[0] = CONST.SIDE_DOWN;
                coordinate.y_s[0]+=5;
            }
        } else if (x-5<0) {
            coordinate.x_s[0]+=5;
            if((y)>(CONST.SCREEN_HEIGHT-y)){
                headDir=UP;
                coordinate.dir[0] = CONST.SIDE_UP;
                coordinate.y_s[0]-=5;
            }else if ((y)<=(CONST.SCREEN_HEIGHT-y)) {
                headDir=DOWN;
                coordinate.dir[0] = CONST.SIDE_DOWN;
                coordinate.y_s[0]+=5;
            }
        } else if (y+39>CONST.SCREEN_HEIGHT) {
            coordinate.y_s[0]-=5;
            if((x)>(CONST.SCREEN_WIDTH-x)){
                headDir=LEFT;
                coordinate.dir[0] = CONST.SIDE_LEFT;
                coordinate.x_s[0]-=5;
            }else if ((x)<=(CONST.SCREEN_WIDTH-x)){
                headDir=RIGHT;
                coordinate.dir[0] = CONST.SIDE_RIGHT;
                coordinate.x_s[0]+=5;
            }
        } else if (y-5<0){
            coordinate.y_s[0]+=5;
            if((x)>(CONST.SCREEN_WIDTH-x)){
                headDir=LEFT;
                coordinate.dir[0] = CONST.SIDE_LEFT;
                coordinate.x_s[0]-=5;
            }else if ((x)<=(CONST.SCREEN_WIDTH-x)){
                headDir=RIGHT;
                coordinate.dir[0] = CONST.SIDE_RIGHT;
                coordinate.x_s[0]+=5;
            }
        }
    }
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setX_s(int[] x_s) {
        this.coordinate.x_s = x_s;
    }

    public void setY_s(int[] y_s) {
        this.coordinate.y_s = y_s;
    }

    public void setHitbox_head(Rectangle hitbox_head) {
        this.hitbox_head = hitbox_head;
    }

    public void setHitbox_body_1(Rectangle hitbox_body_1) {
        this.hitbox_body_1 = hitbox_body_1;
    }

    public void setHitbox_body_2(Rectangle hitbox_body_2) {
        this.hitbox_body_2 = hitbox_body_2;
    }

    public void setHitbox_tail(Rectangle hitbox_tail) {
        this.hitbox_tail = hitbox_tail;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHP() {
        return HP;
    }

    public int getX_s() {
        return coordinate.x_s[0];
    }

    public int getY_s() {
        return coordinate.y_s[0];
    }

    public Rectangle getHitbox_head() {
        return hitbox_head;
    }

    public Rectangle getHitbox_body_1() {
        return hitbox_body_1;
    }

    public Rectangle getHitbox_body_2() {
        return hitbox_body_2;
    }

    public Rectangle getHitbox_tail() {
        return hitbox_tail;
    }

    public int getAtk() {
        return atk;
    }

    public int getAtkTimes() {
        return atkTimes;
    }

    public void setAtkTimes(int atkTimes) {
        this.atkTimes = atkTimes;
    }
}
