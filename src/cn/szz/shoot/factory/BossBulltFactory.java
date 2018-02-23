package cn.szz.shoot.factory;

import java.util.Random;

import cn.szz.shoot.entity.Boss;
import cn.szz.shoot.entity.BossBullet;
import cn.szz.shoot.resource.BossResources;

public class BossBulltFactory {

	public static BossBullet createBossBullet0(Boss boss) {
		BossBullet bossBullet = new BossBullet();
		bossBullet.setImg(BossResources.bullet0);
		bossBullet.setHeight(bossBullet.getImg().getHeight());
		bossBullet.setWidth(bossBullet.getImg().getWidth());
		bossBullet.setX(boss.getX() + boss.getWidth() / 2);
		bossBullet.setY(boss.getY() + boss.getHeight());
		bossBullet.setXspeed(new Random().nextInt(3) - 1);
		bossBullet.setYspeed(1);
		bossBullet.setIsDead(false);
		bossBullet.setLife(1);
		bossBullet.setDamageValue(1);
		return bossBullet;
	}
}
