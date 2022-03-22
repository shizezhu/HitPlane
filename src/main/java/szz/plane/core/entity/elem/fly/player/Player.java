package cn.szz.plane.core.entity.elem.fly.player;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Stream;

import cn.szz.plane.core.entity.elem.blast.Blast;
import cn.szz.plane.core.entity.elem.fly.Fly;
import cn.szz.plane.core.entity.paint.CoordinatePart;
import cn.szz.plane.core.entity.paint.Part;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.factory.PlayerBulletFactory;
import cn.szz.plane.factory.PlayerFactory;
import cn.szz.plane.swing.MouseListenerEvent;

public class Player extends Fly implements MouseListenerEvent {

    protected final TimesRecord timesRecord = new TimesRecord();
    protected PlayerFactory playerFactory; // 玩家工厂
    protected int level; // 等级
    protected long scoreCount; // 分数计数
    protected CoordinatePart[] fireParts; // 尾喷图片
    protected int firePartIndex; // 尾喷图片下标
    protected PlayerBulletFactory playerBulletFactory; // 玩家子弹工厂

    public Player(PlayerFactory playerFactory, int level) {
        super(playerFactory.produceImage(level), 3, Integer.MAX_VALUE);
        this.playerFactory = playerFactory;
        this.level = level;
        this.scoreCount = 0;
        this.fireParts = Stream.of(playerFactory.produceFireImages(level))
                .map(fireImage -> new CoordinatePart(fireImage, rect, Part.Align.BOTTOM_CENTER, playerFactory.produceFireCoordinates(level)))
                .toArray(CoordinatePart[]::new);
        this.firePartIndex = 0;
        this.playerBulletFactory = new PlayerBulletFactory(this);
    }

    @Override
    public void move() {
        if (timesRecord.getTimes(true) % 40 == 0) {
            firePartIndex = timesRecord.getTimes() / 40 % fireParts.length;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (fireParts.length > firePartIndex)
            fireParts[firePartIndex].draw(g);
    }

    @Override
    public void mouseCallback(MouseEvent event) {
        rect.setX(event.getX() - rect.getWidth() / 2);
        rect.setY(event.getY() - rect.getHeight() / 2);
    }

    @Override
    public boolean isOut() {
        return false;
    }

    public void addScore(int score) {
        scoreCount += score;
    }

    public List<PlayerBullet> shoot() {
        return playerBulletFactory.produce(1, playerFactory.produceBulletCoordinates(level));
    }

    @Override
    public Blast blast() {
        return super.blast();
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public void setPlayerFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    public PlayerBulletFactory getPlayerBulletFactory() {
        return playerBulletFactory;
    }

    public void setPlayerBulletFactory(PlayerBulletFactory playerBulletFactory) {
        this.playerBulletFactory = playerBulletFactory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(long scoreCount) {
        this.scoreCount = scoreCount;
    }

    public CoordinatePart[] getFireParts() {
        return fireParts;
    }

    public void setFireParts(CoordinatePart[] fireParts) {
        this.fireParts = fireParts;
    }
}
