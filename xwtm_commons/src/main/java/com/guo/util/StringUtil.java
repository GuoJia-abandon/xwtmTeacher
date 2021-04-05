package com.guo.util;

import org.aspectj.weaver.ast.Test;

/**
 * 类描述：
 *
 * @ClassName StringUtil
 * @Description 字符校验工具类
 * @Author 郭佳
 * @Date 2021/3/22 16:48
 * @Version 1.0
 */
public class StringUtil {
	public static boolean isNotNull(String text) {
		if (text != null && !"".equals(text.trim())){
			return true;
		} else {
			return false;
		}
	}
}