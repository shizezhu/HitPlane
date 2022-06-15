package cn.szz.plane.core.entity.elem;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Coordinate;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;
import cn.szz.plane.core.entity.record.TimesRecord;

/**
 * 玩家子弹
 * 
 * @author shizezhu
 * @time 2022年4月2日 下午5:32:26
 *
 */
public class PlayerBullet extends FlyObj implements Mover {

	private static final Image[] IMAGE_ARRAY = { new Image(ImageEnum.BULLET, 500, 292, 24, 77),
			new Image(ImageEnum.BULLET, 680, 262, 24, 77), new Image(ImageEnum.BULLET, 940, 121, 24, 77) };

	protected final TimesRecord timesRecord = new TimesRecord();
	protected Player player; // 玩家信息

	public PlayerBullet(Player player, Coordinate coordinate, int type) {
		this.rect = getCoordinateImage(player.getRect(), coordinate, type);
		this.life = 1;
		this.damage = 1;
		this.player = player;
	}

	@Override
	public void move() {
		if (timesRecord.getMoveTimes(true) % 1 == 0) {
			Rect image = getRect();
			image.setY(image.getY() - 12);
		}
	}

	@Override
	public Blast blast() {
		return new PlayerBulletBlast(rect);
	}
	
	@Override
	public void checkHit(FlyObj flyObj) {
		if (!isHit(flyObj)) {
			return;
		}
		subLife(flyObj.getDamage());
		if (flyObj instanceof Enemy) {
			Enemy enemy = (Enemy) flyObj;
			getPlayer().addScore(enemy.getValue());
		}
	}

	protected CoordinateImage getCoordinateImage(Rect playerImage, Coordinate coordinate, int type) {
		Image image = getImage(type);
		return new CoordinateImage(image, playerImage.getX() + coordinate.getX() - image.getWidth() / 2,
				playerImage.getY() + coordinate.getY() - image.getHeight());
	}

	protected Image getImage(int type) {
		switch (type) {
		case 1:
			return IMAGE_ARRAY[0];
		case 2:
			return IMAGE_ARRAY[1];
		case 3:
			return IMAGE_ARRAY[2];
		case 4:
			return IMAGE_ARRAY[3];
		default:
			return getImage(1);
		}
	}

	public Player getPlayer() {
		return player;
	}
}
