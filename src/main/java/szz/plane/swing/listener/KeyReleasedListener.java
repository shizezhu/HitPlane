package cn.szz.plane.swing.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cn.szz.plane.swing.KeyListenerEvent;

public class KeyReleasedListener implements KeyListener {

    protected KeyListenerEvent event;

    public KeyReleasedListener(KeyListenerEvent event) {
        this.event = event;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        event.keyCallback(e);
    }
}
