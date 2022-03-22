package cn.szz.plane.core.entity.elem.img;

import java.awt.Graphics;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

public class GameBg extends Elem implements Mover {

    protected final TimesRecord timesRecord = new TimesRecord();

    public GameBg(Rect rect) {
        super(rect);
    }

    @Override
    public void move() {
        int speed = 1;
        int interval = 20;
        if (timesRecord.getTimes(true) % interval == 0) {
            rect.setY(rect.getY() + speed);
            if (rect.getY() >= rect.getHeight()) {
                rect.setY(rect.getY() - rect.getHeight());
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawImage(((Image) rect).getImage(), rect.getX(), rect.getY() - rect.getHeight(), rect.getWidth(), rect.getHeight(), null);
    }
}
