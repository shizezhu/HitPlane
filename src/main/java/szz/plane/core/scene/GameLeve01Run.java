package cn.szz.plane.core.scene;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.img.GameBg;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.sound.DefaultBgSound;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.factory.EnemyFactory;
import cn.szz.plane.factory.PlayerFactory;

public class GameLeve01Run extends GameRun {

    public GameLeve01Run() {
        super(new GameBg(new Image(ImageEnum.GAME_BG_01, 0, 0, UIConfig.INSTANCE.getWindowWidth(), UIConfig.INSTANCE.getWindowHeight())),
                new DefaultBgSound(SoundPathEnum.GAME_LEVEL_01_BG));
        playerList.add(PlayerFactory.produce(getUser(), difficulty));
    }

    @Override
    protected void produceEnemy() {
        if (timesRecord.getTimes() % 5000 == 0) {
            level++;
            soundSet.add(new DefaultSound(SoundPathEnum.UPGRADE));
        }
        if (timesRecord.getTimes() % 10000 == 0) {
            enemyList.add(EnemyFactory.produce(0, difficulty));
        }
        switch (level) {
        case 1:
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(1, difficulty));
            }
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            break;
        case 2:
            if (timesRecord.getTimes() % 200 == 0) {
                enemyList.add(EnemyFactory.produce(1, difficulty));
            }
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            break;
        case 3:
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(1, difficulty));
            }
            if (timesRecord.getTimes() % 500 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 600 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            break;
        case 4:
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(1, difficulty));
            }
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 500 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            break;
        case 5:
            if (timesRecord.getTimes() % 200 == 0) {
                enemyList.add(EnemyFactory.produce(1, difficulty));
            }
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            break;
        case 6:
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 500 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            if (timesRecord.getTimes() % 600 == 0) {
                enemyList.add(EnemyFactory.produce(4, difficulty));
            }
            break;
        case 7:
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            if (timesRecord.getTimes() % 500 == 0) {
                enemyList.add(EnemyFactory.produce(4, difficulty));
            }
            break;
        case 8:
            if (timesRecord.getTimes() % 200 == 0) {
                enemyList.add(EnemyFactory.produce(2, difficulty));
            }
            if (timesRecord.getTimes() % 300 == 0) {
                enemyList.add(EnemyFactory.produce(3, difficulty));
            }
            if (timesRecord.getTimes() % 400 == 0) {
                enemyList.add(EnemyFactory.produce(4, difficulty));
            }
        }

    }

}
