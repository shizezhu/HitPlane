package cn.szz.plane.swing.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cn.szz.plane.swing.KeyListenerEvent;

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
