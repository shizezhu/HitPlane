package cn.szz.plane.core.entity.elem.blast;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

public class Blast extends Elem implements Mover {

    protected final TimesRecord timesRecord = new TimesRecord();

    private Image[] images;
    private int interval;
    private int index;

    public Blast(Rect parent, Image[] images, int interval) {
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
     * 是否结束
     *
     * @author Shi Zezhu
     * @date 2020年11月24日 下午12:03:23
     * @return
     */
    public boolean isOver() {
        return index >= images.length - 1 && timesRecord.getTimes() % interval == interval - 1;
    }

    public Image[] getImages() {
        return images;
    }

    public Blast setImages(Image[] images) {
        this.images = images;
        return this;
    }

    public int getInterval() {
        return interval;
    }

    public Blast setInterval(int interval) {
        this.interval = interval;
        return this;
    }
}
