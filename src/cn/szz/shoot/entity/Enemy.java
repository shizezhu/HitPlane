package cn.szz.shoot.entity;

import cn.szz.shoot.utils.CommUtils;

/**
 * 敌机
 *
 * @author Shi Zezhu
 * @date 2018年1月15日 上午11:28:19
 *
 */
public class Enemy extends EnemyObject {

	private static final long serialVersionUID = 5719264234168798991L;

	@Override
	public void action() {
		if (isBlast) {
			this.img = this.blastImgs[currentBlastImgIndex ++];
			if (this.currentBlastImgIndex >= this.blastImgs.length) {
				this.isDead = true;
			}
		} else {
			this.img = this.runImgs[this.currentRunImgIndex];
			this.y += this.yspeed;
		}
	}

	/**
	 * 越界
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:00:35
	 */
	@Override
	public void outOfBounds() {
		if (this.y >= CommUtils.HEIGHT) {
			this.isDead = true;
		}
	}
}
