package cn.szz.shoot.entity;

/**
 * 英雄子弹
 *
 * @author Shi Zezhu
 * @date 2018年1月9日 下午5:38:45
 *
 */
public class HeroBullet extends FlyObject {

	private static final long serialVersionUID = 3752191416347662933L;
	
	protected Hero hero; //属于哪个英雄
	
	@Override
	public void action() {
		this.x -= this.xspeed;
		this.y -= this.yspeed;
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
	public void blast() {
		if (this.life <= 0) {
			this.isDead = true;
		}
	}

	@Override
	public void outOfBounds() {
		if (this.y <= 0 - this.height) {
			this.isDead = true;
		}
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
