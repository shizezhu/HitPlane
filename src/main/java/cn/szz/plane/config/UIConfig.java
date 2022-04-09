package cn.szz.plane.config;

import cn.szz.plane.utils.CheckUtils;
import cn.szz.plane.utils.PropertiesUtils;

/**
 * 界面ui配置
 *
 * @author Shi Zezhu
 * @date 2020年11月18日 上午9:44:19
 */
public class UIConfig {

    private static final PropertiesUtils propertiesUtils =
            new PropertiesUtils(PropertiesUtils.DEFAULT_PATH1 + "/config", "config-ui.properties");

    public static final UIConfig INSTANCE = new UIConfig();

    static {
        INSTANCE.windowTitle = CheckUtils.ifIsEmptyGet(propertiesUtils.get("window.title"), "飞机大战");
        INSTANCE.windowWidth = CheckUtils.ifNotIntGet(propertiesUtils.get("window.width"), 520);
        INSTANCE.windowHeight = CheckUtils.ifNotIntGet(propertiesUtils.get("window.height"), 800);
    }

    private String windowTitle;

    private int windowWidth;

    private int windowHeight;

    private UIConfig() {
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }
}
