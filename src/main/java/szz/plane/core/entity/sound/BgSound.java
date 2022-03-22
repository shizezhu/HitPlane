package cn.szz.plane.core.entity.sound;

/**
 * 背景音乐
 *
 * @author Shi Zezhu
 * @date 2020年11月19日 上午10:07:14
 */
public interface BgSound extends Sound {

    /**
     * 循环播放
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 上午10:07:22
     */
    BgSound loop();

    /**
     * 停止播放
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 上午10:07:58
     */
    BgSound stop();
}
