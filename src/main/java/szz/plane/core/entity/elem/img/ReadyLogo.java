package cn.szz.plane.core.entity.elem.img;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 准备场景LOGO图
 *
 * @author Shi Zezhu
 * @date 2020年11月20日 上午9:56:25
 */
public class ReadyLogo extends Elem implements Mover {

    protected final TimesRecord timesRecord = new TimesRecord();

    public ReadyLogo(Rect rect) {
        super(rect);
    }

    @Override
    public void move() {
        int speed = 5;
        int totalTimes = 150;
        if (timesRecord.getTimes() == 0) {
            rect.setX(rect.getX() - speed * totalTimes);
            rect.setY(rect.getY() - speed * totalTimes);
            rect.setWidth(rect.getWidth() + speed * totalTimes * 2);
            rect.setHeight(rect.getHeight() + speed * totalTimes * 2);
        } else if (timesRecord.getTimes() <= totalTimes) {
            rect.setX(rect.getX() + speed);
            rect.setY(rect.getY() + speed);
            rect.setWidth(rect.getWidth() - speed * 2);
            rect.setHeight(rect.getHeight() - speed * 2);
        }
        timesRecord.countTimes();
    }

}
