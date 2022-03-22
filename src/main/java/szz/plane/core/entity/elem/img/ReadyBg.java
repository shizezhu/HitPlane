package cn.szz.plane.core.entity.elem.img;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 准备场景背景图
 *
 * @author Shi Zezhu
 * @date 2020年11月20日 上午9:56:25
 */
public class ReadyBg extends Elem implements Mover {

    protected final TimesRecord timesRecord = new TimesRecord();

    public ReadyBg(Rect rect) {
        super(rect);
    }

    @Override
    public void move() {
        int speed = 1;
        int cycle = 100;
        int interval = 50;
        if (timesRecord.getTimes() % interval == 0) {
            if (timesRecord.getTimes() / interval % cycle * 2 < cycle) {
                rect.setX(rect.getX() - speed);
                rect.setY(rect.getY() - speed);
                rect.setWidth(rect.getWidth() + speed * 2);
                rect.setHeight(rect.getHeight() + speed * 2);
            } else {
                rect.setX(rect.getX() + speed);
                rect.setY(rect.getY() + speed);
                rect.setWidth(rect.getWidth() - speed * 2);
                rect.setHeight(rect.getHeight() - speed * 2);
            }
        }
        timesRecord.countTimes();
    }
}
