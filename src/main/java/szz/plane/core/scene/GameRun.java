package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.szz.plane.Main;
import cn.szz.plane.core.entity.User;
import cn.szz.plane.core.entity.elem.blast.Blast;
import cn.szz.plane.core.entity.elem.fly.enemy.Enemy;
import cn.szz.plane.core.entity.elem.fly.player.Player;
import cn.szz.plane.core.entity.elem.fly.player.PlayerBullet;
import cn.szz.plane.core.entity.elem.img.GameBg;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.em.StatusEnum;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.core.entity.sound.BgSound;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.core.entity.sound.Sound;
import cn.szz.plane.swing.KeyListenerEvent;
import cn.szz.plane.swing.Listeners;
import cn.szz.plane.swing.listener.KeyReleasedListener;
import cn.szz.plane.swing.listener.MouseMovedListener;
import cn.szz.plane.swing.ui.Window;

public abstract class GameRun extends SceneAdapter implements KeyListenerEvent {

    protected final TimesRecord timesRecord = new TimesRecord();
    protected GameBg bgImage; // 背景图片
    protected BgSound bgSound; // 背景音乐
    protected int level; // 等级
    protected int difficulty; // 难度
    protected Set<Sound> soundSet; // 音效
    protected List<Player> playerList; // 玩家
    protected List<PlayerBullet> playerBulletList; // 玩家子弹
    protected List<Enemy> enemyList; // 敌人
    protected List<Blast> blastList; // 爆炸

    public GameRun(GameBg bgImage, BgSound bgSound) {
        this.bgImage = bgImage;
        this.bgSound = bgSound;
        this.level = 1;
        this.difficulty = 1;
        this.soundSet = new HashSet<>();
        this.playerList = new ArrayList<>();
        this.playerBulletList = new ArrayList<>();
        this.enemyList = new ArrayList<>();
        this.blastList = new ArrayList<>();
    }

    @Override
    public void draw(Graphics g) {
        bgImage.draw(g);
        playerList.forEach(player -> player.draw(g));
        playerBulletList.forEach(playerBullet -> playerBullet.draw(g));
        enemyList.forEach(enemy -> enemy.draw(g));
        blastList.forEach(blast -> blast.draw(g));
    }

    @Override
    public void move() {
        animation();
        sound();
        check();
        produce();
        remove();
    }
    
    @Override
    public void onShow() {
        bgSound.loop();
    }

    @Override
    public void onHide() {
        bgSound.stop();
    }

    @Override
    public void onRemove() {
        bgSound.stop();
    }

    @Override
    public Listeners getListeners() {
        return super.getListeners().add(new KeyReleasedListener(this))
                .add(playerList.stream().map(MouseMovedListener::new).toArray(MouseMovedListener[]::new));
    }

    @Override
    public void keyCallback(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_0 || event.getKeyCode() == KeyEvent.VK_NUMPAD0) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.READY);
        } else if (event.getKeyCode() == KeyEvent.VK_1 || event.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_01_RUN);
        } else if (event.getKeyCode() == KeyEvent.VK_2 || event.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_02_RUN);
        } else if (event.getKeyCode() == KeyEvent.VK_3 || event.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_03_RUN);
        } else if (event.getKeyCode() == KeyEvent.VK_4 || event.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_04_RUN);
        } else if (event.getKeyCode() == KeyEvent.VK_5 || event.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            Window.removeSceneAll();
            Main.OVERALL_RECORD.setCurrStatus(StatusEnum.GAME_LEVEL_05_RUN);
        }
    }

    public User getUser() {
        return new User(1, 1);
    }

    public void sound() {
        Set<Sound> soundCache = soundSet;
        soundSet = new HashSet<>();
        soundCache.forEach(sound -> {
            sound.play();
        });
    }

    public void animation() {
        bgImage.move();
        playerList.forEach(Player::move);
        playerBulletList.forEach(PlayerBullet::move);
        enemyList.forEach(Enemy::move);
        blastList.forEach(Blast::move);
    }

    public void check() {
        playerList.forEach(player -> {
            enemyList.forEach(enemy -> player.checkHit(enemy));
        });
        playerBulletList.forEach(playerBullet -> {
            enemyList.forEach(enemy -> playerBullet.checkHit(enemy));
        });
        enemyList.forEach(enemy -> {
            playerList.forEach(player -> enemy.checkHit(player));
            playerBulletList.forEach(playerBullet -> enemy.checkHit(playerBullet));
        });
    }

    public void produce() {
        timesRecord.countTimes();
        produceBlast();
        producePlayerBullet();
        produceEnemy();
    }

    protected void produceBlast() {
        playerList.forEach(player -> {
            if (player.isDead()) {
                blastList.add(player.blast());
                soundSet.add(new DefaultSound(SoundPathEnum.PLAYER_BLAST));
            }
        });
        playerBulletList.forEach(playerBullet -> {
            if (playerBullet.isDead()) {
                blastList.add(playerBullet.blast());
//                soundSet.add(new DefaultSound(SoundPathEnum.PLAYER_BULLET_BLAST));
            }
        });
        enemyList.forEach(enemy -> {
            if (enemy.isDead()) {
                blastList.add(enemy.blast());
                soundSet.add(new DefaultSound(SoundPathEnum.PLAYER_BLAST));
            }
        });
    }

    protected void producePlayerBullet() {
        if (timesRecord.getTimes() % 20 == 0) {
            playerList.forEach(player -> playerBulletList.addAll(player.shoot()));
        }
    }

    protected abstract void produceEnemy();

    public void remove() {
        playerList.removeIf(player -> player.isDead() || player.isOut());
        playerBulletList.removeIf(playerBullet -> playerBullet.isDead() || playerBullet.isOut());
        enemyList.removeIf(enemy -> enemy.isDead() || enemy.isOut());
        blastList.removeIf(Blast::isOver);
    }

}
