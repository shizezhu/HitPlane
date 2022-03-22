package cn.szz.plane.core.entity.record;

import cn.szz.plane.core.entity.em.StatusEnum;
import cn.szz.plane.utils.CheckUtils;

/**
 * 全局记录
 *
 * @author Shi Zezhu
 * @date 2020年11月18日 下午2:58:42
 */
public class OverallRecord {

    private TimesRecord timesRecord;
    private StatusEnum currStatus; // 当前状态
    private int maxScore; // 最高得分
    private int maxLevel; // 最高关卡

    public OverallRecord() {
        this.timesRecord = new TimesRecord();
        this.currStatus = StatusEnum.READY;
        this.maxScore = 0;
        this.maxLevel = 0;
    }

    public long getOpenTime() {
        return timesRecord.getOpenTime();
    }

    public long getRefreshTimes() {
        return timesRecord.getTimes();
    }

    public StatusEnum getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(StatusEnum currStatus) {
        this.currStatus = currStatus;
    }

    public boolean isCurrStatus(StatusEnum statusEnum) {
        return CheckUtils.isEquals(getCurrStatus(), statusEnum);
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        if (this.maxScore < maxScore) {
            this.maxScore = maxScore;
        }
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        if (this.maxLevel < maxLevel) {
            this.maxLevel = maxLevel;
        }
    }

    public void refresh() {
        timesRecord.countTimes();
    }
}
