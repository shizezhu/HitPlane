package cn.szz.plane.core.entity.record;

/**
 * 次数记录
 *
 * @author Shi Zezhu
 * @date 2020年11月21日 下午4:15:23
 */
public class TimesRecord {

	protected int refreshTime; // 刷新计数
	protected int moveTimes; // 移动计数
	protected int animationTimes; // 动画计数
	protected int shootTimes; // 射击计数

	public TimesRecord() {
		this.refreshTime = 0;
		this.moveTimes = 0;
		this.animationTimes = 0;
		this.shootTimes = 0;
	}

	public int getRefreshTimes() {
		return refreshTime;
	}

	public int getRefreshTimes(boolean plus) {
		if (plus) {
			return refreshTime++;
		}
		return refreshTime;
	}

	public void plusRefreshTimes() {
		this.refreshTime++;
	}

	public int getMoveTimes() {
		return moveTimes;
	}

	public int getMoveTimes(boolean plus) {
		if (plus) {
			return moveTimes++;
		}
		return moveTimes;
	}

	public void plusMoveTimes() {
		this.moveTimes++;
	}

	public int getAnimationTimes() {
		return animationTimes;
	}

	public int getAnimationTimes(boolean plus) {
		if (plus) {
			return animationTimes++;
		}
		return animationTimes;
	}

	public void plusAnimationTimes() {
		this.animationTimes++;
	}

	public int getShootTimes() {
		return shootTimes;
	}

	public int getShootTimes(boolean plus) {
		if (plus) {
			return shootTimes++;
		}
		return shootTimes;
	}

	public void plusShootTimes() {
		this.shootTimes++;
	}
}
