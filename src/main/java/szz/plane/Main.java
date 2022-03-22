package cn.szz.plane;

import java.util.concurrent.TimeUnit;

import cn.szz.plane.core.entity.record.OverallRecord;
import cn.szz.plane.core.manager.SceneManager;
import cn.szz.plane.utils.ExecutorUtils;

/**
 * 飞机大战第三版，该版本主要学习如何使用设计模式
 *
 * @author Shi Zezhu
 * @date 2020年11月17日 下午12:09:18
 */
public class Main {

    public static final OverallRecord OVERALL_RECORD = new OverallRecord();

    public static void main(String[] args) throws Exception {
        ExecutorUtils.scheduleWithFixedDelay(SceneManager::refresh, 2, 2, TimeUnit.MILLISECONDS);
    }
}
