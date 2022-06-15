package cn.szz.plane;

import java.util.concurrent.TimeUnit;

import cn.szz.plane.core.scene.Ready;
import cn.szz.plane.ui.Window;
import cn.szz.plane.utils.ExecutorUtils;

/**
 * 飞机大战入口
 *
 * @author Shi Zezhu
 * @date 2020年11月16日 下午5:32:11
 */
public class Main {

	public static void main(String[] args) throws Exception {
		try {
			Window.INSTANCE.showScene(new Ready());
			ExecutorUtils.scheduleWithFixedDelay(Window.INSTANCE::refresh, 2, 2, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}