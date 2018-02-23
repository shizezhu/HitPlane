package cn.szz.shoot.entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.szz.shoot.factory.HeroBulletFactory;

/**
 * 英雄
 *
 * @author Shi Zezhu
 * @date 2018年1月9日 下午5:34:20
 *
 */
public class Hero extends FlyObject {

	private static final long serialVersionUID = 8661204392140483905L;
	
	protected int bulletLevel;//子弹等级
	
	protected boolean isBlast; //是否爆炸
	
	protected int currentRunImgIndex;//当前运行图片下标
	
	protected BufferedImage[] runImgs;//运行图片
	
	protected int currentBlastImgIndex;//当前爆炸图片下标
	
	protected BufferedImage[] blastImgs;//爆炸图片	
	
	protected boolean moveFlag; //移动开关
	
	@Override
	public void action() {
		if (isBlast) {
			moveFlag = false;
			this.img = this.blastImgs[currentBlastImgIndex ++];
			if (this.currentBlastImgIndex >= this.blastImgs.length) {
				this.isDead = true;
			}
		} else {
			this.img = this.runImgs[this.currentRunImgIndex ++ / 10 % this.runImgs.length];
		}
	}
	
	@Override
	public void blast() {
		if (this.life <= 0) {
			this.isBlast = true;
		}
	}
	
	/**
	 * 撞击
	 * 
	 * @param enemyObject
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午4:35:11
	 */
	@Override
	public void hit(FlyObject flyObject) {
		if (this.checkHit(flyObject)) {
			this.life -= flyObject.getDamageValue();
		}
	}
	
	/**
	 * 检测是否撞击
	 * 
	 * @param flyObject
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:19:13
	 */
	protected boolean checkHit(FlyObject flyObject) {
		if (this.isBlast) {
			return false;
		}
		if (flyObject instanceof EnemyObject) {
			EnemyObject enemyObject = (EnemyObject) flyObject;
			if (enemyObject.isBlast) {
				return false;
			}
		}
		int x1 = flyObject.getX() - this.width / 2;
		int x2 = flyObject.getX() + flyObject.getWidth() + this.width / 2;
		int y1 = flyObject.getY() - this.height / 2;
		int y2 = flyObject.getY() + flyObject.getHeight() + this.height / 2;
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		return x > x1 && x < x2 && y > y1 && y < y2;
	}
	
	@Override
	public void outOfBounds() {}

	/**
	 * 随着鼠标动
	 * 
	 * @param x
	 * @param y
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午5:48:14
	 */
	public void move(int x,int y) {
		if (moveFlag) {
			this.x = x-this.width / 2;
			this.y = y-this.height / 2;
		}
	}
	
	/**
	 * 发射子弹
	 * 
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月9日 下午4:57:34
	 */
	public List<HeroBullet> shoot() {
		List<HeroBullet> list = new ArrayList<HeroBullet>();
		if (this.bulletLevel > 0) {
			list.add(HeroBulletFactory.createHeroBullet2(this));
			this.bulletLevel --;
		} else {
			list.add(HeroBulletFactory.createHeroBullet1(this));
		}
		return list;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getBulletLevel() {
		return bulletLevel;
	}

	public void setBulletLevel(int bulletLevel) {
		this.bulletLevel = bulletLevel;
	}


	public void setBlast(boolean isBlast) {
		this.isBlast = isBlast;
	}

	public boolean getIsBlast() {
		return isBlast;
	}

	public void setIsBlast(boolean isBlast) {
		this.isBlast = isBlast;
	}

	public int getCurrentRunImgIndex() {
		return currentRunImgIndex;
	}

	public void setCurrentRunImgIndex(int currentRunImgIndex) {
		this.currentRunImgIndex = currentRunImgIndex;
	}

	public BufferedImage[] getRunImgs() {
		return runImgs;
	}

	public void setRunImgs(BufferedImage[] runImgs) {
		this.runImgs = runImgs;
	}

	public int getCurrentBlastImgIndex() {
		return currentBlastImgIndex;
	}

	public void setCurrentBlastImgIndex(int currentBlastImgIndex) {
		this.currentBlastImgIndex = currentBlastImgIndex;
	}

	public BufferedImage[] getBlastImgs() {
		return blastImgs;
	}

	public void setBlastImgs(BufferedImage[] blastImgs) {
		this.blastImgs = blastImgs;
	}

	public boolean isMoveFlag() {
		return moveFlag;
	}

	public void setMoveFlag(boolean moveFlag) {
		this.moveFlag = moveFlag;
	}

	@Override
	public String toString() {
		return "Hero [bulletLevel=" + bulletLevel + ", isBlast=" + isBlast
				+ ", currentRunImgIndex=" + currentRunImgIndex + ", runImgs=" + Arrays.toString(runImgs)
				+ ", currentBlastImgIndex=" + currentBlastImgIndex + ", blastImgs=" + Arrays.toString(blastImgs)
				+ ", moveFlag=" + moveFlag + "]";
	}
}
