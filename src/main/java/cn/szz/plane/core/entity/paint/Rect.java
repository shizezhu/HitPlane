package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;

import cn.szz.plane.core.Painter;

/**
 * 矩形
 *
 * @author Shi Zezhu
 * @date 2020年11月23日 下午4:20:07
 */
public class Rect extends Coordinate implements Painter {

	protected int width;
	protected int height;

	public Rect(int width, int height) {
		this(0, 0, width, height);
	}

	public Rect(Coordinate coordinate, int width, int height) {
		this(coordinate.getX(), coordinate.getY(), width, height);
	}

	public Rect(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public Rect setX(int x) {
		this.x = x;
		return this;
	}

	@Override
	public Rect setY(int y) {
		this.y = y;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public Rect setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public Rect setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getX2() {
		return getX() + getWidth();
	}

	public int getY2() {
		return getY() + getHeight();
	}
}
