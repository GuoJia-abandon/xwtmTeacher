package com.guo.base.pojo.enums;

import java.io.IOException;
import java.util.Properties;

/**
 * 类描述：
 *
 * @ClassName enumConstant
 * @Description 枚举类工具类
 * @Author 郭佳
 * @Date 2021/3/20 20:07
 * @Version 1.0
 */
 class enumConstant {
	private static final Properties prop = new Properties();

	static {
		try {
			prop.load(enumConstant.class.getClassLoader().getResourceAsStream("enum.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 *<b>系统响应信息：响应成功</b>
	 */
	static final Integer RESP_SUCCESS_CODE = Integer.parseInt(prop.getProperty("resp.success.code"));

	/*
	 *<b>系统响应信息：响应失败</b>
	 */
	static final Integer RESP_ERROR_CODE = Integer.parseInt(prop.getProperty("resp.error.code"));
	
	/*
	 *<b>系统响应信息：响应异常</b>
	 */
	static final Integer RESP_EXCEPTION_CODE = Integer.parseInt(prop.getProperty("resp.exception.code"));
	
	/*
	 *<b>系统响应信息：用户未登录</b>
	 */
	static final Integer RESP_NOLOGIN_CODE = Integer.parseInt(prop.getProperty("resp.nologin.code"));

	/*
	 *<b>系统状态 ：启用</b>
	 */
	static final Integer STATUS_ENABLE = Integer.parseInt(prop.getProperty("status.enable"));

	/*
	 *<b>系统状态 ：禁用</b>
	 */
	static final Integer STATUS_DISENABLE = Integer.parseInt(prop.getProperty("status.disenable"));
}