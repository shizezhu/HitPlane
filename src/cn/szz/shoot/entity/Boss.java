package cn.szz.shoot.entity;

import java.util.ArrayList;
import java.util.List;

import cn.szz.shoot.factory.BossBulltFactory;
import cn.szz.shoot.utils.CommUtils;

public class Boss extends EnemyObject {

	private static final long serialVersionUID = 3264572366053686917L;

	
	/**
	 * 发射子弹
	 * 
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月9日 下午4:57:34
	 */
	public List<BossBullet> shoot() {
		List<BossBullet> list = new ArrayList<BossBullet>();
		list.add(BossBulltFactory.createBossBullet0(this));
		return list;
	}

	@Override
	public void action() {
		if (isBlast) {
			this.img = this.blastImgs[currentBlastImgIndex ++];
			if (this.currentBlastImgIndex >= this.blastImgs.length) {
				this.isDead = true;
			}
		} else {
			this.img = this.runImgs[this.currentRunImgIndex];
			this.x += this.xspeed;
			this.y += this.yspeed;
			if(this.x <= 0) {
				this.xspeed = 4;
			}
			if(this.x >= CommUtils.WIDTH - this.width) {
				this.xspeed = -4;
			}
			if (this.y >= 20) {
				this.yspeed = 0;
			}
		}
	}

	@Override
	public void outOfBounds() {}

}
