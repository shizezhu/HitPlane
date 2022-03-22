package cn.szz.plane.swing.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.szz.plane.swing.MouseListenerEvent;

/**
 * 鼠标点击事件监听
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午7:13:05
 */
public class MouseClickedListener implements MouseListener {

    private MouseListenerEvent event;

    public MouseClickedListener(MouseListenerEvent event) {
        this.event = event;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        event.mouseCallback(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
