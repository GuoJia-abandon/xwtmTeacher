package com.guo.util;

/**
 * 类描述：
 *
 * @ClassName ValidationUtil
 * @Description 校验工具类
 * @Author 郭佳
 * @Date 2021/2/28 10:22
 * @Version 1.0
 */
public class ValidationUtil {
	private static final String CELLPHONE_REGEX =  "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

	/** 
	 * @Description: 校验手机号码是否正确
	 * @Param: [java.lang.String]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/28
	 */
	public static boolean CheckCellphone(String cellphone) {
		if (cellphone != null && cellphone.matches(CELLPHONE_REGEX)){
			return true;
		}
		return false;
	}

	/** 
	 * @Description: 校验密码是否正确
	 * @Param: [java.lang.String]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/28
	 */
	public static boolean CheckPassword(String password) {
		if (password != null && password.trim().length() >= 6){
			return true;
		}
		return false;
	}
}