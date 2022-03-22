package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import cn.szz.plane.Main;
import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.img.ReadyBg;
import cn.szz.plane.core.entity.elem.img.ReadyLogo;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.em.StatusEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.sound.BgSound;
import cn.szz.plane.core.entity.sound.DefaultBgSound;
import cn.szz.plane.swing.KeyListenerEvent;
import cn.szz.plane.swing.Listeners;
import cn.szz.plane.swing.MouseListenerEvent;
import cn.szz.plane.swing.listener.KeyReleasedListener;
import cn.szz.plane.swing.listener.MouseClickedListener;

public class Ready extends SceneAdapter implements KeyListenerEvent, MouseListenerEvent {

    protected ReadyBg bgImage; // 背景图片
    protected BgSound bgSound; // 背景音乐
    protected ReadyLogo logo; // LOGO
    protected Image startBtn; // 开始按钮

    public Ready() {
        this.bgImage = new ReadyBg(new Image(ImageEnum.READY_BG, 0, 0, UIConfig.INSTANCE.getWindowWidth(), UIConfig.INSTANCE.getWindowHeight()));
        this.bgSound = new DefaultBgSound(SoundPathEnum.READY_BG);
        this.logo = new ReadyLogo(new Image(ImageEnum.READY_LOGO, 50, 60, UIConfig.INSTANCE.getWindowWidth() - 100, 180));
        this.startBtn = new Image(ImageEnum.READY_START, 185, 600, 150, 45);
    }

    @Override
    public Listeners getListeners() {
        return new Listeners()
                .add(new KeyReleasedListener(this))
                .add(new MouseClickedListener(this));
    }

    @Override
    public void draw(Graphics g) {
        bgImage.draw(g);
        logo.draw(g);
        startBtn.draw(g);
    }

    @Override
    public void move() {
        bgImage.move();
        logo.move();
    }

    @Override
    public void onShow() {
        bgSound.loop();
    }

    @Override
    public void onHide() {
        bgSound.stop();
    }

    @Override
    public void onRemove() {
        bgSound.stop();
    }

    @Override
    public void keyCallback(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_01_RUN);
        }
    }

    @Override
    public void mouseCallback(MouseEvent event) {
        Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_01_RUN);
    }
}
