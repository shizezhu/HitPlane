package cn.szz.plane.swing.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.szz.plane.Main;
import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.factory.PanelFactory;

/**
 * 主窗口
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午5:32:11
 */
public class Window {

    protected static final Map<SceneNameEnum, Panel> PANEL_MAP = new ConcurrentHashMap<>(16); // 面板
    protected static final JFrame MAIN_FRAME = new JFrame(); // 主窗体
    protected static final JPanel MAIN_PANEL = new JPanel(); // 主面板
    protected static final CardLayout MAIN_PANEL_CARDLAYOUT = new CardLayout(); // 布局管理器

    protected static Panel currPanel = null; // 当前面板

    static {
        MAIN_PANEL.setBackground(Color.WHITE); // 将背景设置成白色
        MAIN_PANEL.setLayout(MAIN_PANEL_CARDLAYOUT); // 添加布局管理器
        MAIN_FRAME.add(MAIN_PANEL); // 添加主面板
        MAIN_FRAME.setTitle(UIConfig.INSTANCE.getWindowTitle()); // 窗口标题
        MAIN_FRAME.setSize(UIConfig.INSTANCE.getWindowWidth(), UIConfig.INSTANCE.getWindowHeight()); // 设置窗口大小
        MAIN_FRAME.setLocationRelativeTo(null); // 初始位置居中
        MAIN_FRAME.setAlwaysOnTop(true); // 置顶
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 点关闭关闭程序
        MAIN_FRAME.setResizable(false); // 不可改变尺寸
        MAIN_FRAME.setVisible(true); // 可见
    }

    private Window() {
    }

    public static Panel addPanel(SceneNameEnum sceneName, Panel panel) {
        remove(sceneName);
        PANEL_MAP.put(sceneName, panel);
        MAIN_PANEL.add(panel, sceneName.getName());
        panel.getScene().onAdd();
        MAIN_PANEL.revalidate();
        return panel;
    }

    public static Panel showPanel(SceneNameEnum sceneName) {
        Panel panel = PANEL_MAP.get(sceneName);
        if (panel == null) {
            panel = addPanel(sceneName, PanelFactory.produce(sceneName));
        }
        if (currPanel == null || currPanel != panel) {
            if (currPanel != null) currPanel.getScene().onHide();
            panel.getScene().onShow();
            MAIN_PANEL_CARDLAYOUT.show(MAIN_PANEL, sceneName.getName());
            panel.requestFocus();
            currPanel = panel;
        }
        return panel;
    }

    public static void removeScene(SceneNameEnum sceneName) {
        remove(sceneName);
        MAIN_PANEL.revalidate();
    }

    protected static void remove(SceneNameEnum sceneName) {
        Panel panel = PANEL_MAP.get(sceneName);
        if (panel != null) {
            if (currPanel == panel) currPanel = null;
            PANEL_MAP.remove(sceneName);
            MAIN_PANEL.remove(panel);
            panel.getScene().onRemove();
        }
    }

    public static void removeSceneAll() {
        currPanel = null;
        PANEL_MAP.forEach((sceneNameEnum, panel) -> {
            MAIN_PANEL.remove(panel);
            panel.getScene().onRemove();
        });
        PANEL_MAP.clear();
    }

    public static void repaint() {
        MAIN_FRAME.repaint();
        Main.OVERALL_RECORD.refresh();
    }

    public static void setLocation(int x, int y) {
        MAIN_FRAME.setLocation(x, y);
    }
}
