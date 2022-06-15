package cn.szz.plane.service;

import cn.szz.plane.core.entity.User;

public interface UserService {

	/**
	 * 获取用户数据
	 * 
	 * @author shizezhu
	 * @time 2022年4月12日 上午10:38:07
	 * @return
	 */
	User getUser();

	/**
	 * 更新最高得分
	 * 
	 * @author shizezhu
	 * @time 2022年4月12日 上午10:53:24
	 * @param maxScore
	 */
	void updateMaxScore(int maxScore);

	/**
	 * 更新最高关卡
	 * 
	 * @author shizezhu
	 * @time 2022年4月12日 上午10:53:41
	 * @param maxLevel
	 */
	void updateMaxLevel(int maxLevel);
}
