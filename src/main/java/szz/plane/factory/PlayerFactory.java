package cn.szz.plane.factory;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.User;
import cn.szz.plane.core.entity.elem.fly.player.Player;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Coordinate;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.utils.RandomUtils;

public class PlayerFactory {

    public static final Image[][][] FIRE_IMAGE_ARRAY = { {
            {
                    new Image(ImageEnum.PLAYER_FIRE_01, 0, 0, 21, 50),
                    new Image(ImageEnum.PLAYER_FIRE_01, 21, 0, 21, 50)
            },
            {
                    new Image(ImageEnum.PLAYER_FIRE_02, 0, 0, 21, 50),
                    new Image(ImageEnum.PLAYER_FIRE_02, 21, 0, 21, 50)
            },
            {
                    new Image(ImageEnum.PLAYER_FIRE_03, 0, 0, 21, 50),
                    new Image(ImageEnum.PLAYER_FIRE_03, 21, 0, 21, 50)
            }
    } };

    protected User user;

    public PlayerFactory(User user) {
        this.user = user;
    }

    public Player produce(int level) {
        return produce(user, level);
    }

    public static Player produce(User user, int level) {
        return new Player(new PlayerFactory(user), level);
    }

    public CoordinateImage produceImage(int level) {
        return produceImage(user.getImageId(), level);
    }

    public static CoordinateImage produceImage(int id, int level) {
        switch (id) {
        case 1:
            switch (level) {
            case 1:
                Image image1 = new Image(ImageEnum.PLAYER, 393, 102, 115, 92);
                return new CoordinateImage(image1, getImageCoordinate(image1));
            case 2:
                Image image2 = new Image(ImageEnum.PLAYER, 126, 107, 117, 93);
                return new CoordinateImage(image2, getImageCoordinate(image2));
            case 3:
                Image image3 = new Image(ImageEnum.PLAYER, 392, 0, 118, 99);
                return new CoordinateImage(image3, getImageCoordinate(image3));
            case 4:
                Image image4 = new Image(ImageEnum.PLAYER, 136, 0, 130, 104);
                return new CoordinateImage(image4, getImageCoordinate(image4));
            default:
                return produceImage(1, 1);
            }
        default:
            return produceImage(1, level);
        }
    }

    private static Coordinate getImageCoordinate(Image image) {
        return new Coordinate((UIConfig.INSTANCE.getWindowWidth() - image.getWidth()) / 2,
                UIConfig.INSTANCE.getWindowHeight() - image.getHeight() - 70);
    }

    public Image[] produceFireImages(int level) {
        return produceFireImages(user.getFireImageId(), level);
    }

    public static Image[] produceFireImages(int id, int level) {
        switch (id) {
        case 1:
            return FIRE_IMAGE_ARRAY[0][RandomUtils.nextInt(FIRE_IMAGE_ARRAY[0].length)];
        default:
            return produceFireImages(1, level);
        }
    }

    public Coordinate[] produceFireCoordinates(int level) {
        return produceFireCoordinates(user.getImageId(), level);
    }

    public static Coordinate[] produceFireCoordinates(int id, int level) {
        switch (id) {
        case 1:
            switch (level) {
            case 1:
                return new Coordinate[] { new Coordinate(57, -8) };
            case 2:
                return new Coordinate[] { new Coordinate(41, -18), new Coordinate(75, -18) };
            case 3:
                return new Coordinate[] { new Coordinate(33, -24), new Coordinate(42, -22), new Coordinate(76, -22), new Coordinate(85, -24) };
            case 4:
                return new Coordinate[] { new Coordinate(37, -24), new Coordinate(48, -22), new Coordinate(82, -22), new Coordinate(93, -24) };
            default:
                return produceFireCoordinates(1, 1);
            }
        default:
            return produceFireCoordinates(1, level);
        }
    }

    public Coordinate[] produceBulletCoordinates(int level) {
        return produceBulletCoordinates(user.getImageId(), level);
    }

    public static Coordinate[] produceBulletCoordinates(int id, int level) {
        switch (id) {
        case 1:
            switch (level) {
            case 1:
                return new Coordinate[] { new Coordinate(57, 0) };
            case 2:
                return new Coordinate[] { new Coordinate(31, 8), new Coordinate(86, 8) };
            case 3:
                return new Coordinate[] { new Coordinate(46, 0), new Coordinate(72, 0) };
            case 4:
                return new Coordinate[] { new Coordinate(20, 35), new Coordinate(51, 0), new Coordinate(79, 0), new Coordinate(110, 35) };
            default:
                return produceBulletCoordinates(1, 1);
            }
        default:
            return produceBulletCoordinates(1, level);
        }
    }
}
