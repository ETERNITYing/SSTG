package main.java.game.enemyScript;

import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * 	所有物体父类
 * @author VULCAN
 *
 */
public abstract class GameObjective {
    protected double x;						//	x坐标
    protected double y;						//	y坐标
    protected double speed;					//	运动速度
    protected double offsetX = 0;			//	x方向偏移量
    protected double offsetY = 0;			//	y方向偏移量
    protected double angle = 90;			//	位移方向
    protected int radius;					//	判定直径
    protected BufferedImage image;			//	贴图
    protected Point center;				//	物体中心

    /**
     * 	所有物体父类，若不选定物体贴图，默认为红色五角星
     */
    public GameObjective() {
        this.image = new BufferedImage(10,10,BufferedImage.TYPE_4BYTE_ABGR);
    }
    /**
     * 	绘图
     * @param g
     */
    public void paint(Graphics g) {
        this.center = new Point((int)this.x, (int)this.y);
        g.drawImage(this.image, this.center.x - this.image.getWidth() / 2,
                this.center.y - this.image.getHeight() / 2, null);
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public Point getCenter() {
        return center;
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public double getOffsetX() {
        return offsetX;
    }
    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }
    public double getOffsetY() {
        return offsetY;
    }
    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
}

