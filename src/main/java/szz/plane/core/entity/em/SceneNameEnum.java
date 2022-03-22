package cn.szz.plane.core.entity.em;

public enum SceneNameEnum {

    READY("ready"),
    GAME_LEVEL_01_RUN("game_level_01_run"),
    GAME_LEVEL_02_RUN("game_level_02_run"),
    GAME_LEVEL_03_RUN("game_level_03_run"),
    GAME_LEVEL_04_RUN("game_level_04_run"),
    GAME_LEVEL_05_RUN("game_level_05_run"),
    ;

    private String name;

    private SceneNameEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
