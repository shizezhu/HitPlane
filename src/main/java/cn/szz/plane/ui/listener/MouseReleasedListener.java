package cn.szz.plane.ui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.szz.plane.ui.event.MouseListenerEvent;

/**
 * 鼠标松开事件监听
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午7:13:05
 */
public class MouseReleasedListener implements MouseListener {

	private MouseListenerEvent event;

	public MouseReleasedListener(MouseListenerEvent event) {
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
		event.mouseCallback(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
