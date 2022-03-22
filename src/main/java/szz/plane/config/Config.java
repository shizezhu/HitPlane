package cn.szz.plane.config;

import cn.szz.plane.utils.PropertiesUtils;

public class Config {

    private static final PropertiesUtils propertiesUtils =
            new PropertiesUtils(PropertiesUtils.DEFAULT_PATH1 + "/config", "config.properties");

    public static final Config INSTANCE = new Config();

    static {
    }

    private Config() {
    }

}
