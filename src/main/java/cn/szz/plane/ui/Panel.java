package cn.szz.plane.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import cn.szz.plane.core.scene.Scene;
import cn.szz.plane.utils.CheckUtils;

/**
 * 面板
 *
 * @author Shi Zezhu
 * @date 2020年11月18日 上午11:39:37
 */
public class Panel extends JPanel {

	private static final long serialVersionUID = 2983928919994954429L;

	private Scene scene;

	public Panel(Scene scene) {
		this.scene = scene;
		setName(scene.getName().getValue());
		setLayout(null);
		CheckUtils.ifNotEmpty(scene.getKeyPressedListener(), (list) -> list.forEach(this::addKeyListener));
		CheckUtils.ifNotEmpty(scene.getKeyReleasedListener(), (list) -> list.forEach(this::addKeyListener));
		CheckUtils.ifNotEmpty(scene.getKeyTypedListener(), (list) -> list.forEach(this::addKeyListener));
		CheckUtils.ifNotEmpty(scene.getMouseClickedListener(), (list) -> list.forEach(this::addMouseListener));
		CheckUtils.ifNotEmpty(scene.getMouseEnteredListener(), (list) -> list.forEach(this::addMouseListener));
		CheckUtils.ifNotEmpty(scene.getMouseExitedListener(), (list) -> list.forEach(this::addMouseListener));
		CheckUtils.ifNotEmpty(scene.getMouseMovedListener(), (list) -> list.forEach(this::addMouseMotionListener));
		CheckUtils.ifNotEmpty(scene.getMousePressedListener(), (list) -> list.forEach(this::addMouseListener));
		CheckUtils.ifNotEmpty(scene.getMouseReleasedListener(), (list) -> list.forEach(this::addMouseListener));
	}

	@Override
	public void paint(Graphics g) {
		scene.refresh(g);
	}

	public Scene getScene() {
		return scene;
	}

	public Panel setScene(Scene scene) {
		this.scene = scene;
		return this;
	}

	public static Panel newInstance(Scene scene) {
		return new Panel(scene);
	}
}
