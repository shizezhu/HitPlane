package cn.szz.plane.ui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.szz.plane.ui.event.MouseListenerEvent;

/**
 * 鼠标移入窗口事件监听
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午7:39:32
 */
public class MouseEnteredListener implements MouseListener {

    private MouseListenerEvent event;

    public MouseEnteredListener(MouseListenerEvent event) {
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
        event.mouseCallback(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
