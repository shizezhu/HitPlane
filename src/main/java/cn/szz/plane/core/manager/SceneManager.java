package cn.szz.plane.core.manager;

import cn.szz.plane.Main;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.swing.ui.Window;

/**
 * 场景管理器
 *
 * @author Shi Zezhu
 * @date 2020年12月3日 下午4:53:41
 */
public class SceneManager {

    /**
     * 刷新
     *
     * @author Shi Zezhu
     * @date 2020年12月3日 下午4:53:58
     */
    public static void refresh() {
        switch (Main.OVERALL_RECORD.getCurrStatus()) {
        case READY:
            Window.showPanel(SceneNameEnum.READY);
            break;
        case GAME_LEVEL_01_RUN:
            Window.showPanel(SceneNameEnum.GAME_LEVEL_01_RUN);
            break;
        case GAME_LEVEL_02_RUN:
            Window.showPanel(SceneNameEnum.GAME_LEVEL_02_RUN);
            break;
        case GAME_LEVEL_03_RUN:
            Window.showPanel(SceneNameEnum.GAME_LEVEL_03_RUN);
            break;
        case GAME_LEVEL_04_RUN:
            Window.showPanel(SceneNameEnum.GAME_LEVEL_04_RUN);
            break;
        case GAME_LEVEL_05_RUN:
            Window.showPanel(SceneNameEnum.GAME_LEVEL_05_RUN);
            break;
        default:
            break;
        }
        Window.repaint();
    }
}
