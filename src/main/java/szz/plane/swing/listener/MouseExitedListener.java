package cn.szz.plane.swing.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.szz.plane.swing.MouseListenerEvent;

/**
 * 鼠标移出窗口事件监听
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午7:37:50
 */
public class MouseExitedListener implements MouseListener {

    private MouseListenerEvent event;

    public MouseExitedListener(MouseListenerEvent event) {
        this.event = event;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        event.mouseCallback(e);
    }

}
