package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 背景图片
 * 
 * @author shizezhu
 * @time 2022年4月2日 下午5:15:57
 *
 */
public class GameBg implements Painter, Mover {

	protected final TimesRecord timesRecord = new TimesRecord(); // 时间记录器
	protected Image image; // 图片

	public GameBg(Image image) {
		this.image = image;
	}

	@Override
	public void move() {
		int speed = 1;
		int interval = 20;
		Image image = getImage();
		if (timesRecord.getMoveTimes(true) % interval == 0) {
			image.setY(image.getY() + speed);
			if (image.getY() >= image.getHeight()) {
				image.setY(image.getY() - image.getHeight());
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		Image image = getImage();
		image.draw(g);
		g.drawImage(image.getImage(), image.getX(), image.getY() - image.getHeight(), image.getWidth(),
				image.getHeight(), null);
	}

	public Image getImage() {
		return image;
	}
}
