package cn.szz.plane.core.entity.paint;

import cn.szz.plane.core.entity.em.PartAlignEnum;

public class CoordinatePart extends CoordinateImage {

	protected Rect parent;
	protected PartAlignEnum align;

	public CoordinatePart(Image image, Coordinate coordinate, Rect parent, PartAlignEnum align) {
		this(image, coordinate.getX(), coordinate.getY(), parent, align);
	}

	public CoordinatePart(Image image, int x, int y, Rect parent, PartAlignEnum align) {
		this(image, x, y, image.getWidth(), image.getHeight(), parent, align);
	}

	public CoordinatePart(Image image, Rect rect, Rect parent, PartAlignEnum align) {
		this(image, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), parent, align);
	}

	public CoordinatePart(Image image, Coordinate coordinate, int width, int height, Rect parent, PartAlignEnum align) {
		this(image, coordinate.getX(), coordinate.getY(), width, height, parent, align);
	}

	public CoordinatePart(Image image, int x, int y, int width, int height, Rect parent, PartAlignEnum align) {
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
	public CoordinatePart setImage(Image image) {
		this.image = image;
		return this;
	}

	@Override
	public CoordinatePart setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public CoordinatePart setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public CoordinatePart setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public CoordinatePart setHeight(int height) {
		this.height = height;
		return this;
	}

	public Rect getParent() {
		return parent;
	}

	public CoordinatePart setParent(Rect parent) {
		this.parent = parent;
		return this;
	}

	public PartAlignEnum getAlign() {
		return align;
	}

	public CoordinatePart setAlign(PartAlignEnum align) {
		this.align = align;
		return this;
	}

}
