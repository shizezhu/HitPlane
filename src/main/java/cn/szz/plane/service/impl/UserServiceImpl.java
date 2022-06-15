package cn.szz.plane.service.impl;

import cn.szz.plane.core.entity.User;
import cn.szz.plane.service.UserService;

public class UserServiceImpl implements UserService {

	private static final User USER_DB = new User();

	static {
		USER_DB.setPlayerImageType(1);
		USER_DB.setPlayerFireImageType(1);
		USER_DB.setPlayerBulletImageType(1);
		USER_DB.setMaxScore(0);
		USER_DB.setMaxLevel(1);
	}

	@Override
	public User getUser() {
		return USER_DB;
	}

	@Override
	public void updateMaxScore(int maxScore) {
		User user = getUser();
		if (user.getMaxScore() < maxScore) {
			user.setMaxScore(maxScore);
		}
	}

	@Override
	public void updateMaxLevel(int maxLevel) {
		User user = getUser();
		if (user.getMaxLevel() < maxLevel) {
			user.setMaxLevel(maxLevel);
		}
	}
}
