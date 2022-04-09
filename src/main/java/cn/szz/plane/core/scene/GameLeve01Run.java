package cn.szz.plane.core.scene;

import java.util.List;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.Enemy;
import cn.szz.plane.core.entity.elem.GameBg;
import cn.szz.plane.core.entity.elem.Player;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.sound.DefaultSound;

public class GameLeve01Run extends GameRun {

	public GameLeve01Run(List<Player> playerList) {
		super(SceneNameEnum.GAME_LEVEL_01, new GameBg(new Image(ImageEnum.GAME_BG_01, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight())), new DefaultSound(SoundPathEnum.GAME_LEVEL_01_BG, true), playerList);
	}

	@Override
	protected void produceEnemy(int refreshTimes) {
		if (refreshTimes <= 10000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(1));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(2));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(3));
			}
		} else if (refreshTimes <= 20000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(2));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(3));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(4));
			}
		} else if (refreshTimes <= 30000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(3));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(4));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(5));
			}
		} else if (refreshTimes <= 40000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(4));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(5));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(6));
			}
		} else if (refreshTimes <= 50000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(5));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(6));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(7));
			}
		} else if (refreshTimes <= 60000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(6));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(7));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(8));
			}
		} else if (refreshTimes <= 70000) {
			if (refreshTimes % 300 == 0) {
				enemyList.add(new Enemy(7));
			}
			if (refreshTimes % 500 == 0) {
				enemyList.add(new Enemy(8));
			}
			if (refreshTimes % 800 == 0) {
				enemyList.add(new Enemy(9));
			}
		} else {
			
		}

	}

}
