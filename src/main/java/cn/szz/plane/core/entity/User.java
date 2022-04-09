package cn.szz.plane.core.entity;

public class User {

	protected int playerImageType;

	protected int playerBulletImageType;

	protected int playerFireImageType;

	protected int maxScore;

	protected int maxLevel;

	public int getPlayerImageType() {
		return playerImageType;
	}

	public User setPlayerImageType(int playerImageType) {
		this.playerImageType = playerImageType;
		return this;
	}

	public int getPlayerBulletImageType() {
		return playerBulletImageType;
	}

	public User setPlayerBulletImageType(int playerBulletImageType) {
		this.playerBulletImageType = playerBulletImageType;
		return this;
	}

	public int getPlayerFireImageType() {
		return playerFireImageType;
	}

	public User setPlayerFireImageType(int playerFireImageType) {
		this.playerFireImageType = playerFireImageType;
		return this;
	}

	public User setMaxScore(int score) {
		if (this.maxScore <= score) {
			this.maxScore = score;
		}
		return this;
	}

	public int getMaxScore() {
		return this.maxScore;
	}

	public User setMaxLevel(int level) {
		if (this.maxLevel <= level) {
			this.maxLevel = level;
		}
		return this;
	}

	public int getMaxLevel() {
		return this.maxLevel;
	}
}
