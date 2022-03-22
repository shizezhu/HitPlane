package cn.szz.plane.swing.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import cn.szz.plane.swing.MouseListenerEvent;

/**
 * 鼠标移动事件监听
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午7:37:21
 */
public class MouseMovedListener implements MouseMotionListener {

    private MouseListenerEvent event;

    public MouseMovedListener(MouseListenerEvent event) {
        this.event = event;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        event.mouseCallback(e);
    }

}
