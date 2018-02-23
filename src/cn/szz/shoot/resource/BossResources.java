package cn.szz.shoot.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BossResources {

	public static BufferedImage boss0;
	public static BufferedImage boss1;
	public static BufferedImage boss2;
	
	public static BufferedImage bullet0;
	
	public static BufferedImage blast0;
	public static BufferedImage blast1;
	public static BufferedImage blast2;
	public static BufferedImage blast3;
	public static BufferedImage blast4;
	public static BufferedImage blast5;
	public static BufferedImage blast6;
	public static BufferedImage blast7;
	public static BufferedImage blast8;
	
	static {
		try {
			boss0 = ImageIO.read(BgResources.class.getResource("/images/boss/boss0.png"));
			boss1 = ImageIO.read(BgResources.class.getResource("/images/boss/boss1.png"));
			boss2 = ImageIO.read(BgResources.class.getResource("/images/boss/boss2.png"));
			bullet0 = ImageIO.read(BgResources.class.getResource("/images/boss/bullet/bullet0.png"));
			blast0 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast0.png"));
			blast1 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast1.png"));
			blast2 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast2.png"));
			blast3 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast3.png"));
			blast4 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast4.png"));
			blast5 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast5.png"));
			blast6 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast6.png"));
			blast7 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast7.png"));
			blast8 = ImageIO.read(BgResources.class.getResource("/images/boss/blast/blast8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
