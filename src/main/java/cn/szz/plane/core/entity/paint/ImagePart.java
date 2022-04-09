package cn.szz.plane.core.entity.paint;

import java.awt.image.BufferedImage;

import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.PartAlignEnum;

public class ImagePart extends Image {

	protected Rect parent;
	protected PartAlignEnum align;

	public ImagePart(ImageEnum imageEnum, Coordinate coordinate, Rect parent, PartAlignEnum align) {
		this(imageEnum, coordinate.getX(), coordinate.getY(), parent, align);
	}

	public ImagePart(ImageEnum imageEnum, int x, int y, Rect parent, PartAlignEnum align) {
		this(imageEnum.getImage(), x, y, parent, align);
	}

	public ImagePart(BufferedImage image, int x, int y, Rect parent, PartAlignEnum align) {
		this(image, x, y, image.getWidth(), image.getHeight(), parent, align);
	}

	public ImagePart(ImageEnum imageEnum, Rect rect, Rect parent, PartAlignEnum align) {
		this(imageEnum.getImage(), rect, parent, align);
	}

	public ImagePart(BufferedImage image, Rect rect, Rect parent, PartAlignEnum align) {
		this(image, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), parent, align);
	}

	public ImagePart(ImageEnum imageEnum, Coordinate coordinate, int width, int height, Rect parent,
			PartAlignEnum align) {
		this(imageEnum.getImage(), coordinate, width, height, parent, align);
	}

	public ImagePart(BufferedImage image, Coordinate coordinate, int width, int height, Rect parent,
			PartAlignEnum align) {
		this(image, coordinate.getX(), coordinate.getY(), width, height, parent, align);
	}

	public ImagePart(ImageEnum imageEnum, int x, int y, int width, int height, Rect parent, PartAlignEnum align) {
		this(imageEnum.getImage(), x, y, width, height, parent, align);
	}

	public ImagePart(BufferedImage image, int x, int y, int width, int height, Rect parent, PartAlignEnum align) {
		super(image, x, y, width, height);
		this.parent = parent;
		this.align = align;
	}

	@Override
	public int getX() {
		switch (align) {
		case TOP_LEFT:
			return parent.getX() + x;
		case TOP_CENTER:
			return parent.getX() + x - width / 2;
		case TOP_RIGHT:
			return parent.getX() + x - width;
		case BOTTOM_LEFT:
			return parent.getX() + x;
		case BOTTOM_CENTER:
			return parent.getX() + x - width / 2;
		case BOTTOM_RIGHT:
			return parent.getX() + x - width;
		default:
			return parent.getX() + x;
		}
	}

	@Override
	public int getY() {
		switch (align) {
		case TOP_LEFT:
			return parent.getY() + y - height;
		case TOP_CENTER:
			return parent.getY() + y - height;
		case TOP_RIGHT:
			return parent.getY() + y - height;
		case BOTTOM_LEFT:
			return parent.getY2() + y;
		case BOTTOM_CENTER:
			return parent.getY2() + y;
		case BOTTOM_RIGHT:
			return parent.getY2() + y;
		default:
			return parent.getY2() + y;
		}
	}

	@Override
	public ImagePart setImage(BufferedImage image) {
		this.image = image;
		return this;
	}

	@Override
	public ImagePart setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public ImagePart setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public ImagePart setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public ImagePart setHeight(int height) {
		this.height = height;
		return this;
	}

	public Rect getParent() {
		return parent;
	}

	public ImagePart setParent(Rect parent) {
		this.parent = parent;
		return this;
	}

	public PartAlignEnum getAlign() {
		return align;
	}

	public ImagePart setAlign(PartAlignEnum align) {
		this.align = align;
		return this;
	}
}
