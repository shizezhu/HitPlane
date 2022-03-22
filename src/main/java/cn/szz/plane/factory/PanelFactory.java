package cn.szz.plane.factory;

import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.scene.GameLeve01Run;
import cn.szz.plane.core.scene.GameLeve02Run;
import cn.szz.plane.core.scene.GameLeve03Run;
import cn.szz.plane.core.scene.GameLeve04Run;
import cn.szz.plane.core.scene.GameLeve05Run;
import cn.szz.plane.core.scene.Ready;
import cn.szz.plane.swing.ui.Panel;

/**
 * 场景面板工厂
 *
 * @author Shi Zezhu
 * @date 2020年11月21日 下午4:39:36
 */
public class PanelFactory {

    /**
     * 生产
     *
     * @author Shi Zezhu
     * @date 2020年11月21日 下午4:39:55
     * @param sceneName 场景名称
     * @return
     */
    public static Panel produce(SceneNameEnum sceneName) {
        switch (sceneName) {
        case READY:
            return Panel.newInstance(new Ready());
        case GAME_LEVEL_01_RUN:
            return Panel.newInstance(new GameLeve01Run());
        case GAME_LEVEL_02_RUN:
            return Panel.newInstance(new GameLeve02Run());
        case GAME_LEVEL_03_RUN:
            return Panel.newInstance(new GameLeve03Run());
        case GAME_LEVEL_04_RUN:
            return Panel.newInstance(new GameLeve04Run());
        case GAME_LEVEL_05_RUN:
            return Panel.newInstance(new GameLeve05Run());
        default:
            return null;
        }
    }
}
