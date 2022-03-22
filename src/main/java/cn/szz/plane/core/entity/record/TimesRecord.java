package cn.szz.plane.core.entity.record;

/**
 * 次数记录
 *
 * @author Shi Zezhu
 * @date 2020年11月21日 下午4:15:23
 */
public class TimesRecord {

    protected int times; // 次数计数
    private long openTime; // 打开时间

    public TimesRecord() {
        this.times = 0;
        this.openTime = System.currentTimeMillis();
    }

    public int getTimes() {
        return times;
    }

    public int getTimes(boolean flag) {
        if (flag) {
            return times++;
        }
        return times;
    }

    public long getOpenTime() {
        return openTime;
    }

    public TimesRecord countTimes() {
        this.times++;
        return this;
    }
}
