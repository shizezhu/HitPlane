package cn.szz.plane.swing;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.szz.plane.utils.CheckUtils;

/**
 * 鼠标键盘监听器集合
 *
 * @author Shi Zezhu
 * @date 2020年11月24日 下午2:09:38
 */
public class Listeners {

    private List<MouseListener> mouseListenerList = new ArrayList<>();
    private List<MouseMotionListener> mouseMotionListenerList = new ArrayList<>();
    private List<MouseWheelListener> mouseWheelListenerList = new ArrayList<>();
    private List<KeyListener> keyListenerList = new ArrayList<>();

    public Listeners() {
    }

    public Listeners(List<MouseListener> mouseListenerList, List<MouseMotionListener> mouseMotionListenerList, List<MouseWheelListener> mouseWheelListenerList, List<KeyListener> keyListenerList) {
        if (CheckUtils.notNull(mouseListenerList)) this.mouseListenerList.addAll(mouseListenerList);
        if (CheckUtils.notNull(mouseMotionListenerList)) this.mouseMotionListenerList.addAll(mouseMotionListenerList);
        if (CheckUtils.notNull(mouseWheelListenerList)) this.mouseWheelListenerList.addAll(mouseWheelListenerList);
        if (CheckUtils.notNull(keyListenerList)) this.keyListenerList.addAll(keyListenerList);
    }

    public Listeners add(MouseListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> mouseListenerList.addAll(Arrays.asList(listeners)));
        return this;
    }

    public Listeners add(MouseMotionListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> mouseMotionListenerList.addAll(Arrays.asList(listeners)));
        return this;
    }

    public Listeners add(MouseWheelListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> mouseWheelListenerList.addAll(Arrays.asList(listeners)));
        return this;
    }

    public Listeners add(KeyListener... listeners) {
        CheckUtils.ifNotEmpty(listeners, () -> keyListenerList.addAll(Arrays.asList(listeners)));
        return this;
    }

    public List<MouseListener> getMouseListenerList() {
        return mouseListenerList;
    }

    public List<MouseMotionListener> getMouseMotionListenerList() {
        return mouseMotionListenerList;
    }

    public List<MouseWheelListener> getMouseWheelListenerList() {
        return mouseWheelListenerList;
    }

    public List<KeyListener> getKeyListenerList() {
        return keyListenerList;
    }

}
