package cn.szz.plane.core.entity.elem;

import java.awt.Graphics;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.Animator;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.PartAlignEnum;
import cn.szz.plane.core.entity.paint.Coordinate;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.CoordinatePart;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.utils.RandomUtils;

public class Enemy extends ItemMover implements Animator {

	private static final Image[] IMAGE_ARRAY = { new Image(ImageEnum.ENEMY, 259, 204, 193, 134),
			new Image(ImageEnum.ENEMY, 266, 474, 98, 76), new Image(ImageEnum.ENEMY, 161, 474, 103, 74),
			new Image(ImageEnum.ENEMY, 365, 522, 100, 77), new Image(ImageEnum.ENEMY, 0, 483, 102, 74),
			new Image(ImageEnum.ENEMY, 276, 551, 70, 63), new Image(ImageEnum.ENEMY, 0, 558, 92, 81),
			new Image(ImageEnum.ENEMY, 103, 550, 100, 70), new Image(ImageEnum.ENEMY, 366, 439, 114, 82),
			new Image(ImageEnum.ENEMY, 1, 364, 158, 116), new Image(ImageEnum.ENEMY, 367, 339, 134, 97),
			new Image(ImageEnum.ENEMY, 189, 339, 176, 134), new Image(ImageEnum.ENEMY, 1, 231, 187, 131),
			new Image(ImageEnum.ENEMY, 1, 2, 258, 196), new Image(ImageEnum.ENEMY, 263, 2, 246, 201) };

	private static final Image TROUGH_IMAGE = new Image(ImageEnum.ENEMY, 0, 200, 258, 16);
	private static final Image BLOOD_IMAGE = new Image(ImageEnum.ENEMY, 3, 222, 250, 7);

	protected final TimesRecord timesRecord = new TimesRecord(); // 时间记录器
	protected int olife; // 原始生命
	protected int speed; // 移动速度
	protected CoordinatePart troughPart; // 血槽图片
	protected CoordinatePart bloodPart; // 血量图片
	protected int starNum; // 爆星数量
	protected int levelNum; // 道具等级

	public Enemy(int type, int starNum, int levelNum) {
		this.rect = getCoordinateImage(type);
		this.life = getLife(type);
		this.damage = 10;
		this.olife = life;
		this.speed = getSpeed(type);
		this.value = getValue(type);
		this.troughPart = new CoordinatePart(TROUGH_IMAGE, rect.getWidth() / 2, 2, rect.getWidth() / 2,
				rect.getWidth() / 32 < 4 ? 4 : rect.getWidth() / 32, rect, PartAlignEnum.BOTTOM_CENTER);
		this.bloodPart = new CoordinatePart(BLOOD_IMAGE,
				rect.getWidth() / 2 - troughPart.getWidth() / 2 + (troughPart.getHeight() > 4 ? 2 : 1),
				troughPart.getHeight() > 4 ? 4 : 3,
				troughPart.getHeight() > 4 ? troughPart.getWidth() - 4 : troughPart.getWidth() - 2,
				troughPart.getHeight() > 4 ? troughPart.getHeight() - 4 : troughPart.getHeight() - 2, rect,
				PartAlignEnum.BOTTOM_LEFT);
		this.starNum = starNum;
		this.levelNum = levelNum;
	}

	@Override
	public void animation() {
		if (getLife() != getOlife()) {
			bloodPart.setWidth(new BigDecimal(troughPart.getWidth() - 4)
					.multiply(new BigDecimal(life).divide(new BigDecimal(olife), 10, BigDecimal.ROUND_HALF_DOWN))
					.intValue());
		}
	}

	@Override
	public void move() {
		if (timesRecord.getMoveTimes(true) % 10 == 0) {
			Rect rect = getRect();
			rect.setY(rect.getY() + getSpeed());
		}
	}

	@Override
	public void draw(Graphics g) {
		getRect().draw(g);
		if (getLife() != getOlife()) {
			getTroughPart().draw(g);
			getBloodPart().draw(g);
		}
	}

	public List<ItemMover> item() {
		List<ItemMover> list = new ArrayList<>();
		int starNum = getStarNum();
		int levelNum = getLevelNum();
		for (int i = 0; i < starNum; i++) {
			list.add(new Star(rect));
		}
		if (levelNum > 0) {
			list.add(new Level(rect, levelNum));
		}
		return list;
	}

	protected CoordinateImage getCoordinateImage(int type) {
		Image image = getImage(type);
		return new CoordinateImage(image, getImageCoordinate(image));
	}

	protected Image getImage(int type) {
		if (type > IMAGE_ARRAY.length) {
			return IMAGE_ARRAY[1];
		}
		return IMAGE_ARRAY[type];
	}

	protected Coordinate getImageCoordinate(Image image) {
		return new Coordinate(RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - image.getWidth()),
				0 - image.getHeight());
	}

	protected int getLife(int type) {
		switch (type) {
		case 0:
			return 20;
		case 1:
			return 10;
		case 2:
			return 12;
		case 3:
			return 14;
		case 4:
			return 16;
		case 5:
			return 18;
		case 6:
			return 20;
		case 7:
			return 22;
		case 8:
			return 24;
		case 9:
			return 26;
		case 10:
			return 28;
		case 11:
			return 30;
		case 12:
			return 32;
		case 13:
			return 34;
		default:
			return getLife(1);
		}
	}

	protected int getDamage(int type) {
		switch (type) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 4;
		case 4:
			return 5;
		case 5:
			return 6;
		case 6:
			return 7;
		case 7:
			return 8;
		case 8:
			return 9;
		case 9:
			return 10;
		case 10:
			return 11;
		case 11:
			return 12;
		case 12:
			return 13;
		case 13:
			return 14;
		default:
			return getDamage(1);
		}
	}

	protected int getSpeed(int type) {
		switch (type) {
		case 0:
			return 4;
		case 1:
			return 4;
		case 2:
			return 5;
		case 3:
			return 5;
		case 4:
			return 6;
		case 5:
			return 6;
		case 6:
			return 7;
		case 7:
			return 7;
		case 8:
			return 8;
		case 9:
			return 8;
		case 10:
			return 9;
		case 11:
			return 9;
		case 12:
			return 10;
		case 13:
			return 10;
		default:
			return getSpeed(1);
		}
	}

	protected int getValue(int type) {
		switch (type) {
		case 0:
			return 5;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 5:
			return 5;
		case 6:
			return 6;
		case 7:
			return 7;
		case 8:
			return 7;
		case 9:
			return 8;
		case 10:
			return 10;
		case 11:
			return 11;
		case 12:
			return 12;
		case 13:
			return 13;
		default:
			return getValue(1);
		}
	}

	public int getOlife() {
		return olife;
	}

	public int getSpeed() {
		return speed;
	}

	public CoordinatePart getTroughPart() {
		return troughPart;
	}

	public CoordinatePart getBloodPart() {
		return bloodPart;
	}

	public int getStarNum() {
		return starNum;
	}

	public int getLevelNum() {
		return levelNum;
	}
}
