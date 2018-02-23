package cn.szz.shoot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.szz.shoot.entity.Boss;
import cn.szz.shoot.entity.BossBullet;
import cn.szz.shoot.entity.BulletAward;
import cn.szz.shoot.entity.Enemy;
import cn.szz.shoot.entity.Hero;
import cn.szz.shoot.entity.HeroBullet;
import cn.szz.shoot.entity.LifeAward;
import cn.szz.shoot.factory.BossBulltFactory;
import cn.szz.shoot.factory.BossFactory;
import cn.szz.shoot.factory.BulletAwardFactory;
import cn.szz.shoot.factory.EnemyFactory;
import cn.szz.shoot.factory.HeroFactory;
import cn.szz.shoot.factory.LifeAwardFactory;
import cn.szz.shoot.resource.BgResources;
import cn.szz.shoot.utils.CommUtils;


public class Main extends JPanel {

	private static final long serialVersionUID = -5172373439799675252L;
	
	private Hero hero = null;
	private List<HeroBullet> heroBulletList = null;
	private List<Enemy> enemyList = null;
	private List<LifeAward> lifeAwardList = null;
	private List<BulletAward> bulletAwardList = null;
	private List<Boss> bossList = null;
	private List<BossBullet> bossBulletList = null;
	
	private int factoryEnemySpeed = 0;//生产敌机速度
	private int factoryLifeAwardSpeed = 0;//出生命奖励速度
	private int factoryBulletAwardSpeed = 0;//出子弹奖励速度
	private int factoryBossBulletSpeed = 0;//boss出子弹速度
	
	private int enemyYspeed = 1; //敌机y轴速度
	
	private int level = 1;//关
	private int bossLevel = 1; //boss关
	private int score = 0;//得分
	
	private static int state = CommUtils.STATUS_START;
	
	
	public void action() {
		init();//初始化
		MouseAdapter l = new MouseAdapter() {//检测器
			/**监测鼠标移动**/
			public void mouseMoved(MouseEvent e) {
				if(state == CommUtils.STATUS_RUNNING || state == CommUtils.STATUS_BOSS) {//如果是运行状态
					hero.move(e.getX(), e.getY());//调用英雄移动方法，并将鼠标x、y传过去
				}						
			}
			/**检测鼠标单击**/
			public void mouseClicked(MouseEvent e) {
				switch(state) {//判断当前状态
				case CommUtils.STATUS_START://如是是开始
					state = CommUtils.STATUS_RUNNING;//将状态改成运行
					break;
				case CommUtils.STATUS_GAME_OVER://如果是结束
					init();//初始化
					state = CommUtils.STATUS_START;//将状态改成开始
					break;
				}
			}
			
			public void mouseExited(MouseEvent e) {//监测鼠标移出
				if(state == CommUtils.STATUS_RUNNING) {//如果是运行状态
					state = CommUtils.STATUS_PAUSE;//改成暂停
				}
			}
			
			public void mouseEntered(MouseEvent e) {////监测鼠标移入
				if(state == CommUtils.STATUS_PAUSE) {//如果是暂停状态
					state = CommUtils.STATUS_RUNNING;//改成运行
				}				
			}
		};
		this.addMouseListener(l);//装载监听器
		this.addMouseMotionListener(l);//装载监听器任务
		
		Timer timer = new Timer();//创建定时器
		timer.schedule(new TimerTask() {//定时任务，传TimerTask匿名内部类
			public void run() {
				if(state == CommUtils.STATUS_RUNNING) {//如是是运行状态才执行
					level();//等级
					heroBulletAction();//英雄子弹入场
					enemyAction();//敌人入场
					lifeAwardAction();//生命奖励入场
					bulletAwardAction();//子弹奖励入场
					stepAction();//走步
					hitAction();//撞击检测
					blastAction();//爆炸检测
					outOfBoundsAction();//越界检测
					delAction();//死亡删除
					bossStatusAction(); //boss状态
					ganeoverStatusAction();//游戏结束
				} else if (state == CommUtils.STATUS_BOSS) {
					level();//等级
					heroBulletAction();//英雄子弹入场
					bossAction();//boss入场
					bossBulletAction();//boss子弹入场
					lifeAwardAction();//生命奖励入场
					bulletAwardAction();//子弹奖励入场
					stepAction();//走步
					hitAction();//撞击检测
					blastAction();//爆炸检测
					outOfBoundsAction();//越界检测
					delAction();//死亡删除
					runningStatusAction();
					ganeoverStatusAction();//游戏结束
				}
				repaint();//调用paint
			}
		}, 10, 10);//第一个时间为启动时间，第二个是间隔时间
	}
	
	/**
	 * 
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午5:13:56
	 */
	public void init() {
		factoryEnemySpeed = 0;
		factoryLifeAwardSpeed = 0;
		factoryBulletAwardSpeed = 0;
		factoryBossBulletSpeed = 0;
		enemyYspeed = 1;
		level = 1;
		bossLevel = 1;
		score = 0;
		hero = HeroFactory.createHero();//英雄初始化
		heroBulletList = new ArrayList<HeroBullet>();;//英雄子弹初始化
		enemyList = new ArrayList<Enemy>();//敌人初始化
		lifeAwardList = new ArrayList<LifeAward>(); //初始化生命奖励
		bulletAwardList = new ArrayList<BulletAward>(); //初始化子弹奖励
		bossList = new ArrayList<Boss>(); //初始化boss
		bossBulletList = new ArrayList<BossBullet>(); //初始化boss子弹
	}
	
	/**重写画笔**/
	@Override
	public void paint(Graphics g) {
		this.paintBg(g);//画背景
		this.paintScore(g);//画分、命、火力值、等级
		this.paintHero(g);//画英雄
		this.paintHeroBullet(g);//画英雄子弹
		this.paintEnemy(g);//画敌人
		this.paintBoss(g);//画boss
		this.paintBossBullet(g);//画boss子弹
		this.paintLifeAward(g); //画生命奖励
		this.paintBulletAward(g); //画子弹奖励
		this.paintState(g);//画状态
	}
	
	/**
	 * 画背景
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:15:56
	 */
	public void paintBg(Graphics g) {
		switch (bossLevel) {
		case 1:
			g.drawImage(BgResources.bg0, 0, 0, null);
			break;
		case 2:
			g.drawImage(BgResources.bg1, 0, 0, null);
			break;
		case 3:
			g.drawImage(BgResources.bg0, 0, 0, null);
			break;
		case 4:
			g.drawImage(BgResources.bg1, 0, 0, null);
			break;
		case 5:
			g.drawImage(BgResources.bg0, 0, 0, null);
			break;
		case 6:
			g.drawImage(BgResources.bg1, 0, 0, null);
			break;
		case 7:
			g.drawImage(BgResources.bg0, 0, 0, null);
			break;
		case 8:
			g.drawImage(BgResources.bg1, 0, 0, null);
			break;
		case 9:
			g.drawImage(BgResources.bg0, 0, 0, null);
			break;
		case 10:
			g.drawImage(BgResources.bg1, 0, 0, null);
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 画状态
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:16:05
	 */
	public void paintState(Graphics g) {
		switch (state) {//判断当前状态
		case CommUtils.STATUS_START:
			g.drawImage(BgResources.start, 0, 0,null);
			break;
		case CommUtils.STATUS_PAUSE:
			g.drawImage(BgResources.pause, 0, 0, null);
			break;
		case CommUtils.STATUS_GAME_OVER:
			g.drawImage(BgResources.gameover, 0, 0,null);
			break;
		}
	}
	
	/**
	 * 画等级、分、命、火力值
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:42:52
	 */
	public void paintScore(Graphics g) {
		g.setColor(new Color(0xff0000));//改字体颜色
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,25));//改字体、加粗、大小
		g.drawString("得分:" + this.score, 10, 25);//画分，x坐标，y坐标
		g.drawString("生命:" + this.hero.getLife(), 10, 50);// 画生命
		g.drawString("加强:" + this.hero.getBulletLevel(), 10, 75); //画
		g.drawString("等级:" + level, 10, 100); //画等级
	}
	
	
	/**
	 * 画英雄
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:36:22
	 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.getImg(), hero.getX(), hero.getY(), null);
	}	
	
	/**
	 * 画英雄子弹
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:38:43
	 */
	public void paintHeroBullet(Graphics g) {
		for(HeroBullet heroBullet : heroBulletList) {
			g.drawImage(heroBullet.getImg(), heroBullet.getX(), heroBullet.getY(),null);
		}		
	}	
	
	/**
	 * 画敌人
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:41:13
	 */
	public void paintEnemy(Graphics g) {
		for(Enemy enemy : enemyList) {
			g.drawImage(enemy.getImg(), enemy.getX(), enemy.getY(), null);
		}
	}
	
	/**
	 * 画boss
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:05:06
	 */
	public void paintBoss(Graphics g) {
		for(Boss boss : bossList) {
			g.drawImage(boss.getImg(), boss.getX(), boss.getY(), null);
		}
	}
	
	/**
	 * 画boss子弹
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:05:14
	 */
	public void paintBossBullet(Graphics g) {
		for(BossBullet bossBullet : bossBulletList) {
			g.drawImage(bossBullet.getImg(), bossBullet.getX(), bossBullet.getY(), null);
		}
	}
	
	/**
	 * 画生命奖励
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:05:24
	 */
	public void paintLifeAward(Graphics g) {
		for(LifeAward lifeAward : lifeAwardList) {
			g.drawImage(lifeAward.getImg(), lifeAward.getX(), lifeAward.getY(), null);
		}
	}
	
	/**
	 * 画子弹奖励
	 * 
	 * @param g
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:05:39
	 */
	public void paintBulletAward(Graphics g) {
		for(BulletAward bulletAward : bulletAwardList) {
			g.drawImage(bulletAward.getImg(), bulletAward.getX(), bulletAward.getY(), null);
		}
	}
	
	/**
	 * 等级
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:53:26
	 */
	public void level() {
		
		if (this.score >= 6000) {
			this.factoryEnemySpeed = 1;
			this.level = 10;
			this.enemyYspeed = 12;
			this.factoryLifeAwardSpeed = 6000;
			this.factoryBulletAwardSpeed = 3000;
			this.factoryBossBulletSpeed = 20;
		} else if (this.score >= 4500) {
			this.factoryEnemySpeed = 3;
			this.level = 9;
			this.enemyYspeed = 11;
			this.factoryLifeAwardSpeed = 6000;
			this.factoryBulletAwardSpeed = 3000;
			this.factoryBossBulletSpeed = 40;
		} else if (this.score >= 3500) {
			this.factoryEnemySpeed = 5;
			this.level = 8;
			this.enemyYspeed = 10;
			this.factoryLifeAwardSpeed = 6000;
			this.factoryBulletAwardSpeed = 3000;
			this.factoryBossBulletSpeed = 60;
		} else if (this.score >= 2600) {
			this.factoryEnemySpeed = 10;
			this.level = 7;
			this.enemyYspeed = 9;
			this.factoryLifeAwardSpeed = 4000;
			this.factoryBulletAwardSpeed = 2000;
			this.factoryBossBulletSpeed = 80;
		} else if (this.score >= 1800) {
			this.factoryEnemySpeed = 15;
			this.level = 6;
			this.enemyYspeed = 8;
			this.factoryLifeAwardSpeed = 4000;
			this.factoryBulletAwardSpeed = 2000;
			this.factoryBossBulletSpeed = 100;
		} else if (this.score >= 1300) {
			this.factoryEnemySpeed = 20;
			this.level = 5;
			this.enemyYspeed = 7;
			this.factoryLifeAwardSpeed = 4000;
			this.factoryBulletAwardSpeed = 2000;
			this.factoryBossBulletSpeed = 120;
		} else if (this.score >= 800) {
			this.factoryEnemySpeed = 25;
			this.level = 4;
			this.enemyYspeed = 6;
			this.factoryLifeAwardSpeed = 4000;
			this.factoryBulletAwardSpeed = 2000;
			this.factoryBossBulletSpeed = 140;
		} else if (this.score >= 400) {
			this.factoryEnemySpeed = 30;
			this.level = 3;
			this.enemyYspeed = 5;
			this.factoryLifeAwardSpeed = 4000;
			this.factoryBulletAwardSpeed = 2000;
			this.factoryBossBulletSpeed = 160;
		} else if (this.score >= 150) {
			this.factoryEnemySpeed = 40;
			this.level = 2;
			this.enemyYspeed = 4;
			this.factoryLifeAwardSpeed = 2000;
			this.factoryBulletAwardSpeed = 1000;
			this.factoryBossBulletSpeed = 180;
		} else {
			this.factoryEnemySpeed = 50;
			this.level = 1;
			this.enemyYspeed = 3;
			this.factoryLifeAwardSpeed = 2000;
			this.factoryBulletAwardSpeed = 1000;
			this.factoryBossBulletSpeed = 200;
		}
	}
	
	/**
	 * 英雄子弹入场
	 */
	int heroBulletActionIndex = 1;
	public void heroBulletAction() {
		if (this.heroBulletActionIndex ++ % 20 != 0) {
			return;
		}
		this.heroBulletList.addAll(this.hero.shoot());
	}
	
	/**
	 * 敌人入场
	 */
	int enemyActionIndex = 1;
	public void enemyAction() {
		if (this.enemyActionIndex ++ % this.factoryEnemySpeed != 0) {
			return;
		}
		this.enemyList.add(EnemyFactory.createEnemy(enemyYspeed));
	}
	
	/**
	 * 生命奖励入场
	 */
	int lifeAwardActionIndex = 1;
	public void lifeAwardAction() {
		if (this.lifeAwardActionIndex ++ % this.factoryLifeAwardSpeed != 0) {
			return;
		}
		this.lifeAwardList.add(LifeAwardFactory.CreateLifeAward());
	}
	
	/**
	 * 子弹奖励入场
	 */
	int bulletAwardActionIndex = 1;
	public void bulletAwardAction() {
		if (this.bulletAwardActionIndex ++ % this.factoryBulletAwardSpeed != 0) {
			return;
		}
		this.bulletAwardList.add(BulletAwardFactory.CreateHeroBullet());
	}
	
	/**
	 * boss入场
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:52:01
	 */
	public void bossAction() {
		if (bossList.size() >= 1) {
			return;
		}
		bossList.add(BossFactory.createBoss());
	}
	
	/**
	 * boss子弹入场
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午3:52:34
	 */
	int bossBulletActionIndex = 0;
	public void bossBulletAction() {
		bossBulletActionIndex ++;
		if (this.bossBulletActionIndex % factoryBossBulletSpeed != 0) {
			return;
		}
		for (Boss boss : bossList) {
			this.bossBulletList.add(BossBulltFactory.createBossBullet0(boss));
		}
	}
	
	/**
	 * 飞行物走步
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月12日 下午6:57:05
	 */
	public void stepAction() {
		this.hero.action();
		for (HeroBullet heroBullet : heroBulletList) {
			heroBullet.action();
		}
		for (Enemy enemy : enemyList) {
			enemy.action();
		}
		for (Boss boss : bossList) {
			boss.action();
		}
		for (BossBullet bossBullet : bossBulletList) {
			bossBullet.action();
		}
		for (LifeAward lifeAward : lifeAwardList) {
			lifeAward.action();
		}
		for (BulletAward bulletAward : bulletAwardList) {
			bulletAward.action();
		}
	}
	
	/**
	 * 撞击
	 * 
	 * @author Shi Zezhu
	 * @date 2018年1月15日 下午4:01:16
	 */
	public void hitAction() {
		for (Enemy enemy : enemyList) {
			this.hero.hit(enemy);
			enemy.hit(this.hero);
			for (HeroBullet heroBullet : heroBulletList) {
				heroBullet.hit(enemy);
				enemy.hit(heroBullet);
			}
		}
		for (Boss boss : bossList) {
			this.hero.hit(boss);
			for (HeroBullet heroBullet : heroBulletList) {
				heroBullet.hit(boss);
				boss.hit(heroBullet);
			}
		}
		for (BossBullet bossBullet : bossBulletList) {
			this.hero.hit(bossBullet);
			bossBullet.hit(this.hero);
		}
		for (LifeAward lifeAward : lifeAwardList) {
			for (HeroBullet heroBullet : heroBulletList) {
				heroBullet.hit(lifeAward);
				lifeAward.hit(heroBullet);
			}
		}
		for (BulletAward bulletAward : bulletAwardList) {
			for (HeroBullet heroBullet : heroBulletList) {
				heroBullet.hit(bulletAward);
				bulletAward.hit(heroBullet);
			}
		}
	}
	
	public void blastAction() {
		this.hero.blast();
		for (Enemy enemy : enemyList) {
			enemy.blast();
		}
		for (Boss boss : bossList) {
			boss.blast();	
		}
		for (HeroBullet heroBullet : heroBulletList) {
			heroBullet.blast();
		}
	}
	
	public void outOfBoundsAction() {
		for (HeroBullet heroBullet : heroBulletList) {
			heroBullet.outOfBounds();
		}
		for (BossBullet bossBullet : bossBulletList) {
			bossBullet.outOfBounds();
		}
		for (Enemy enemy : enemyList) {
			enemy.outOfBounds();
		}
		for (LifeAward lifeAward : lifeAwardList) {
			lifeAward.outOfBounds();
		}
		for (BulletAward bulletAward : bulletAwardList) {
			bulletAward.outOfBounds();
		}
	}
	
	public void delAction() {
		Iterator<HeroBullet> heroBulletIt = heroBulletList.iterator();
		while (heroBulletIt.hasNext()) {
			HeroBullet heroBullet = heroBulletIt.next();
			if (heroBullet.getIsDead()) {
				heroBulletIt.remove();
			}
		}
		
		Iterator<BossBullet> bossBulletIt = bossBulletList.iterator();
		while (bossBulletIt.hasNext()) {
			BossBullet bossBullet = bossBulletIt.next();
			if (bossBullet.getIsDead()) {
				bossBulletIt.remove();
			}
		}
		
		Iterator<Enemy> enemyIt = enemyList.iterator();
		while (enemyIt.hasNext()) {
			Enemy enemy = enemyIt.next();
			if (enemy.getIsDead()) {
				this.score += enemy.getScoreAwardValue();
				enemyIt.remove();
			}
		}
		
		Iterator<LifeAward> lifeAwardIt = lifeAwardList.iterator();
		while (lifeAwardIt.hasNext()) {
			LifeAward lifeAward = lifeAwardIt.next();
			if (lifeAward.getIsDead()) {
				this.hero.setLife(this.hero.getLife() + lifeAward.getValue());
				lifeAwardIt.remove();
			}
		}
		
		Iterator<BulletAward> bulletAwardIt = bulletAwardList.iterator();
		while (bulletAwardIt.hasNext()) {
			BulletAward bulletAward = bulletAwardIt.next();
			if (bulletAward.getIsDead()) {
				this.hero.setBulletLevel(this.hero.getBulletLevel() + bulletAward.getValue());
				bulletAwardIt.remove();
			}
		}
	}
	
	public void bossStatusAction() {
		if (this.level > this.bossLevel) {
			state = CommUtils.STATUS_BOSS;
			enemyList.clear();
		}
	}
	
	public void runningStatusAction() {
		boolean flag = true;
		for (Boss boss : bossList) {
			if (!boss.getIsDead()) {
				flag = false;
			}
		}
		if (flag) {
			state = CommUtils.STATUS_RUNNING;
			bossList.clear();
			bossBulletList.clear();
			this.bossLevel ++;
		}
	}
	
	public void ganeoverStatusAction() {
		if (this.hero.getIsDead()) {
			state = CommUtils.STATUS_GAME_OVER;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("飞机大战-石则柱制作");//创建窗体
		Main game = new Main();//创建面板
		frame.add(game);//将面板装入窗体
		frame.setSize(CommUtils.WIDTH, CommUtils.HEIGHT);//窗体大小
		frame.setAlwaysOnTop(true);//是否置顶
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭状态，点关闭是否关闭程序
		frame.setLocationRelativeTo(null);//初始位置居中 
		frame.setVisible(true);//1.设置窗体可见，2.调调用paint方法
		
		game.action();
	}

}
