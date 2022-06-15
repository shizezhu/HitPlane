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
import cn.szz.plane.core.entity.elem.ItemMover;
import cn.szz.plane.core.entity.elem.Player;
import cn.szz.plane.core.entity.elem.PlayerBullet;
import cn.szz.plane.core.entity.em.ImageEnum;
import cn.szz.plane.core.entity.em.SceneNameEnum;
import cn.szz.plane.core.entity.em.SoundPathEnum;
import cn.szz.plane.core.entity.paint.Image;
import cn.szz.plane.core.entity.record.TimesRecord;
import cn.szz.plane.core.entity.sound.DefaultSound;
import cn.szz.plane.core.entity.sound.Sound;
import cn.szz.plane.ui.Window;
import cn.szz.plane.ui.event.MouseListenerEvent;
import cn.szz.plane.ui.listener.MouseEnteredListener;
import cn.szz.plane.ui.listener.MouseExitedListener;
import cn.szz.plane.ui.listener.MouseMovedListener;
import cn.szz.plane.ui.listener.MouseReleasedListener;

public abstract class GameRun extends Scene implements MouseListenerEvent {

	protected static enum Status {
		NONE, READY, RUN, BOSS, PAUSE, OVER
	}

	private final TimesRecord timesRecord = new TimesRecord(); // 时间记录器
	protected Status status; // 状态
	protected GameBg bgImage; // 背景图片
	protected Image gamePauseImage; // 游戏暂停图片
	protected Image gameOverImage; // 游戏结束图片
	protected Sound bgSound; // 背景音乐
	protected List<Player> playerList; // 玩家
	protected List<PlayerBullet> playerBulletList; // 玩家子弹
	protected List<Enemy> enemyList; // 敌人
	protected List<Blast> blastList; // 爆炸
	protected List<ItemMover> itemList; // 道具
	protected Set<Sound> soundSet; // 音效

	public GameRun(SceneNameEnum name) {
		super(name);
		init();
	}

	protected void init() {
		this.status = Status.NONE;
		this.gamePauseImage = new Image(ImageEnum.GAME_PAUSE, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight());
		this.gameOverImage = new Image(ImageEnum.GAME_OVER, 0, 0, UIConfig.INSTANCE.getWindowWidth(),
				UIConfig.INSTANCE.getWindowHeight());
		this.playerList = new ArrayList<>();
		this.playerBulletList = new ArrayList<>();
		this.enemyList = new ArrayList<>();
		this.blastList = new ArrayList<>();
		this.itemList = new ArrayList<>();
		this.soundSet = new HashSet<>();
	}

	@Override
	public void refresh(Graphics g) {
		timesRecord.plusRefreshTimes();
		status();
		animation();
		move();
		hit();
		produce();
		remove();
		sound();
		draw(g);
	}

	protected void status() {
		if (timesRecord.getRefreshTimes() == 500) {
			setStatus(Status.READY);
		} else if (timesRecord.getRefreshTimes() == 1500) {
			setStatus(Status.RUN);
		}
		if (playerList.isEmpty()) {
			setStatus(Status.OVER);
		}
	}

	protected void animation() {
		playerList.forEach(Player::animation);
		enemyList.forEach(Enemy::animation);
		blastList.forEach(Blast::animation);
	}

	protected void move() {
		if (status == Status.PAUSE) {
			return;
		}
		bgImage.move();
		playerList.forEach(Player::move);
		playerBulletList.forEach(PlayerBullet::move);
		enemyList.forEach(Enemy::move);
		itemList.forEach(ItemMover::move);
	}

	protected void hit() {
		if (status != Status.RUN) {
			return;
		}
		itemList.forEach(item -> {
			playerList.forEach(player -> {
				item.checkHit(player);
				player.checkHit(item);
			});
		});
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

	protected void produce() {
		if (status != Status.RUN) {
			return;
		}
		produceItem();
		produceBlast();
		producePlayerBullet();
		produceEnemy(timesRecord.getRefreshTimes());
	}

	protected void produceItem() {
		enemyList.forEach(enemy -> {
			if (enemy.isDead()) {
				itemList.addAll(enemy.item());
			}
		});
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

	protected void remove() {
		playerList.removeIf(player -> player.isDead());
		playerBulletList.removeIf(playerBullet -> playerBullet.isDead() || playerBullet.isOut());
		enemyList.removeIf(enemy -> enemy.isDead() || enemy.isOut());
		itemList.removeIf(item -> item.isDead() || item.isOut());
		blastList.removeIf(blast -> blast.isOver());
	}

	protected void sound() {
		playerList.forEach(player -> player.sound());
		Set<Sound> soundCache = soundSet;
		soundSet = new HashSet<>();
		soundCache.forEach(sound -> {
			sound.play();
		});
	}

	protected void draw(Graphics g) {
		bgImage.draw(g);
		blastList.forEach(blast -> blast.draw(g));
		playerList.forEach(player -> player.draw(g));
		itemList.forEach(item -> item.draw(g));
		enemyList.forEach(enemy -> enemy.draw(g));
		playerBulletList.forEach(playerBullet -> playerBullet.draw(g));
		if (status == Status.PAUSE) {
			gamePauseImage.draw(g);
		} else if (status == Status.OVER) {
			gameOverImage.draw(g);
		}
	}

	protected void setStatus(Status status) {
		if (status == this.status) {
			return;
		}
		if (status == Status.NONE) {
			Window.INSTANCE.showScene(new Ready());
		} else if (status == Status.READY) {
			this.status = Status.READY;
			soundSet.add(new DefaultSound(SoundPathEnum.GAME_READY));
		} else if (status == Status.RUN) {
			this.status = Status.RUN;
		} else if (status == Status.BOSS) {
			this.status = Status.BOSS;
		} else if (status == Status.PAUSE) {
			this.status = Status.PAUSE;
		} else if (status == Status.OVER) {
			this.status = Status.OVER;
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
			setStatus(Status.RUN);
		} else if (event.getID() == MouseEvent.MOUSE_EXITED && status == Status.RUN) {
			setStatus(Status.PAUSE);
		} else if (event.getID() == MouseEvent.MOUSE_RELEASED && status == Status.OVER) {
			setStatus(Status.NONE);
		}
	}
}
