package com.guo.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 类描述：
 *
 * @ClassName ConstantUtil
 * @Description 系统常量类工具类
 * @Author 郭佳
 * @Date 2021/3/20 19:59
 * @Version 1.0
 */
public class ConstantUtil {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(ConstantUtil.class.getClassLoader().getResourceAsStream("system.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * <b>分页信息：当前页数</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(prop.getProperty("page.num"));

	/*
	 * <b>分页信息：每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(prop.getProperty("page.size"));

	/*
	 * <b>设置jwt token 密钥</b>
	 */
	public static final String SECRET_KEY = prop.getProperty("secret.key");

	/*
	 * <b>设置jwt token 过期时间</b>
	 */
	public static final Integer EXPIRE_MINUTE = Integer.parseInt(prop.getProperty("expire.minute"));

}