package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;

import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Rect;

public class Elem implements Painter {

    protected Rect rect;

    public Elem(Rect rect) {
        this.rect = rect;
    }

    @Override
    public void draw(Graphics g) {
        rect.draw(g);
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

}
