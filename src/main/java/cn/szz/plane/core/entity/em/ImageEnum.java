package cn.szz.plane.core.entity.em;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public enum ImageEnum {

	ICON("/images/icon.png"),
	GAME_PAUSE("/images/game_pause.png"),
	GAME_OVER("/images/game_over.png"),
    READY_BG("/images/ready_bg.jpg"),
    READY_LOGO("/images/ready_logo.png"),
    READY_START("/images/ready_start.png"),
    GAME_UI("/images/game_ui.png"),
    GAME_BG_01("/images/game_bg_01.jpg"),
    GAME_BG_02("/images/game_bg_02.jpg"),
    GAME_BG_03("/images/game_bg_03.jpg"),
    GAME_BG_04("/images/game_bg_04.jpg"),
    GAME_BG_05("/images/game_bg_05.jpg"),
    PLAYER("/images/player.png"),
    PLAYER_FIRE_01("/images/player_fire_01.png"),
    PLAYER_FIRE_02("/images/player_fire_02.png"),
    PLAYER_FIRE_03("/images/player_fire_03.png"),
    ENEMY("/images/enemy.png"),
    ITEM("/images/item.png"),
    BULLET("/images/bullet.png"),
    BLAST_01("/images/blast_01.png"),
    BLAST_02("/images/blast_02.png"),
    BLAST_03("/images/blast_03.png"),
    BLAST_04("/images/blast_04.png"),
    BLAST_05("/images/blast_05.png"),
    BLAST_06("/images/blast_06.png"),
    BLAST_07("/images/blast_07.png"),
    BLAST_08("/images/blast_08.png"),
    BLAST_09("/images/blast_09.png"),
    BLAST_10("/images/blast_10.png"),
    ENEMY_BOSS_BLAST_01_01("/images/enemy_boss_blast_01_01.png"),
    ENEMY_BOSS_BLAST_01_02("/images/enemy_boss_blast_01_02.png"),
    ENEMY_BOSS_BLAST_01_03("/images/enemy_boss_blast_01_03.png"),
    ENEMY_BOSS_BLAST_01_04("/images/enemy_boss_blast_01_04.png"),
    ENEMY_BOSS_BLAST_01_05("/images/enemy_boss_blast_01_05.png"),
    ENEMY_BOSS_BLAST_01_06("/images/enemy_boss_blast_01_06.png"),
    ENEMY_BOSS_BLAST_01_07("/images/enemy_boss_blast_01_07.png"),
    ENEMY_BOSS_BLAST_01_08("/images/enemy_boss_blast_01_08.png"),
    ENEMY_BOSS_BLAST_01_09("/images/enemy_boss_blast_01_09.png"),
    PLAYER_BULLET_BLAST_01("/images/player_bullet_blast_01.png"),
    PLAYER_BULLET_BLAST_02("/images/player_bullet_blast_02.png"),
    SCORE("/images/score.png"),
    ;

	private BufferedImage image;
	
    private ImageEnum(String path) {
        this.image = readImage(path);
    }

	public BufferedImage getImage() {
        return image;
    }
    
    public ImageIcon getIcon() {
    	return new ImageIcon(image);
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
