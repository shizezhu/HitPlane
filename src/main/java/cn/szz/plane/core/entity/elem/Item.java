package cn.szz.plane.core.entity.elem;

import cn.szz.plane.core.Painter;

/**
 * 道具
 * 
 * @author shizezhu
 * @time 2022年4月12日 下午4:42:46
 */
public abstract class Item extends FlyObj implements Painter {

	protected int value; // 价值

	public int getValue() {
		return value;
	}
}
