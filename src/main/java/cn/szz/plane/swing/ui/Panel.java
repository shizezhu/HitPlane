package cn.szz.plane.swing.ui;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.Arrays;

import javax.swing.JPanel;

import cn.szz.plane.core.scene.Scene;
import cn.szz.plane.swing.Listeners;
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
        addListener(scene.getListeners());
    }

    @Override
    public void paint(Graphics g) {
        scene.draw(g);
        scene.move();
    }

    public Panel addListener(MouseListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> Arrays.asList(listeners).forEach(this::addMouseListener));
        return this;
    }

    public Panel addListener(MouseMotionListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> Arrays.asList(listeners).forEach(this::addMouseMotionListener));
        return this;
    }

    public Panel addListener(MouseWheelListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> Arrays.asList(listeners).forEach(this::addMouseWheelListener));
        return this;
    }

    public Panel addListener(KeyListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> Arrays.asList(listeners).forEach(this::addKeyListener));
        return this;
    }

    public Panel addListener(Listeners listeners) {
        listeners.getMouseListenerList().forEach(this::addMouseListener);
        listeners.getMouseMotionListenerList().forEach(this::addMouseMotionListener);
        listeners.getMouseWheelListenerList().forEach(this::addMouseWheelListener);
        listeners.getKeyListenerList().forEach(this::addKeyListener);
        return this;
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
