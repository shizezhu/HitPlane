package cn.szz.shoot.entity;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * 飞行物
 *
 * @author Shi Zezhu
 * @date 2017年12月18日 下午6:15:48
 *
 */
public abstract class FlyObject implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int width; //宽度
	
	protected int height; //高度
	
	protected int x; //x坐标
	
	protected int y; //y坐标
	
	protected int xspeed; //x坐标移动速度
	
	protected int yspeed; //y坐标移动速度
	
	protected BufferedImage img; //当前图片
	
	protected boolean isDead; //是否死亡
	
	protected int life; //生命
	
	protected int damageValue; //伤害值

	/**
	 * 走动
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 上午11:54:01
	 */
	public abstract void action();
	
	/**
	 * 爆炸
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:06:23
	 */
	public abstract void blast();
	
	/**
	 * 撞击
	 * 
	 * @param flyObject
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:07:06
	 */
	public abstract void hit(FlyObject flyObject);
	
	/**
	 * 越界
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:07:57
	 */
	public abstract void outOfBounds();
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(int damageValue) {
		this.damageValue = damageValue;
	}
}
