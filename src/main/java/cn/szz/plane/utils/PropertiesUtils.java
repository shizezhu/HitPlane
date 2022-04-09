package cn.szz.plane.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

import cn.szz.plane.exception.CheckException;

/**
 * Properties工具类
 * 
 * @author Shi Zezhu
 * @date 2016年5月25日 上午10:31:12
 */
public class PropertiesUtils {

	/**
	 * 字符集
	 */
	private static final String CHARSET = "UTF-8";

	/**
	 * 默认地址1
	 */
	public static final String DEFAULT_PATH1 = PropertiesUtils.class.getResource("/").getPath();

	/**
	 * 默认地址2
	 */
	public static final String DEFAULT_PATH2 = System.getProperty("user.dir");

	/**
	 * 默认文件名
	 */
	public static final String DEFAULT_FILE_NAME = "application.properties";

	/**
	 * 目录
	 */
	private String path;

	/**
	 * 文件名
	 */
	private String fileName = DEFAULT_FILE_NAME;

	/**
	 * Properties对象
	 */
	private Properties prop;

	public PropertiesUtils() {
		this.path = DEFAULT_PATH1;
		this.prop = getProperties(path, fileName);
		if (prop == null) {
			this.path = DEFAULT_PATH2;
			this.prop = getProperties(path, fileName);
		}
	}

	public PropertiesUtils(String fileName) {
		this.fileName = fileName;
		this.path = DEFAULT_PATH1;
		this.prop = getProperties(path, fileName);
		if (prop == null) {
			this.path = DEFAULT_PATH2;
			this.prop = getProperties(path, fileName);
		}
	}

	public PropertiesUtils(String path, String fileName) {
		this.path = path;
		this.fileName = fileName;
		this.prop = getProperties(path, fileName);
	}

	public String getPath() {
		return path;
	}

	public PropertiesUtils setPath(String path) {
		this.path = path;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public PropertiesUtils setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public Properties getProp() {
		return prop;
	}

	public PropertiesUtils setProp(Properties prop) {
		this.prop = prop;
		return this;
	}

	/**
	 * 获取Properties对象
	 *
	 * @author Shi Zezhu
	 * @date 2018年3月27日 下午4:32:43
	 * @param path
	 * @param fileName
	 * @param charset
	 * @return
	 * @throws CheckException
	 */
	private Properties getProperties(String path, String fileName) throws CheckException {
		if (CheckUtils.isEmpty(path) || CheckUtils.isEmpty(fileName)) {
			return null;
		}
		File propFile = new File(path, fileName);
		if (!propFile.exists()) {
			return null;
		}
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(propFile), CHARSET)) {
			Properties prop = new Properties();
			prop.load(isr);
			return prop;
		} catch (Exception e) {
			throw new CheckException("读取Properties文件异常", e);
		}
	}

	/**
	 * 获取单个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月23日 下午6:07:45
	 * @param key
	 * @return
	 * @throws CheckException
	 */
	public String get(String key) throws CheckException {
		return CheckUtils.ifIsTrueOrElseGet(CheckUtils.isEmpty(key) || CheckUtils.isNull(prop), (String) null,
				() -> prop.getProperty(key));
	}

	/**
	 * 获取多个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月23日 下午6:07:50
	 * @param keys
	 * @return
	 * @throws CheckException
	 */
	public Map<String, String> get(String... keys) throws CheckException {
		Map<String, String> map = new HashMap<>();
		CheckUtils.ifIsFalse(CheckUtils.isEmpty(keys) || CheckUtils.isNull(prop), () -> Stream.of(keys)
				.forEach(key -> CheckUtils.ifNotNull(prop.getProperty(key), value -> map.put(key, value))));
		return map;
	}

	/**
	 * 获取单个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:32
	 * @param fileName
	 * @param key
	 * @return
	 * @throws CheckException
	 */
	public static String getValue(String key) throws CheckException {
		return new PropertiesUtils().get(key);
	}

	/**
	 * 获取多个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:41
	 * @param fileName
	 * @param keys
	 * @return
	 * @throws CheckException
	 */
	public static Map<String, String> getValue(String... keys) throws CheckException {
		return new PropertiesUtils().get(keys);
	}

	/**
	 * 获取单个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:32
	 * @param fileName
	 * @param key
	 * @return
	 * @throws CheckException
	 */
	public static String getValue(String fileName, String key) throws CheckException {
		return new PropertiesUtils(fileName).get(key);
	}

	/**
	 * 获取多个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:41
	 * @param fileName
	 * @param keys
	 * @return
	 * @throws CheckException
	 */
	public static Map<String, String> getValue(String fileName, String... keys) throws CheckException {
		return new PropertiesUtils(fileName).get(keys);
	}

	/**
	 * 获取单个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:35
	 * @param path
	 * @param fileName
	 * @param key
	 * @return
	 * @throws CheckException
	 */
	public static String getValue(String path, String fileName, String key) throws CheckException {
		return new PropertiesUtils(path, fileName).get(key);
	}

	/**
	 * 获取多个
	 *
	 * @author Shi Zezhu
	 * @date 2018年8月27日 下午9:06:44
	 * @param path
	 * @param fileName
	 * @param keys
	 * @return
	 * @throws CheckException
	 */
	public static Map<String, String> getValue(String path, String fileName, String... keys) throws CheckException {
		return new PropertiesUtils(path, fileName).get(keys);
	}
}
