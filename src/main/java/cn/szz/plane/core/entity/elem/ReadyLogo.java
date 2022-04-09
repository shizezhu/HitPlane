package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 准备场景LOGO图
 *
 * @author Shi Zezhu
 * @date 2020年11月20日 上午9:56:25
 */
public class ReadyLogo implements Painter, Mover {

	protected final TimesRecord timesRecord = new TimesRecord();
	protected Image image;

	public ReadyLogo(Image image) {
		this.image = image;
	}

	@Override
	public void move() {
		int speed = 5;
		int totalTimes = 150;
		Image image = getImage();
		if (timesRecord.getMoveTimes() == 0) {
			image.setX(image.getX() - speed * totalTimes);
			image.setY(image.getY() - speed * totalTimes);
			image.setWidth(image.getWidth() + speed * totalTimes * 2);
			image.setHeight(image.getHeight() + speed * totalTimes * 2);
		} else if (timesRecord.getMoveTimes() <= totalTimes) {
			image.setX(image.getX() + speed);
			image.setY(image.getY() + speed);
			image.setWidth(image.getWidth() - speed * 2);
			image.setHeight(image.getHeight() - speed * 2);
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
