package cn.szz.plane.core.entity.em;

import java.net.URL;

/**
 * 声音
 * 
 * @author shizezhu
 * @time 2022年4月12日 上午11:00:53
 */
public enum SoundPathEnum {

    READY_BG("/sound/ready_bg.wav"),
    GAME_READY("/sound/game_ready.wav"),
    GAME_LEVEL_01_BG("/sound/game_level_01_bg.wav"),
    GAME_LEVEL_02_BG("/sound/game_level_02_bg.wav"),
    GAME_LEVEL_03_BG("/sound/game_level_03_bg.wav"),
    GAME_LEVEL_04_BG("/sound/game_level_04_bg.wav"),
    GAME_LEVEL_05_BG("/sound/game_level_05_bg.wav"),
    ENEMY_BLAST("/sound/enemy_blast.wav"),
    PLAYER_BLAST("/sound/player_blast.wav"),
    PLAYER_BULLET_BLAST("/sound/player_bullet_blast.wav"),
    LEVEL("/sound/level.wav"),
    STAR("/sound/star.wav"),
    ;

    private String path;

    private SoundPathEnum(String path) {
        this.path = path;
    }

    public URL getURL() {
        return this.getClass().getResource(path);
    }

    public String getFormat() {
        return path.substring(path.lastIndexOf(".") + 1, path.length());
    }

    public String getPath() {
        return getURL().getPath();
    }
}
