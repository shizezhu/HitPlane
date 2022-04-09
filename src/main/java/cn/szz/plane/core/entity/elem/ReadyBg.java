package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 准备场景背景图
 *
 * @author Shi Zezhu
 * @date 2020年11月20日 上午9:56:25
 */
public class ReadyBg implements Painter, Mover {

	protected final TimesRecord timesRecord = new TimesRecord();
	protected Image image;

	public ReadyBg(Image image) {
		this.image = image;
	}

	@Override
	public void move() {
		int speed = 1;
		int cycle = 100;
		int interval = 50;
		Image image = getImage();
		if (timesRecord.getMoveTimes() % interval == 0) {
			if (timesRecord.getMoveTimes() / interval % cycle * 2 < cycle) {
				image.setX(image.getX() - speed);
				image.setY(image.getY() - speed);
				image.setWidth(image.getWidth() + speed * 2);
				image.setHeight(image.getHeight() + speed * 2);
			} else {
				image.setX(image.getX() + speed);
				image.setY(image.getY() + speed);
				image.setWidth(image.getWidth() - speed * 2);
				image.setHeight(image.getHeight() - speed * 2);
			}
		}
		timesRecord.plusMoveTimes();
	}

	@Override
	public void draw(Graphics g) {
		getImage().draw(g);
	}

	public Image getImage() {
		return image;
	}
}
