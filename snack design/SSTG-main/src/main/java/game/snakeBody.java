package main.java.game;
import java.util.*;
import java.awt.*;
public class snakeBody {
    //方向
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    //20px
    public static final int RADIUS= 20;
    //速度
    public static final int SPEED = 4;
    //蛇移動
    public static final int STAND = 0;
    public static final int MOVE = 1;
    public static final int DIE = 2;
    public static final int HP = 100;


    private int x,y;
    private int hp = HP;
    private int atk;
    private int dir; //方向
    private int state = STAND; //狀態

    //攻擊子彈
//    private List<> bullets =new ArrayList();

    public snakeBody(int x, int y, int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }




    //坦克繪製
    public void draw(Graphics g ){

        //繪製snackhead
        g.fillOval(x-RADIUS,y-RADIUS,RADIUS<<1,RADIUS<<1);
        switch (dir){
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;


        }
    }

}
