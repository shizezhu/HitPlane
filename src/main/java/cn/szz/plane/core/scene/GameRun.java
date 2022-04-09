package cn.szz.plane.core.scene;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.szz.plane.config.UIConfig;
import cn.szz.plane.core.entity.elem.Blast;
import cn.szz.plane.core.entity.elem.Enemy;
import cn.szz.plane.core.entity.elem.GameBg;
import cn.szz.plane.core.entity.elem.Player;
import cn.szz.plane.core.entity.elem.PlayerBullet;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.core.entity.sound.Sound;
import cn.szz.plane.ui.event.MouseListenerEvent;
import cn.szz.plane.ui.listener.MouseEnteredListener;
import cn.szz.plane.ui.listener.MouseExitedListener;
import cn.szz.plane.ui.listener.MouseMovedListener;
import cn.szz.plane.ui.listener.MouseReleasedListener;

public abstract class GameRun extends Scene implements MouseListenerEvent {

	protected static enum Status {
		NONE, READY, RUN, PAUSE, OVER
	}

	private final TimesRecord timesRecord = new TimesRecord();
	protected Status status; // 状态
	protected GameBg bgImage; // 背景图片
	protected Image gamePauseImage; // 游戏暂停图片
	protected Image gameOverImage; // 游戏结束图片
	protected Sound bgSound; // 背景音乐
	protected List<Player> playerList; // 玩家
	protected List<PlayerBullet> playerBulletList; // 玩家子弹
	protected List<Enemy> enemyList; // 敌人
	protected List<Blast> blastList; // 爆炸
	protected Set<Sound> soundSet; // 音效

	public GameRun(SceneNameEnum name, GameBg bgImage, Sound bgSound, List<Player> playerList) {
		super(name);
		this.status = Status.NONE;
		this.bgImage = bgImage;
		this.gamePauseImage = new Image(ImageEnum.GAME_PAUSE, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight());
		this.gameOverImage = new Image(ImageEnum.GAME_OVER, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight());
		this.bgSound = bgSound;
		this.playerList = playerList;
		this.playerBulletList = new ArrayList<>();
		this.enemyList = new ArrayList<>();
		this.blastList = new ArrayList<>();
		this.soundSet = new HashSet<>();
	}

	@Override
	public void refresh(Graphics g) {
		timesRecord.plusRefreshTimes();
		if (timesRecord.getRefreshTimes() == 500) {
			this.status = Status.READY;
			soundSet.add(new DefaultSound(SoundPathEnum.GAME_READY));
		} else if (timesRecord.getRefreshTimes() == 1500) {
			this.status = Status.RUN;
		}
		animation();
		over();
		move();
		hit();
		produce();
		remove();
		sound();
		draw(g);
	}

	protected void animation() {
		playerList.forEach(Player::animation);
		enemyList.forEach(Enemy::animation);
		blastList.forEach(Blast::animation);
	}

	protected void over() {
		if (playerList.isEmpty()) {
			this.status = Status.OVER;
		}
	}

	protected void move() {
		if (status == Status.PAUSE) {
			return;
		}
		bgImage.move();
		playerList.forEach(Player::move);
		playerBulletList.forEach(PlayerBullet::move);
		enemyList.forEach(Enemy::move);
	}

	protected void hit() {
		if (status != Status.RUN) {
			return;
		}
		enemyList.forEach(enemy -> {
			playerList.forEach(player -> {
				enemy.checkHit(player);
				player.checkHit(enemy);
			});
			playerBulletList.forEach(playerBullet -> {
				playerBullet.checkHit(enemy);
				enemy.checkHit(playerBullet);
			});
		});
	}

	public void produce() {
		if (status != Status.RUN) {
			return;
		}
		produceBlast();
		producePlayerBullet();
		produceEnemy(timesRecord.getRefreshTimes());
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
			}
		});
		enemyList.forEach(enemy -> {
			if (enemy.isDead()) {
				blastList.add(enemy.blast());
				soundSet.add(new DefaultSound(SoundPathEnum.ENEMY_BLAST));
			}
		});
	}

	protected void producePlayerBullet() {
		playerList.forEach(player -> playerBulletList.addAll(player.shoot()));
	}

	protected abstract void produceEnemy(int refreshTimes);

	public void remove() {
		playerList.removeIf(player -> player.isDead());
		playerBulletList.removeIf(playerBullet -> playerBullet.isDead());
		enemyList.removeIf(enemy -> enemy.isDead());
		blastList.removeIf(blast -> blast.isOver());
	}

	public void sound() {
		Set<Sound> soundCache = soundSet;
		soundSet = new HashSet<>();
		soundCache.forEach(sound -> {
			sound.play();
		});
	}

	public void draw(Graphics g) {
		bgImage.draw(g);
		playerList.forEach(player -> player.draw(g));
		blastList.forEach(blast -> blast.draw(g));
		enemyList.forEach(enemy -> enemy.draw(g));
		playerBulletList.forEach(playerBullet -> playerBullet.draw(g));
		if (status == Status.PAUSE) {
			gamePauseImage.draw(g);
		} else if (status == Status.OVER) {
			gameOverImage.draw(g);
		}

	}

	@Override
	public void onShow() {
		bgSound.play();
	}

	@Override
	public void onHide() {
		bgSound.stop();
	}

	@Override
	public List<MouseMovedListener> getMouseMovedListener() {
		return playerList.stream().map(MouseMovedListener::new).collect(Collectors.toList());
	}

	@Override
	public List<MouseEnteredListener> getMouseEnteredListener() {
		return Stream.of(this).map(MouseEnteredListener::new).collect(Collectors.toList());
	}

	@Override
	public List<MouseExitedListener> getMouseExitedListener() {
		return Stream.of(this).map(MouseExitedListener::new).collect(Collectors.toList());
	}

	@Override
	public List<MouseReleasedListener> getMouseReleasedListener() {
		return Stream.of(this).map(MouseReleasedListener::new).collect(Collectors.toList());
	}

	@Override
	public void mouseCallback(MouseEvent event) {
		if (event.getID() == MouseEvent.MOUSE_ENTERED && status == Status.PAUSE) {
			this.status = Status.RUN;
		} else if (event.getID() == MouseEvent.MOUSE_EXITED && status == Status.RUN) {
			this.status = Status.PAUSE;
		} else if (event.getID() == MouseEvent.MOUSE_RELEASED && status == Status.OVER) {
			this.status = Status.READY;
		}
	}
}
