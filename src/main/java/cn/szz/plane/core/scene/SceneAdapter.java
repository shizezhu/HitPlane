package cn.szz.plane.core.scene;

import java.awt.Graphics;

import cn.szz.plane.swing.Listeners;

public class SceneAdapter implements Scene {

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void move() {
    }

    @Override
    public Listeners getListeners() {
        return new Listeners();
    }

    @Override
    public void onAdd() {
    }

    @Override
    public void onShow() {
    }

    @Override
    public void onHide() {
    }

    @Override
    public void onRemove() {
    }

}
