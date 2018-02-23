package cn.szz.shoot.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyResources {

	public static BufferedImage enemy0;
	public static BufferedImage enemy1;
	public static BufferedImage enemy2;
	public static BufferedImage enemy3;
	public static BufferedImage enemy4;
	public static BufferedImage enemy5;
	
	public static BufferedImage bullet0;
	public static BufferedImage bullet1;
	public static BufferedImage bullet2;
	public static BufferedImage bullet3;
	
	public static BufferedImage blast0;
	public static BufferedImage blast1;
	public static BufferedImage blast2;
	public static BufferedImage blast3;
	public static BufferedImage blast4;
	
	static {
		try {
			enemy0 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy0.png"));
			enemy1 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy1.png"));
			enemy2 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy2.png"));
			enemy3 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy3.png"));
			enemy4 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy4.png"));
			enemy5 = ImageIO.read(BgResources.class.getResource("/images/enemy/enemy5.png"));
			bullet0 = ImageIO.read(BgResources.class.getResource("/images/enemy/bullet/bullet0.png"));
			bullet1 = ImageIO.read(BgResources.class.getResource("/images/enemy/bullet/bullet1.png"));
			bullet2 = ImageIO.read(BgResources.class.getResource("/images/enemy/bullet/bullet2.png"));
			bullet3 = ImageIO.read(BgResources.class.getResource("/images/enemy/bullet/bullet3.png"));
			blast0 = ImageIO.read(BgResources.class.getResource("/images/enemy/blast/blast0.png"));
			blast1 = ImageIO.read(BgResources.class.getResource("/images/enemy/blast/blast1.png"));
			blast2 = ImageIO.read(BgResources.class.getResource("/images/enemy/blast/blast2.png"));
			blast3 = ImageIO.read(BgResources.class.getResource("/images/enemy/blast/blast3.png"));
			blast4 = ImageIO.read(BgResources.class.getResource("/images/enemy/blast/blast4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
