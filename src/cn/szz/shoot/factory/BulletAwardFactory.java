package cn.szz.shoot.factory;

import java.util.Random;

import cn.szz.shoot.entity.BulletAward;
import cn.szz.shoot.resource.AwardResources;
import cn.szz.shoot.utils.CommUtils;

public class BulletAwardFactory {

	public static BulletAward CreateHeroBullet() {
		BulletAward bulletAward = new BulletAward();
		bulletAward.setImg(AwardResources.award0);
		bulletAward.setHeight(bulletAward.getImg().getHeight());
		bulletAward.setWidth(bulletAward.getImg().getWidth());
		bulletAward.setX(new Random().nextInt(CommUtils.WIDTH - bulletAward.getWidth()));
		bulletAward.setY(0 - bulletAward.getHeight());
		bulletAward.setXspeed(1);
		bulletAward.setYspeed(1);
		bulletAward.setIsDead(false);
		bulletAward.setLife(1);
		bulletAward.setDamageValue(0);
		bulletAward.setValue(30);
		return bulletAward;
	}
}
