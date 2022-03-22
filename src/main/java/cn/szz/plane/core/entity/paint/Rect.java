package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;

import cn.szz.plane.config.UIConfig;
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
        g.drawRect(x, y, width, height);
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

    public Rect setCoordinate(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
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
        return x + width;
    }

    public int getY2() {
        return y + height;
    }

    /**
     * 是否出界
     *
     * @author Shi Zezhu
     * @date 2020年11月24日 下午12:03:23
     * @return
     */
    public boolean isOut() {
        return getX() > UIConfig.INSTANCE.getWindowWidth() || getX2() < 0
                || getY() > UIConfig.INSTANCE.getWindowHeight() || getY2() < 0;
    }

    /**
     * 是否碰撞
     *
     * @author Shi Zezhu
     * @date 2020年12月5日 下午6:22:22
     * @param rect
     * @return
     */
    public boolean isHit(Rect rect) {
        return getX() + getWidth() > rect.getX() && rect.getX() + rect.getWidth() > getX() &&
                getY() + getHeight() > rect.getY() && rect.getY() + rect.getHeight() > getY();
    }
}
