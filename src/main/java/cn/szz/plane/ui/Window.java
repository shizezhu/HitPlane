package cn.szz.plane.ui;

import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.scene.Scene;
import cn.szz.plane.utils.CheckUtils;

public class Window {

	public static final Window INSTANCE = new Window(); // 实例
	protected final JFrame mainFrame = new JFrame(); // 主窗体
	protected final Map<SceneNameEnum, Scene> sceneCache = new HashMap<>(); // 场景缓存

	private Window() {
		mainFrame.setTitle(UIConfig.INSTANCE.getWindowTitle()); // 窗口标题
		mainFrame.setIconImage(ImageEnum.ICON.getImage()); // ICON
		mainFrame.setSize(UIConfig.INSTANCE.getWindowWidth(), UIConfig.INSTANCE.getWindowHeight()); // 设置窗口大小
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置窗口关闭退出程序
		mainFrame.setResizable(false); // 不可改变尺寸
		mainFrame.setLocationRelativeTo(null); // 初始位置居中
		mainFrame.setAlwaysOnTop(true); // 置顶
		mainFrame.setLayout(null);
	}

	public Scene addScene(Scene scene) {
		sceneCache.put(scene.getName(), scene);
		return scene;
	}

	public void removeScene(SceneNameEnum name) {
		Scene currScene = getCurrScene();
		if (currScene != null && CheckUtils.isEquals(currScene.getName(), name)) {
			return;
		}
		sceneCache.remove(name).onRemove();
	}

	public void cleanScene() {
		Scene currScene = getCurrScene();
		sceneCache.clear();
		if (currScene != null) {
			addScene(currScene);
		}
	}

	public void showScene(SceneNameEnum name, boolean remove) {
		Scene scene = sceneCache.get(name);
		if (scene == null) {
			return;
		}
		Container currPanel = mainFrame.getContentPane();
		mainFrame.remove(currPanel);
		mainFrame.setContentPane(Panel.newInstance(scene));
		mainFrame.setVisible(true);
		Scene currScene = getScene(currPanel);
		if (currScene != null) {
			currScene.onHide();
			if (remove) {
				removeScene(currScene.getName());
			}
		}
		scene.onShow();
	}

	private Scene getScene(SceneNameEnum sceneName) {
		if (sceneName == null) {
			return null;
		}
		return sceneCache.get(sceneName);
	}

	private Scene getScene(Container panel) {
		if (panel == null) {
			return null;
		}
		return getScene(SceneNameEnum.getByValue(panel.getName()));
	}

	private Scene getCurrScene() {
		return getScene(mainFrame.getContentPane());
	}

	public void showScene(SceneNameEnum name) {
		showScene(name, false);
	}

	public void showScene(Scene scene, boolean remove) {
		showScene(addScene(scene).getName(), remove);
	}

	public void showScene(Scene scene) {
		showScene(scene, false);
	}

	public void refresh() {
		mainFrame.repaint();
	}
}
