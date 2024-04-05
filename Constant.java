package main.java;

import java.awt.*;

public class Constant {
    //字體
    public final Font TITAL_FONT = new Font("BIZ UDMincho",Font.BOLD,30);
    public final Font VERSION_FONT = new Font("Cambira Math",Font.ITALIC,12);
    public final Font ENDGAME_FONT = new Font("BIZ UDMincho",Font.BOLD,72);

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public int SCREEN_HEIGHT;
    public int SCREEN_WIDTH;

    public final int STATE_MENU = 0;
    public final int STATE_LEVEL = 1;
    public final int STATE_SET = 2;

    public final int STATE_LEVEL_1 = 1;
    public final int STATE_LEVEL_2 = 2;
    public final int STATE_LEVEL_3 = 3;
    public final int STATE_LEVEL_4 = 4;
    public final int STATE_LEVEL_5 = 5;

    public final int SIDE_UP = 0;
    public final int SIDE_DOWN = 1;
    public final int SIDE_RIGHT = 2;
    public final int SIDE_LEFT = 3;

    public final int INIT_SNAKE_HP = 10;
    public Constant() {
        SCREEN_HEIGHT = screen.height;
        SCREEN_WIDTH = screen.width;
    }
}