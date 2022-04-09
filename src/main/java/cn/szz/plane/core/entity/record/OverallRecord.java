package cn.szz.plane.core.entity.record;

/**
 * 全局记录
 *
 * @author Shi Zezhu
 * @date 2020年11月18日 下午2:58:42
 */
public class OverallRecord {

	private int maxScore; // 最高得分
	private int maxLevel; // 最高关卡

	public OverallRecord() {
		this.maxScore = 0;
		this.maxLevel = 0;
	}

	public OverallRecord setMaxScore(int score) {
		if (this.maxScore <= score) {
			this.maxScore = score;
		}
		return this;
	}

	public int getMaxScore() {
		return this.maxScore;
	}

	public OverallRecord setMaxLevel(int level) {
		if (this.maxLevel <= level) {
			this.maxLevel = level;
		}
		return this;
	}

	public int getMaxLevel() {
		return this.maxLevel;
	}
}
