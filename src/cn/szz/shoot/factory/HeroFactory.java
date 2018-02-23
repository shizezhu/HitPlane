package cn.szz.shoot.factory;

import java.awt.image.BufferedImage;

import cn.szz.shoot.entity.Hero;
import cn.szz.shoot.resource.HeroResources;

public class HeroFactory {

	/**
	 * 英雄静态工厂
	 * 
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午12:31:33
	 */
	public static Hero createHero() {
		Hero hero = new Hero();
		hero.setImg(HeroResources.hero0);
		hero.setHeight(hero.getImg().getHeight());
		hero.setWidth(hero.getImg().getWidth());
		hero.setX(285);
		hero.setY(741);
		hero.setXspeed(0);
		hero.setYspeed(0);
		hero.setIsDead(false);
		hero.setLife(3);
		hero.setDamageValue(999);
		hero.setBulletLevel(0);
		hero.setIsBlast(false);
		hero.setCurrentRunImgIndex(0);
		hero.setRunImgs(new BufferedImage[] {HeroResources.hero0, HeroResources.hero1});
		hero.setCurrentBlastImgIndex(0);
		hero.setBlastImgs(new BufferedImage[] {HeroResources.blast0, HeroResources.blast1, HeroResources.blast2, HeroResources.blast3, 
				HeroResources.blast4, HeroResources.blast5, HeroResources.blast6, HeroResources.blast7, HeroResources.blast8, HeroResources.blast9});
		hero.setMoveFlag(true);
		return hero;
	}
}
