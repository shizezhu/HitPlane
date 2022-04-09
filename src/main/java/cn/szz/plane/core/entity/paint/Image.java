package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import cn.szz.plane.core.entity.em.ImageEnum;

/**
 * 图片
 *
 * @author Shi Zezhu
 * @date 2020年11月17日 下午3:48:22
 */
public class Image extends Rect {

    protected BufferedImage image;

    public Image(ImageEnum imageEnum, Coordinate coordinate) {
        this(imageEnum.getImage(), coordinate);
    }

    public Image(BufferedImage image, Coordinate coordinate) {
        this(image, coordinate.getX(), coordinate.getY());
    }

    public Image(ImageEnum imageEnum, int x, int y) {
        this(imageEnum.getImage(), x, y);
    }

    public Image(BufferedImage image, int x, int y) {
        this(image, x, y, image.getWidth(), image.getHeight());
    }

    public Image(ImageEnum imageEnum, Rect rect) {
        this(imageEnum.getImage(), rect);
    }

    public Image(BufferedImage image, Rect rect) {
        this(image, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public Image(ImageEnum imageEnum, Coordinate coordinate, int width, int height) {
        this(imageEnum.getImage(), coordinate, width, height);
    }

    public Image(BufferedImage image, Coordinate coordinate, int width, int height) {
        this(image, coordinate.getX(), coordinate.getY(), width, height);
    }

    public Image(ImageEnum imageEnum, int x, int y, int width, int height) {
        this(imageEnum.getImage(), x, y, width, height);
    }

    public Image(BufferedImage image, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        if (image != null)
            g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public Image setImage(BufferedImage image) {
        this.image = image;
        return this;
    }

    @Override
    public Image setX(int x) {
        this.x = x;
        return this;
    }

    @Override
    public Image setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public Image setWidth(int width) {
        this.width = width;
        return this;
    }

    @Override
    public Image setHeight(int height) {
        this.height = height;
        return this;
    }
}
