package cn.szz.shoot.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HeroResources {

	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	public static BufferedImage bullet0;
	public static BufferedImage bullet1;
	public static BufferedImage bullet2;
	
	public static BufferedImage blast0;
	public static BufferedImage blast1;
	public static BufferedImage blast2;
	public static BufferedImage blast3;
	public static BufferedImage blast4;
	public static BufferedImage blast5;
	public static BufferedImage blast6;
	public static BufferedImage blast7;
	public static BufferedImage blast8;
	public static BufferedImage blast9;
	
	static {
		try {
			hero0 = ImageIO.read(BgResources.class.getResource("/images/hero/hero0.png"));
			hero1 = ImageIO.read(BgResources.class.getResource("/images/hero/hero1.png"));
			bullet0 = ImageIO.read(BgResources.class.getResource("/images/hero/bullet/bullet0.png"));
			bullet1 = ImageIO.read(BgResources.class.getResource("/images/hero/bullet/bullet1.png"));
			bullet2 = ImageIO.read(BgResources.class.getResource("/images/hero/bullet/bullet2.png"));
			blast0 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast0.png"));
			blast1 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast1.png"));
			blast2 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast2.png"));
			blast3 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast3.png"));
			blast4 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast4.png"));
			blast5 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast5.png"));
			blast6 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast6.png"));
			blast7 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast7.png"));
			blast8 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast8.png"));
			blast9 = ImageIO.read(BgResources.class.getResource("/images/hero/blast/blast9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
