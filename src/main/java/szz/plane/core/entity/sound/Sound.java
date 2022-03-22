package cn.szz.plane.core.entity.sound;

/**
 * 声音
 *
 * @author Shi Zezhu
 * @date 2020年11月19日 上午10:06:56
 */
public interface Sound {

    public static final String WAV = "wav";
    public static final String MP3 = "mp3";

    /**
     * 播放
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 上午10:07:06
     */
    Sound play();
}
