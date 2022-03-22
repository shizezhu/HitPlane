package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;
import java.util.List;

public class CoordinatePart extends Part {

    protected Image image;

    public CoordinatePart(Image image, Rect parent, Align align, Coordinate... coordinates) {
        this(image, image.getWidth(), image.getHeight(), parent, align, coordinates);
    }

    public CoordinatePart(Image image, int width, int height, Rect parent, Align align, Coordinate... coordinates) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.parent = parent;
        this.align = align;
        addCoordinateList(coordinates);
    }

    public Image getImage() {
        return image;
    }

    public CoordinatePart setImage(Image image) {
        this.image = image;
        return this;
    }

    public CoordinatePart setImage(Image image, boolean flag) {
        if (flag) {
            this.width = image.getWidth();
            this.height = image.getHeight();
        }
        return setImage(image);
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

    @Override
    public CoordinatePart setParent(Rect parent) {
        super.setParent(parent);
        return this;
    }

    @Override
    public CoordinatePart setAlign(Align align) {
        super.setAlign(align);
        return this;
    }

    @Override
    public CoordinatePart addCoordinateList(List<Coordinate> coordinateList) {
        super.addCoordinateList(coordinateList);
        return this;
    }

    @Override
    public CoordinatePart addCoordinateList(Coordinate... coordinates) {
        super.addCoordinateList(coordinates);
        return this;
    }

    @Override
    public void draw(Graphics g) {
        if (image != null)
            coordinateList.forEach(coordinate -> g.drawImage(image.getImage(), getX(coordinate), getY(coordinate),
                    getX2(coordinate), getY2(coordinate), image.getX(), image.getY(), image.getX2(), image.getY2(), null));
    }

}
