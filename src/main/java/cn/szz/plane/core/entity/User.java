package cn.szz.plane.core.entity;

public class User {

    protected int imageId;

    protected int fireImageId;

    protected long maxScore;

    protected long maxGameLevel;

    public User(int imageId, int fireImageId) {
        this(imageId, fireImageId, 0, 0);
    }

    public User(int imageId, int fireImageId, long maxScore, long maxGameLevel) {
        this.imageId = imageId;
        this.fireImageId = fireImageId;
        this.maxScore = maxScore;
        this.maxGameLevel = maxGameLevel;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getFireImageId() {
        return fireImageId;
    }

    public void setFireImageId(int fireImageId) {
        this.fireImageId = fireImageId;
    }

    public long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(long maxScore) {
        this.maxScore = maxScore;
    }

    public long getMaxGameLevel() {
        return maxGameLevel;
    }

    public void setMaxGameLevel(long maxGameLevel) {
        this.maxGameLevel = maxGameLevel;
    }
}
