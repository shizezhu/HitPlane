package cn.szz.plane.ui.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cn.szz.plane.ui.event.KeyListenerEvent;

/**
 * 键盘按下事件
 * 
 * @author shizezhu
 *
 */
public class KeyPressedListener implements KeyListener {

	protected KeyListenerEvent event;

	public KeyPressedListener(KeyListenerEvent event) {
		this.event = event;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		event.keyCallback(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
