package cn.szz.shoot.factory;

import java.util.Random;

import cn.szz.shoot.entity.LifeAward;
import cn.szz.shoot.resource.AwardResources;
import cn.szz.shoot.utils.CommUtils;

public class LifeAwardFactory {

	public static LifeAward CreateLifeAward() {
		LifeAward lifeAward = new LifeAward();
		lifeAward.setImg(AwardResources.award1);
		lifeAward.setHeight(lifeAward.getImg().getHeight());
		lifeAward.setWidth(lifeAward.getImg().getWidth());
		lifeAward.setX(new Random().nextInt(CommUtils.WIDTH - lifeAward.getWidth()));
		lifeAward.setY(0 - lifeAward.getHeight());
		lifeAward.setXspeed(1);
		lifeAward.setYspeed(1);
		lifeAward.setIsDead(false);
		lifeAward.setLife(1);
		lifeAward.setDamageValue(0);
		lifeAward.setValue(1);
		return lifeAward;
	}
}
