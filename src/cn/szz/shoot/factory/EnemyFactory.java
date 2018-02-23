package cn.szz.shoot.factory;

import java.awt.image.BufferedImage;
import java.util.Random;

import cn.szz.shoot.entity.Enemy;
import cn.szz.shoot.resource.EnemyResources;
import cn.szz.shoot.utils.CommUtils;

public class EnemyFactory {

	/**
	 * 
	 * 
	 * @param yspeed
	 * @return
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午2:29:19
	 */
	public static Enemy createEnemy(int yspeed) {
		Enemy enemy = new Enemy();
		enemy.setImg(EnemyResources.enemy0);
		enemy.setHeight(enemy.getImg().getHeight());
		enemy.setWidth(enemy.getImg().getWidth());
		enemy.setX(new Random().nextInt(CommUtils.WIDTH - enemy.getWidth()));
		enemy.setY(0 - enemy.getHeight());
		enemy.setXspeed(0);
		enemy.setYspeed(yspeed);
		enemy.setIsDead(false);
		enemy.setLife(1);
		enemy.setDamageValue(1);
		enemy.setScoreAwardValue(5);
		enemy.setIsBlast(false);
		enemy.setCurrentRunImgIndex(0);
		enemy.setRunImgs(new BufferedImage[] {EnemyResources.enemy0});
		enemy.setCurrentBlastImgIndex(0);
		enemy.setBlastImgs(new BufferedImage[] {EnemyResources.blast0, EnemyResources.blast1, EnemyResources.blast2, EnemyResources.blast3, EnemyResources.blast4});
		return enemy;
	}
}
