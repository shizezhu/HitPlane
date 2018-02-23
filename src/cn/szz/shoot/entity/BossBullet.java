package cn.szz.shoot.entity;

import cn.szz.shoot.utils.CommUtils;

/**
 * boss子弹
 *
 * @author Shi Zezhu
 * @date 2018年1月12日 下午4:59:34
 *
 */
public class BossBullet extends FlyObject {

	private static final long serialVersionUID = 6200323434064702379L;

	@Override
	public void action() {
		this.x += this.xspeed;
		this.y += this.yspeed;
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
	 * 检测是否撞击
	 * 
	 * @param flyObject
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:19:13
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

}
