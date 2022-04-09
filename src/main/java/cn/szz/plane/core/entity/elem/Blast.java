package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;
import java.util.stream.Stream;

import cn.szz.plane.core.Animator;
import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

public class Blast implements Painter, Animator {

	protected final TimesRecord timesRecord = new TimesRecord(); // 时间记录器
	protected CoordinateImage[] images; // 图片
	protected int index; // 下标
	protected int speed; // 速度

	public Blast(Rect rect) {
		this.images = getCoordinateImage(rect);
		this.index = 0;
		this.speed = 10;
	}

	protected CoordinateImage[] getCoordinateImage(Rect rect) {
		return Stream.of(getImage())
				.map(image -> new CoordinateImage(image, rect.getX() + (rect.getWidth() - image.getWidth()) / 2,
						rect.getY() + (rect.getHeight() - rect.getHeight()) / 2))
				.toArray(CoordinateImage[]::new);
	}

	protected Image[] getImage() {
		return new Image[] { new Image(ImageEnum.BLAST_01, 0, 0), new Image(ImageEnum.BLAST_02, 0, 0),
				new Image(ImageEnum.BLAST_03, 0, 0), new Image(ImageEnum.BLAST_04, 0, 0),
				new Image(ImageEnum.BLAST_05, 0, 0), new Image(ImageEnum.BLAST_06, 0, 0),
				new Image(ImageEnum.BLAST_07, 0, 0), new Image(ImageEnum.BLAST_08, 0, 0),
				new Image(ImageEnum.BLAST_09, 0, 0), new Image(ImageEnum.BLAST_10, 0, 0) };
	}
	
	@Override
	public void animation() {
		if (timesRecord.getAnimationTimes() % speed == 0) {
			CoordinateImage[] images = getImages();
			this.index = timesRecord.getAnimationTimes() / speed % images.length;
		}
		timesRecord.plusAnimationTimes();
	}

	@Override
	public void draw(Graphics g) {
		CoordinateImage[] images = getImages();
		if (images.length > index) {
			images[index].draw(g);
		}
	}

	public boolean isOver() {
		return index >= getImages().length - 1 && timesRecord.getAnimationTimes() % speed == speed - 1;
	}

	public CoordinateImage[] getImages() {
		return images;
	}
}
