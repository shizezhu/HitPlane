package cn.szz.plane.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.szz.plane.core.entity.elem.fly.player.Player;
import cn.szz.plane.core.entity.elem.fly.player.PlayerBullet;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Coordinate;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.utils.RandomUtils;

public class PlayerBulletFactory {

    public static final Image[][] IMAGE_ARRAY = { {
            new Image(ImageEnum.BULLET, 500, 292, 24, 77),
            new Image(ImageEnum.BULLET, 680, 262, 24, 77),
            new Image(ImageEnum.BULLET, 940, 121, 24, 77)
    } };

    protected Player player;

    public PlayerBulletFactory(Player player) {
        this.player = player;
    }

    public List<PlayerBullet> produce(int type, Coordinate[] coordinates) {
        return produce(player, type, coordinates);
    }

    public static List<PlayerBullet> produce(Player player, int type, Coordinate[] coordinates) {
        switch (type) {
        case 1:
            Image image0 = IMAGE_ARRAY[0][RandomUtils.nextInt(IMAGE_ARRAY[0].length)];
            return Stream.of(coordinates).map(coordinate -> new PlayerBullet(
                    new CoordinateImage(image0, player.getRect().getX() + coordinate.getX() - image0.getWidth() / 2, player.getRect().getY() + coordinate.getY() - image0.getHeight()), 1, 1, player)).collect(Collectors.toList());
        default:
            return produce(player, 1, coordinates);
        }
    }
}
