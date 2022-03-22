package cn.szz.plane.core.entity.paint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.szz.plane.core.Painter;

/**
 * 组件
 *
 * @author Shi Zezhu
 * @date 2020年12月10日 下午3:42:17
 */
public abstract class Part implements Painter {

    public static enum Align {

        TOP_LEFT, TOP_CENTER, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
    }

    protected int width; // 宽
    protected int height; // 高
    protected Rect parent; // 父级
    protected Align align; // 排列
    protected List<Coordinate> coordinateList; // 坐标

    public Part() {
        this.coordinateList = new ArrayList<>();
    }

    public int getX(Coordinate coordinate) {
        switch (align) {
        case TOP_LEFT:
            return parent.getX() + coordinate.getX();
        case TOP_CENTER:
            return parent.getX() + coordinate.getX() - width / 2;
        case TOP_RIGHT:
            return parent.getX() + coordinate.getX() - width;
        case BOTTOM_LEFT:
            return parent.getX() + coordinate.getX();
        case BOTTOM_CENTER:
            return parent.getX() + coordinate.getX() - width / 2;
        case BOTTOM_RIGHT:
            return parent.getX() + coordinate.getX() - width;
        default:
            return parent.getX() + coordinate.getX();
        }
    }

    public int getY(Coordinate coordinate) {
        switch (align) {
        case TOP_LEFT:
            return parent.getY() + coordinate.getY() - height;
        case TOP_CENTER:
            return parent.getY() + coordinate.getY() - height;
        case TOP_RIGHT:
            return parent.getY() + coordinate.getY() - height;
        case BOTTOM_LEFT:
            return parent.getY2() + coordinate.getY();
        case BOTTOM_CENTER:
            return parent.getY2() + coordinate.getY();
        case BOTTOM_RIGHT:
            return parent.getY2() + coordinate.getY();
        default:
            return parent.getY2() + coordinate.getY();
        }
    }

    protected int getX2(Coordinate coordinate) {
        return getX(coordinate) + width;
    }

    protected int getY2(Coordinate coordinate) {
        return getY(coordinate) + height;
    }

    public int getWidth() {
        return width;
    }

    public Part setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Part setHeight(int height) {
        this.height = height;
        return this;
    }

    public Rect getParent() {
        return parent;
    }

    public Part setParent(Rect parent) {
        this.parent = parent;
        return this;
    }

    public Align getAlign() {
        return align;
    }

    public Part setAlign(Align align) {
        this.align = align;
        return this;
    }

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }

    public Part addCoordinateList(List<Coordinate> coordinateList) {
        this.coordinateList.addAll(coordinateList);
        return this;
    }

    public Part addCoordinateList(Coordinate... coordinates) {
        return addCoordinateList(Arrays.asList(coordinates));
    }
}
