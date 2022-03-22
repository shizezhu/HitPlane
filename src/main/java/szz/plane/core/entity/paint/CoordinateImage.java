package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;

/**
 * 坐标图片
 *
 * @author Shi Zezhu
 * @date 2020年12月5日 上午11:12:23
 */
public class CoordinateImage extends Rect {

    protected Image image;

    public CoordinateImage() {
        this(null);
    }

    public CoordinateImage(Image image) {
        this(image, 0, 0);
    }

    public CoordinateImage(Image image, Coordinate coordinate) {
        this(image, coordinate.getX(), coordinate.getY());
    }

    public CoordinateImage(Image image, int x, int y) {
        this(image, x, y, image.getWidth(), image.getHeight());
    }

    public CoordinateImage(Image image, Rect rect) {
        this(image, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public CoordinateImage(Image image, Coordinate coordinate, int width, int height) {
        this(image, coordinate.getX(), coordinate.getY(), width, height);
    }

    public CoordinateImage(Image image, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        if (image != null)
            g.drawImage(image.getImage(), getX(), getY(), getX2(), getY2(), image.getX(),
                    image.getY(), image.getX2(), image.getY2(), null);
    }

    public Image getImage() {
        return image;
    }

    public CoordinateImage setImage(Image image) {
        this.image = image;
        return this;
    }

    public CoordinateImage setImage(Image image, boolean flag) {
        if (flag) {
            this.width = image.getWidth();
            this.height = image.getHeight();
        }
        return setImage(image);
    }

    @Override
    public CoordinateImage setX(int x) {
        this.x = x;
        return this;
    }

    @Override
    public CoordinateImage setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public CoordinateImage setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public CoordinateImage setHeight(int height) {
        this.height = height;
        return this;
    }
}
