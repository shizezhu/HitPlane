package cn.szz.shoot.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class AwardResources {

	public static BufferedImage award0;
	public static BufferedImage award1;
	
	static {
		try {
			award0 = ImageIO.read(AwardResources.class.getResource("/images/award/award0.png"));
			award1 = ImageIO.read(AwardResources.class.getResource("/images/award/award1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
