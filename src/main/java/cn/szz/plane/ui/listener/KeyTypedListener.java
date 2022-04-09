package cn.szz.plane.ui.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cn.szz.plane.ui.event.KeyListenerEvent;

/**
 * 键盘按下并抬起事件
 * 
 * @author shizezhu
 *
 */
public class KeyTypedListener implements KeyListener {

	protected KeyListenerEvent event;

	public KeyTypedListener(KeyListenerEvent event) {
		this.event = event;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		event.keyCallback(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
