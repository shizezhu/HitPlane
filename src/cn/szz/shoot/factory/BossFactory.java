package cn.szz.shoot.factory;

import java.awt.image.BufferedImage;

import cn.szz.shoot.entity.Boss;
import cn.szz.shoot.resource.BossResources;
import cn.szz.shoot.utils.CommUtils;

public class BossFactory {

	/**
	 * boss静态工厂
	 * 
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午2:39:19
	 */
	public static Boss createBoss() {
		Boss boss = new Boss();
		boss.setImg(BossResources.boss0);
		boss.setHeight(boss.getImg().getHeight());
		boss.setWidth(boss.getImg().getWidth());
		boss.setX((CommUtils.WIDTH - boss.getWidth()) / 2);
		boss.setY(0 - boss.getHeight());
		boss.setXspeed(2);
		boss.setYspeed(1);
		boss.setIsDead(false);
		boss.setLife(99);
		boss.setDamageValue(999);
		boss.setScoreAwardValue(50);
		boss.setIsBlast(false);
		boss.setCurrentRunImgIndex(0);
		boss.setRunImgs(new BufferedImage[] {BossResources.boss0});
		boss.setCurrentBlastImgIndex(0);
		boss.setBlastImgs(new BufferedImage[] {BossResources.blast0, BossResources.blast1, BossResources.blast2, BossResources.blast3, BossResources.blast4, BossResources.blast5, BossResources.blast6, BossResources.blast7, BossResources.blast8});
		return boss;
	}
}
