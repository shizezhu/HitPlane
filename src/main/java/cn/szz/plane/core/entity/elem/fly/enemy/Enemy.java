package cn.szz.plane.core.entity.elem.fly.enemy;

import java.awt.Graphics;
import java.math.BigDecimal;

import cn.szz.plane.core.entity.elem.fly.Fly;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Coordinate;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.CoordinatePart;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Part;
import cn.szz.plane.core.entity.record.TimesRecord;

public class Enemy extends Fly {

    protected final TimesRecord timesRecord = new TimesRecord();

    protected int scoreValue; // 分数值
    protected int speed; // 速度
    protected CoordinatePart troughPart; // 血槽图片
    protected CoordinatePart bloodPart; // 血量图片

    public Enemy(CoordinateImage image, int life, int damage, int scoreValue, int speed) {
        super(image, life, damage);
        this.scoreValue = scoreValue;
        this.speed = speed;
        this.troughPart = null;
        this.bloodPart = null;
    }

    @Override
    public void move() {
        if (timesRecord.getTimes(true) % 10 == 0) {
            rect.setY(rect.getY() + speed);
        }
        if (rLife == oLife) {
            return;
        }
        if (troughPart == null) {
            troughPart = new CoordinatePart(new Image(ImageEnum.ENEMY, 0, 201, 258, 16), rect.getWidth() / 2, rect.getWidth() / 32 < 4 ? 4 : rect.getWidth() / 32, rect, Part.Align.BOTTOM_CENTER, new Coordinate[] { new Coordinate(rect.getWidth() / 2, 2) });
        }
        if (bloodPart == null) {
            bloodPart = new CoordinatePart(new Image(ImageEnum.ENEMY, 3, 222, 250, 7), troughPart.getHeight() > 4 ? troughPart.getWidth() - 4 : troughPart.getWidth() - 2, troughPart.getHeight() > 4 ? troughPart.getHeight() - 4 : troughPart.getHeight() - 2, rect, Part.Align.BOTTOM_LEFT, new Coordinate[] { new Coordinate(rect.getWidth() / 2 - troughPart.getWidth() / 2 + (troughPart.getHeight() > 4 ? 2 : 1), troughPart.getHeight() > 4 ? 4 : 3) });
        }
        bloodPart.setWidth(new BigDecimal(troughPart.getWidth()).multiply(new BigDecimal(rLife).divide(new BigDecimal(oLife), 10, BigDecimal.ROUND_HALF_DOWN)).intValue() - 4);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (troughPart != null) troughPart.draw(g);
        if (bloodPart != null) bloodPart.draw(g);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public CoordinatePart getTroughPart() {
        return troughPart;
    }

    public void setTroughPart(CoordinatePart troughPart) {
        this.troughPart = troughPart;
    }

    public CoordinatePart getBloodPart() {
        return bloodPart;
    }

    public void setBloodPart(CoordinatePart bloodPart) {
        this.bloodPart = bloodPart;
    }
}
