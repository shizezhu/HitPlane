package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Rect;

/**
 * 飞行物
 * 
 * @author shizezhu
 * @time 2022年4月7日 上午10:17:22
 */
public abstract class FlyObj implements Painter {

	protected Rect rect; // 矩形
	protected int life; // 生命值
	protected int damage; // 伤害值

	@Override
	public void draw(Graphics g) {
		getRect().draw(g);
	}

	/**
	 * 是否活着
	 * 
	 * @author shizezhu
	 * @time 2022年4月8日 下午4:03:40
	 * @return
	 */
	public boolean isAlive() {
		return getLife() > 0;
	}

	/**
	 * 是否死亡
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 上午10:29:47
	 * @return
	 */
	public boolean isDead() {
		return getLife() <= 0;
	}

	/**
	 * 是否出界
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 上午10:26:35
	 * @return
	 */
	public boolean isOut() {
		return rect.getX() > UIConfig.INSTANCE.getWindowWidth() || rect.getX2() < 0
				|| rect.getY() > UIConfig.INSTANCE.getWindowHeight() || rect.getY2() < 0;
	}

	/**
	 * 是否碰撞
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 上午10:27:46
	 * @param flyObj
	 * @return
	 */
	public boolean isHit(FlyObj flyObj) {
		Rect rect1 = flyObj.getRect();
		return rect.getX() + rect.getWidth() > rect1.getX() && rect1.getX() + rect1.getWidth() > rect.getX()
				&& rect.getY() + rect.getHeight() > rect1.getY() && rect1.getY() + rect1.getHeight() > rect.getY();
	}

	/**
	 * 减生命
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 上午10:30:01
	 * @param life
	 */
	public void subLife(int value) {
		this.life = getLife() - value;
	}

	/**
	 * 检测碰撞
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 上午10:30:09
	 * @param flyObj
	 */
	public void checkHit(FlyObj flyObj) {
		if (!isHit(flyObj)) {
			return;
		}
		subLife(flyObj.getDamage());
	}

	/**
	 * 爆炸
	 * 
	 * @author shizezhu
	 * @time 2022年4月8日 下午4:42:19
	 * @return
	 */
	public Blast blast() {
		return new Blast(rect);
	}

	public Rect getRect() {
		return rect;
	}

	public int getLife() {
		return life;
	}

	public int getDamage() {
		return damage;
	}
}
