package cn.szz.plane.core.entity.elem;

import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;

/**
 * 玩家子弹爆炸
 * 
 * @author shizezhu
 * @time 2022年4月7日 上午10:17:41
 */
public class PlayerBulletBlast extends Blast {

	public PlayerBulletBlast(Rect rect) {
		super(rect);
	}

	@Override
	protected Image[] getImage() {
		return new Image[] { new Image(ImageEnum.PLAYER_BULLET_BLAST_01, 0, 0),
				new Image(ImageEnum.PLAYER_BULLET_BLAST_02, 0, 0) };
	}

}
