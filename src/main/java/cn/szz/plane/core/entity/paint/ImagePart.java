package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import cn.szz.plane.core.entity.em.ImageEnum;

public class ImagePart extends Part {

    protected BufferedImage image;

    public ImagePart(ImageEnum image, Rect parent, Align align, Coordinate... coordinates) {
        this(image.getImage(), parent, align, coordinates);
    }

    public ImagePart(BufferedImage image, Rect parent, Align align, Coordinate... coordinates) {
        this(image, image.getWidth(), image.getHeight(), parent, align, coordinates);
    }

    public ImagePart(ImageEnum image, int width, int height, Rect parent, Align align, Coordinate... coordinates) {
        this(image.getImage(), width, height, parent, align, coordinates);
    }

    public ImagePart(BufferedImage image, int width, int height, Rect parent, Align align, Coordinate... coordinates) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.parent = parent;
        this.align = align;
        addCoordinateList(coordinates);
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImagePart setImage(BufferedImage image) {
        this.image = image;
        return this;
    }
    
    public ImagePart setImage(BufferedImage image, boolean flag) {
        if (flag) {
            this.width = image.getWidth();
            this.height = image.getHeight();
        }
        return setImage(image);
    }

    public ImagePart setImage(ImageEnum image) {
        return setImage(image.getImage());
    }
    
    public ImagePart setImage(ImageEnum imageEnum, boolean flag) {
        return setImage(imageEnum.getImage(), flag);
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

    @Override
    public ImagePart setParent(Rect parent) {
        super.setParent(parent);
        return this;
    }

    @Override
    public ImagePart setAlign(Align align) {
        super.setAlign(align);
        return this;
    }

    @Override
    public ImagePart addCoordinateList(List<Coordinate> coordinateList) {
        super.addCoordinateList(coordinateList);
        return this;
    }

    @Override
    public ImagePart addCoordinateList(Coordinate... coordinates) {
        super.addCoordinateList(coordinates);
        return this;
    }

    @Override
    public void draw(Graphics g) {
        if (image != null)
            coordinateList.forEach(coordinate -> g.drawImage(image, getX(coordinate), getY(coordinate), width, height, null));
    }
}
