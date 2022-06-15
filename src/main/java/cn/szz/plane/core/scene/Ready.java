package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.Player;
import cn.szz.plane.core.entity.elem.ReadyBg;
import cn.szz.plane.core.entity.elem.ReadyLogo;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.core.entity.sound.Sound;
import cn.szz.plane.service.UserService;
import cn.szz.plane.service.impl.UserServiceImpl;
import cn.szz.plane.ui.Window;
import cn.szz.plane.ui.event.MouseListenerEvent;
import cn.szz.plane.ui.listener.MouseReleasedListener;

public class Ready extends Scene implements MouseListenerEvent {

	protected UserService userService = new UserServiceImpl(); // 用户
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
	public void mouseCallback(MouseEvent event) {
		Window.INSTANCE.showScene(new GameLeve01Run(Arrays.asList(new Player(userService.getUser()))), true);
	}
}
