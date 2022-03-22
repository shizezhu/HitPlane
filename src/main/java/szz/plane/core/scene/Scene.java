package cn.szz.plane.core.scene;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.Painter;
import cn.szz.plane.swing.Listeners;

public interface Scene extends Painter, Mover {

    /**
     * 获取鼠标监听
     *
     * @author Shi Zezhu
     * @date 2020年11月21日 上午11:56:48
     * @return
     */
    Listeners getListeners();

    /**
     * 添加回调
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 下午4:24:57
     */
    void onAdd();

    /**
     * 展示回调
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 下午4:25:15
     * @param scene 上一个
     */
    void onShow();

    /**
     * 隐藏回调
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 下午5:03:41
     */
    void onHide();

    /**
     * 移除回调
     *
     * @author Shi Zezhu
     * @date 2020年11月19日 下午4:25:23
     */
    void onRemove();
}
