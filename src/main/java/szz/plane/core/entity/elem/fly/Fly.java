package cn.szz.plane.core.entity.elem.fly;

import cn.szz.plane.core.Mover;
import cn.szz.plane.core.entity.elem.Elem;
import cn.szz.plane.core.entity.elem.blast.Blast;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.paint.Rect;

public abstract class Fly extends Elem implements Mover {

    protected int oLife; // 原始生命值
    protected int rLife; // 剩余生命值
    protected int damage; // 伤害值

    public Fly(Rect rect, int life, int damage) {
        super(rect);
        this.oLife = life;
        this.rLife = life;
        this.damage = damage;
    }

    /**
     * 检测碰撞
     *
     * @author Shi Zezhu
     * @date 2020年12月5日 下午6:22:22
     * @param fly
     * @return
     */
    public void checkHit(Fly fly) {
        if (rect.isHit(fly.getRect())) {
            subtractLife(fly.getDamage());
        }
    }

    /**
     * 检测出界
     *
     * @author Shi Zezhu
     * @date 2020年11月24日 下午12:03:23
     * @return
     */
    public boolean isOut() {
        return rect.isOut();
    }

    /**
     * 是否死亡
     *
     * @author Shi Zezhu
     * @date 2020年11月24日 下午12:03:23
     * @return
     */
    public boolean isDead() {
        return rLife <= 0;
    }

    /**
     * 设置死亡
     *
     * @author Shi Zezhu
     * @date 2020年12月11日 下午3:54:02
     */
    public void dead() {
        rLife = Integer.MIN_VALUE;
    }

    /**
     * 减掉生命
     *
     * @author Shi Zezhu
     * @date 2020年12月11日 下午3:54:13
     * @param num
     */
    public void subtractLife(int num) {
        rLife -= num;
    }

    public Blast blast() {
        return new Blast(rect, new Image[] {
                new Image(ImageEnum.BLAST_01),
                new Image(ImageEnum.BLAST_02),
                new Image(ImageEnum.BLAST_03),
                new Image(ImageEnum.BLAST_04),
                new Image(ImageEnum.BLAST_05),
                new Image(ImageEnum.BLAST_06),
                new Image(ImageEnum.BLAST_07),
                new Image(ImageEnum.BLAST_08),
                new Image(ImageEnum.BLAST_09),
                new Image(ImageEnum.BLAST_10),
        }, 10);
    }

    public int getoLife() {
        return oLife;
    }

    public void setoLife(int oLife) {
        this.oLife = oLife;
    }

    public int getrLife() {
        return rLife;
    }

    public void setrLife(int rLife) {
        this.rLife = rLife;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
