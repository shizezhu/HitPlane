package cn.szz.plane.core.entity.em;

import java.net.URL;

public enum SoundPathEnum {

    READY_BG("/sound/ready_bg.wav"),
    GAME_LEVEL_01_BG("/sound/game_level_01_bg.wav"),
    GAME_LEVEL_02_BG("/sound/game_level_02_bg.wav"),
    GAME_LEVEL_03_BG("/sound/game_level_03_bg.wav"),
    GAME_LEVEL_04_BG("/sound/game_level_04_bg.wav"),
    GAME_LEVEL_05_BG("/sound/game_level_05_bg.wav"),
    PLAYER_BLAST("/sound/player_blast.wav"),
    PLAYER_BULLET_BLAST("/sound/player_bullet_blast.wav"),
    UPGRADE("/sound/upgrade.wav"),
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
