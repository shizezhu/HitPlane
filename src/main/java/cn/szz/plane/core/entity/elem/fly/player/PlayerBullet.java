package cn.szz.plane.core.entity.elem.fly.player;

import cn.szz.plane.core.entity.elem.blast.Blast;
import cn.szz.plane.core.entity.elem.fly.Fly;
import cn.szz.plane.core.entity.elem.fly.enemy.Enemy;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.paint.CoordinateImage;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;

public class PlayerBullet extends Fly {

    protected final TimesRecord timesRecord = new TimesRecord();

    public Player player; // 所属玩家

    public PlayerBullet(CoordinateImage image, int life, int damage, Player player) {
        super(image, life, damage);
        this.player = player;
    }

    @Override
    public void move() {
        if (timesRecord.getTimes(true) % 1 == 0) { 
            rect.setY(rect.getY() - 5);
        }
    }

    @Override
    public void checkHit(Fly fly) {
        if (rect.isHit(fly.getRect())) {
            subtractLife(fly.getDamage());
            player.addScore(((Enemy) fly).getScoreValue());
        }
    }

    @Override
    public Blast blast() {
        return new Blast(rect, new Image[] {
                new Image(ImageEnum.PLAYER_BULLET_BLAST_01),
                new Image(ImageEnum.PLAYER_BULLET_BLAST_02)
        }, 10);
    }

}
