package cn.szz.plane.core.entity.elem.item;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.elem.fly.player.Player;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

public class Star extends Elem implements Mover {

    protected final TimesRecord timesRecord = new TimesRecord();

    private Image[] images;
    private int interval;
    private int index;

    public Star(Rect parent, Image[] images, int interval) {
        super(parent);
        this.images = images;
        this.interval = interval;
        this.index = 0;
    }

    @Override
    public void move() {
        if (timesRecord.getTimes(true) % interval == 0) {
            index = timesRecord.getTimes() / interval % images.length;
            Image image = images[index];
            rect = new CoordinateImage(image, rect.getX() + (rect.getWidth() - image.getWidth()) / 2,
                    rect.getY() + (rect.getHeight() - image.getHeight()) / 2);
        }
    }

    /**
     * 检测出界
     *
     * @author Shi Zezhu
     * @date 2020年11月24日 下午12:03:23
     * @return
     */
    public boolean isOut() {
        return rect.isOut();
    }

    /**
     * 检测碰撞
     *
     * @author Shi Zezhu
     * @date 2020年12月5日 下午6:22:22
     * @param player
     * @return
     */
    public void checkHit(Player player) {
        if (rect.isHit(player.getRect())) {
        }
    }

}
