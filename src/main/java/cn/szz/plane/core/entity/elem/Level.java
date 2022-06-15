package cn.szz.plane.core.entity.elem;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.utils.RandomUtils;

public class Level extends ItemMover {

	private static final Image IMAGE = new Image(ImageEnum.ITEM, 210, 76, 78, 50);

	protected final TimesRecord timesRecord = new TimesRecord(); // 时间记录器

	public Level(Rect rect, int value) {
		this.rect = new CoordinateImage(IMAGE,
				rect.getX() + RandomUtils.nextInt(0, IMAGE.getWidth()) - IMAGE.getWidth() / 2
						+ (rect.getWidth() - IMAGE.getWidth()) / 2,
				rect.getY() + RandomUtils.nextInt(0, IMAGE.getHeight()) - 10
						+ (rect.getHeight() - rect.getHeight()) / 2);
		this.life = 1;
		this.damage = 0;
		this.value = value;
	}

	@Override
	public void move() {
		if (timesRecord.getMoveTimes() % 2 == 0) {
			Rect rect = getRect();
			if (timesRecord.getMoveTimes() <= 130) {
				rect.setY(rect.getY() - (80 - (timesRecord.getMoveTimes() > 80 ? 80 : timesRecord.getMoveTimes())) / 10);
				if (rect.getY() < 0) {
					rect.setY(0);
				}
			} else {
				rect.setY(rect.getY() + 1 + timesRecord.getMoveTimes() / 500);
			}
		}
		timesRecord.plusMoveTimes();
	}

	@Override
	public boolean isOut() {
		return rect.getX() > UIConfig.INSTANCE.getWindowWidth() || rect.getX2() < 0
				|| rect.getY() > UIConfig.INSTANCE.getWindowHeight();
	}
}
