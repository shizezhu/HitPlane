package cn.szz.shoot.entity;

import java.awt.image.BufferedImage;

/**
 * 敌机
 *
 * @author Shi Zezhu
 * @date 2018年1月15日 上午10:57:27
 *
 */
public abstract class EnemyObject extends FlyObject {

	private static final long serialVersionUID = -5722621188235309207L;
	
	protected int scoreAwardValue; //奖励分数数值
	
	protected boolean isBlast; //是否爆炸
	
	protected int currentRunImgIndex;//当前运行图片下标
	
	protected BufferedImage[] runImgs;//运行图片
	
	protected int currentBlastImgIndex;//当前爆炸图片下标
	
	protected BufferedImage[] blastImgs;//爆炸图片
	
	@Override
	public abstract void action();
	
	/**
	 * 爆炸
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 上午11:46:05
	 */
	@Override
	public void blast() {
		if (this.life <= 0) {
			this.isBlast = true;
		}
	}

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
		if (flyObject instanceof Hero) {
			Hero hero = (Hero) flyObject;
			if (hero.isBlast) {
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
	public abstract void outOfBounds();

	public int getScoreAwardValue() {
		return scoreAwardValue;
	}

	public void setScoreAwardValue(int scoreAwardValue) {
		this.scoreAwardValue = scoreAwardValue;
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
}
