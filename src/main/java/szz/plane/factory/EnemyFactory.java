package cn.szz.plane.factory;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.fly.enemy.Enemy;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.utils.RandomUtils;

/**
 * 敌人构建器
 *
 * @author Shi Zezhu
 * @date 2020年11月21日 下午3:04:27
 */
public class EnemyFactory {

    /**
     * 生产
     *
     * @author Shi Zezhu
     * @date 2020年11月21日 下午3:02:39
     * @return
     */
    public static Enemy produce(int type, int difficulty) {
        switch (type) {
        case 0:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 259, 204, 193, 134), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 194), -132), 3 + 2 * difficulty, 1, 0, 4);
        case 1:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 266, 474, 98, 76), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 99), -75), 3 + 2 * difficulty, 1, 1, 3);
        case 2:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 161, 474, 103, 74), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 104), -73), 4 + 2 * difficulty, 1, 2, 4);
        case 3:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 365, 522, 100, 77), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 101), -76), 5 + 2 * difficulty, 1, 3, 5);
        case 4:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 0, 483, 102, 74), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 103), -73), 6 + 2 * difficulty, 1, 4, 6);
        case 5:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 276, 551, 70, 63), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 71), -62), 6 + 2 * difficulty, 1, 5, 8);
        case 6:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 0, 558, 92, 81), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 93), -80), 6 + 2 * difficulty, 1, 6, 9);
        case 7:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 103, 550, 100, 70), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 101), -69), 6 + 2 * difficulty, 1, 7, 10);
        case 8:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 366, 439, 114, 82), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 115), -81), 10 + 2 * difficulty, 1, 10, 6);
        case 9:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 1, 364, 158, 116), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 159), -115), 10 + 2 * difficulty, 1, 13, 10);
        case 10:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 367, 339, 134, 97), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 135), -96), 15 + 2 * difficulty, 1, 18, 6);
        case 11:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 189, 339, 176, 134), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 177), -133), 20 + 2 * difficulty, 1, 25, 6);
        case 12:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 1, 231, 187, 131), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 188), -130), 30 + 2 * difficulty, 1, 35, 6);
        case 13:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 1, 2, 258, 196), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 259), -195), 45 + 2 * difficulty, 1, 50, 6);
        case 14:
            return new Enemy(new CoordinateImage(new Image(ImageEnum.ENEMY, 263, 2, 246, 201), RandomUtils.nextInt(UIConfig.INSTANCE.getWindowWidth() - 247), -200), 65 + 2 * difficulty, 1, 70, 6);
        default:
            return produce(1, difficulty);
        }
    }
}
