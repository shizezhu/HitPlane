package cn.szz.plane.core.entity.paint;

import java.awt.Graphics;

import cn.szz.plane.core.Painter;
import cn.szz.plane.core.entity.paint.Coordinate;

/**
 * 默认文本
 *
 * @author Shi Zezhu
 * @date 2020年11月17日 下午6:14:40
 */
public class Text extends Coordinate implements Painter {

    protected String content;

    public Text() {
        this(null);
    }

    public Text(String content) {
        this(content, 0, 0);
    }

    public Text(String content, int x, int y) {
        super(x, y);
        this.content = content;
    }

    @Override
    public void draw(Graphics g) {
        if (content != null)
            g.drawString(content, x, y);
    }

    public String getContent() {
        return content;
    }

    public Text setContent(String content) {
        this.content = content;
        return this;
    }
}
