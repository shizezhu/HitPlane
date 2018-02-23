package cn.szz.shoot.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BgResources {

	public static BufferedImage bg0;
	public static BufferedImage bg1;
	
	public static BufferedImage start;
	public static BufferedImage gameover;
	public static BufferedImage pause;
	
	static {
		try {
			bg0 = ImageIO.read(BgResources.class.getResource("/images/bg/bg0.png"));
			bg1 = ImageIO.read(BgResources.class.getResource("/images/bg/bg1.jpg"));
			start = ImageIO.read(BgResources.class.getResource("/images/bg/start.png"));
			gameover = ImageIO.read(BgResources.class.getResource("/images/bg/gameover.png"));
			pause = ImageIO.read(BgResources.class.getResource("/images/bg/pause.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
