package cn.szz.shoot.entity;

import cn.szz.shoot.utils.CommUtils;

/**
 * 生命奖励
 *
 * @author Shi Zezhu
 * @date 2018年1月9日 下午7:35:24
 *
 */
public class BulletAward extends FlyObject {

	private static final long serialVersionUID = 5641796837493318718L;
	
	protected int value;
	
	@Override
	public void action() {
		this.y += this.yspeed;
		this.x += this.xspeed;
		if(this.x <= 0) {
			this.xspeed = 1;
		}
		if(this.x >= CommUtils.WIDTH - this.width) {
			this.xspeed = -1;
		}
	}

	@Override
	public void blast() {}

	@Override
	public void hit(FlyObject flyObject) {
		if (this.checkHit(flyObject)) {
			this.isDead = true;
		}
	}

	/**
	 * 检测撞击
	 * 
	 * @param enemyObject
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午4:35:11
	 */
	protected boolean checkHit(FlyObject flyObject) {
		int x1 = flyObject.getX() - this.width / 2;
		int x2 = flyObject.getX() + flyObject.getWidth() + this.width / 2;
		int y1 = flyObject.getY() - this.height / 2;
		int y2 = flyObject.getY() + flyObject.getHeight() + this.height / 2;
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		return x > x1 && x < x2 && y > y1 && y < y2;
	}
	
	@Override
	public void outOfBounds() {
		if (this.x <= 0 - this.width || this.x >= CommUtils.WIDTH || this.y >= CommUtils.HEIGHT) {
			this.isDead = true;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
