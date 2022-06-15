package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Coordinate;

/**
 * ICON
 * 
 * @author shizezhu
 * @time 2022年4月12日 上午11:01:25
 */
public class Icon extends Coordinate implements Painter {

	protected ImageIcon image;

	public Icon(ImageIcon image) {
		this(image, 0, 0);
	}

	public Icon(ImageIcon image, int x, int y) {
		super(x, y);
		this.image = image;
	}

	@Override
	public void draw(Graphics g) {
		if (image != null)
			image.paintIcon(null, g, getX(), getY());
	}

	public ImageIcon getImage() {
		return image;
	}

	public Icon setImage(ImageIcon image) {
		this.image = image;
		return this;
	}

	public Icon setX(int x) {
		this.x = x;
		return this;
	}

	public Icon setY(int x) {
		this.x = x;
		return this;
	}
}
