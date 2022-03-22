package cn.szz.plane.core.entity.em;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum ImageEnum {

    READY_BG(readImage("/images/ready_bg.jpg")),
    READY_LOGO(readImage("/images/ready_logo.png")),
    READY_START(readImage("/images/ready_start.png")),
    GAME_BG_01(readImage("/images/game_bg_01.jpg")),
    GAME_BG_02(readImage("/images/game_bg_02.jpg")),
    GAME_BG_03(readImage("/images/game_bg_03.jpg")),
    GAME_BG_04(readImage("/images/game_bg_04.jpg")),
    GAME_BG_05(readImage("/images/game_bg_05.jpg")),
    PLAYER(readImage("/images/player.png")),
    PLAYER_FIRE_01(readImage("/images/player_fire_01.png")),
    PLAYER_FIRE_02(readImage("/images/player_fire_02.png")),
    PLAYER_FIRE_03(readImage("/images/player_fire_03.png")),
    ENEMY(readImage("/images/enemy.png")),
    ITEM(readImage("/images/item.png")),
    BULLET(readImage("/images/bullet.png")),
    BLAST_01(readImage("/images/blast_01.png")),
    BLAST_02(readImage("/images/blast_02.png")),
    BLAST_03(readImage("/images/blast_03.png")),
    BLAST_04(readImage("/images/blast_04.png")),
    BLAST_05(readImage("/images/blast_05.png")),
    BLAST_06(readImage("/images/blast_06.png")),
    BLAST_07(readImage("/images/blast_07.png")),
    BLAST_08(readImage("/images/blast_08.png")),
    BLAST_09(readImage("/images/blast_09.png")),
    BLAST_10(readImage("/images/blast_10.png")),
    ENEMY_BOSS_BLAST_01_01(readImage("/images/enemy_boss_blast_01_01.png")),
    ENEMY_BOSS_BLAST_01_02(readImage("/images/enemy_boss_blast_01_02.png")),
    ENEMY_BOSS_BLAST_01_03(readImage("/images/enemy_boss_blast_01_03.png")),
    ENEMY_BOSS_BLAST_01_04(readImage("/images/enemy_boss_blast_01_04.png")),
    ENEMY_BOSS_BLAST_01_05(readImage("/images/enemy_boss_blast_01_05.png")),
    ENEMY_BOSS_BLAST_01_06(readImage("/images/enemy_boss_blast_01_06.png")),
    ENEMY_BOSS_BLAST_01_07(readImage("/images/enemy_boss_blast_01_07.png")),
    ENEMY_BOSS_BLAST_01_08(readImage("/images/enemy_boss_blast_01_08.png")),
    ENEMY_BOSS_BLAST_01_09(readImage("/images/enemy_boss_blast_01_09.png")),
    PLAYER_BULLET_BLAST_01(readImage("/images/player_bullet_blast_01.png")),
    PLAYER_BULLET_BLAST_02(readImage("/images/player_bullet_blast_02.png")),
    ;

    private BufferedImage image;

    private ImageEnum(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public static BufferedImage readImage(String path) {
        try {
            return ImageIO.read(ImageEnum.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
