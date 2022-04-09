package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.User;
import cn.szz.plane.core.entity.elem.Player;
import cn.szz.plane.core.entity.elem.ReadyBg;
import cn.szz.plane.core.entity.elem.ReadyLogo;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.core.entity.sound.Sound;
import cn.szz.plane.ui.Window;
import cn.szz.plane.ui.event.KeyListenerEvent;
import cn.szz.plane.ui.event.MouseListenerEvent;
import cn.szz.plane.ui.listener.KeyReleasedListener;
import cn.szz.plane.ui.listener.MouseReleasedListener;

public class Ready extends Scene implements KeyListenerEvent, MouseListenerEvent {

	protected ReadyBg bgImage; // 背景图片
	protected ReadyLogo logo; // LOGO
	protected Image startBtn; // 开始按钮
	protected Sound bgSound; // 背景音乐

	public Ready() {
		super(SceneNameEnum.READY);
		this.bgImage = new ReadyBg(new Image(ImageEnum.READY_BG, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight()));
		this.logo = new ReadyLogo(new Image(ImageEnum.READY_LOGO, 50, 60, UIConfig.INSTANCE.getWindowWidth() - 100,
				(UIConfig.INSTANCE.getWindowWidth() - 100) / 3));
		this.startBtn = new Image(ImageEnum.READY_START, UIConfig.INSTANCE.getWindowWidth() / 2 - 75, 600, 150, 45);
		this.bgSound = new DefaultSound(SoundPathEnum.READY_BG, true);
	}

	@Override
	public List<KeyReleasedListener> getKeyReleasedListener() {
		return Arrays.asList(new KeyReleasedListener(this));
	}

	@Override
	public List<MouseReleasedListener> getMouseReleasedListener() {
		return Arrays.asList(new MouseReleasedListener(this));
	}

	@Override
	public void refresh(Graphics g) {
		bgImage.move();
		logo.move();
		bgImage.draw(g);
		logo.draw(g);
		startBtn.draw(g);
	}

	@Override
	public void onShow() {
		bgSound.play();
	}

	@Override
	public void onHide() {
		bgSound.stop();
	}

	@Override
	public void keyCallback(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			toGame01();
		}
	}

	@Override
	public void mouseCallback(MouseEvent event) {
		toGame01();
	}

	private void toGame01() {
		User user = new User();
		user.setPlayerFireImageType(1);
		user.setPlayerImageType(1);
		user.setPlayerBulletImageType(1);
		user.setMaxScore(0);
		user.setMaxLevel(1);
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(user));
		Window.INSTANCE.showScene(new GameLeve01Run(playerList), true);
	}
}
