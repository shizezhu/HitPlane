package cn.szz.plane.core.entity.paint;

/**
 * 坐标
 *
 * @author Shi Zezhu
 * @date 2020年11月23日 下午3:58:45
 */
public class Coordinate {

    protected int x;
    protected int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public Coordinate setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Coordinate setY(int y) {
        this.y = y;
        return this;
    }

}
