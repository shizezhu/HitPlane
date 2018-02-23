package cn.szz.shoot.factory;

import cn.szz.shoot.entity.Hero;
import cn.szz.shoot.entity.HeroBullet;
import cn.szz.shoot.resource.HeroResources;

public class HeroBulletFactory {

	public static HeroBullet createHeroBullet1(Hero hero) {
		HeroBullet heroBullet = new HeroBullet();
		heroBullet.setImg(HeroResources.bullet1);
		heroBullet.setHeight(heroBullet.getImg().getHeight());
		heroBullet.setWidth(heroBullet.getImg().getWidth());
		heroBullet.setX(hero.getX() + (hero.getWidth() - heroBullet.getWidth()) / 2);
		heroBullet.setY(hero.getY() - heroBullet.getHeight());
		heroBullet.setXspeed(0);
		heroBullet.setYspeed(20);
		heroBullet.setIsDead(false);
		heroBullet.setLife(1);
		heroBullet.setDamageValue(1);
		heroBullet.setHero(hero);
		return heroBullet;
	}
	
	public static HeroBullet createHeroBullet2(Hero hero) {
		HeroBullet heroBullet = new HeroBullet();
		heroBullet.setImg(HeroResources.bullet2);
		heroBullet.setHeight(heroBullet.getImg().getHeight());
		heroBullet.setWidth(heroBullet.getImg().getWidth());
		heroBullet.setX(hero.getX() + (hero.getWidth() - heroBullet.getWidth()) / 2);
		heroBullet.setY(hero.getY() - heroBullet.getHeight());
		heroBullet.setXspeed(0);
		heroBullet.setYspeed(20);
		heroBullet.setIsDead(false);
		heroBullet.setLife(2);
		heroBullet.setDamageValue(2);
		heroBullet.setHero(hero);
		return heroBullet;
	}
}
