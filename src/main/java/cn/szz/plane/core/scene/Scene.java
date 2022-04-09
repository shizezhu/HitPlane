package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.ui.listener.KeyPressedListener;
import cn.szz.plane.ui.listener.KeyReleasedListener;
import cn.szz.plane.ui.listener.KeyTypedListener;
import cn.szz.plane.ui.listener.MouseClickedListener;
import cn.szz.plane.ui.listener.MouseEnteredListener;
import cn.szz.plane.ui.listener.MouseExitedListener;
import cn.szz.plane.ui.listener.MouseMovedListener;
import cn.szz.plane.ui.listener.MousePressedListener;
import cn.szz.plane.ui.listener.MouseReleasedListener;

/**
 * 场景
 *
 * @author shizezhu
 * @time 2022年3月31日 下午3:45:28
 *
 */
public abstract class Scene {

	private SceneNameEnum name;

	public Scene(SceneNameEnum name) {
		this.name = name;
	}

	public List<KeyPressedListener> getKeyPressedListener() {
		return new ArrayList<>();
	}

	public List<KeyReleasedListener> getKeyReleasedListener() {
		return new ArrayList<>();
	}

	public List<KeyTypedListener> getKeyTypedListener() {
		return new ArrayList<>();
	}

	public List<MouseClickedListener> getMouseClickedListener() {
		return new ArrayList<>();
	}

	public List<MouseEnteredListener> getMouseEnteredListener() {
		return new ArrayList<>();
	}

	public List<MouseExitedListener> getMouseExitedListener() {
		return new ArrayList<>();
	}

	public List<MouseMovedListener> getMouseMovedListener() {
		return new ArrayList<>();
	}

	public List<MousePressedListener> getMousePressedListener() {
		return new ArrayList<>();
	}

	public List<MouseReleasedListener> getMouseReleasedListener() {
		return new ArrayList<>();
	}

	/**
	 * 刷新
	 * 
	 * @author shizezhu
	 * @time 2022年4月1日 下午3:34:08
	 *
	 * @param g
	 */
	public abstract void refresh(Graphics g);

	/**
	 * 展示回调
	 * 
	 * @author shizezhu
	 * @time 2022年3月31日 下午3:46:02
	 *
	 */
	public void onShow() {

	}

	/**
	 * 隐藏回调
	 * 
	 * @author shizezhu
	 * @time 2022年3月31日 下午3:46:09
	 *
	 */
	public void onHide() {

	}

	/**
	 * 移除回调
	 * 
	 * @author shizezhu
	 * @time 2022年4月7日 下午1:42:30
	 */
	public void onRemove() {

	}

	public SceneNameEnum getName() {
		return name;
	}

	public void setName(SceneNameEnum name) {
		this.name = name;
	}
}
