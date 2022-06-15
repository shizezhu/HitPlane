package cn.szz.plane.core.entity.em;

import cn.szz.plane.utils.CheckUtils;

/**
 * 场景名称
 * 
 * @author shizezhu
 * @time 2022年4月12日 上午11:00:38
 */
public enum SceneNameEnum {

	READY("READY"),
	GAME_LEVEL_01("GAME_LEVEL_01"),
	GAME_LEVEL_02("GAME_LEVEL_02"),
	GAME_LEVEL_03("GAME_LEVEL_03"),
	GAME_LEVEL_04("GAME_LEVEL_04"),
	GAME_LEVEL_05("GAME_LEVEL_05");
	
	private String value;

	private SceneNameEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static SceneNameEnum getByValue(String value) {
		for (SceneNameEnum v : SceneNameEnum.values()) {
			if (CheckUtils.isEquals(v.getValue(), value)) {
				return v;
			}
		}
		return null;
	}
}
