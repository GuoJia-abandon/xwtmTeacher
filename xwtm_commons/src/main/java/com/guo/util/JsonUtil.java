package com.guo.util;

import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * 类描述：
 *
 * @ClassName JsonUtil
 * @Description json转换工具类
 * @Author 郭佳
 * @Date 2021/2/22 21:45
 * @Version 1.0
 */
public class JsonUtil {

	/**
	 * <b>对象转换为json格式</b>
	 */
	public static String parseToJSON(Object obj){
		//创建JSON对象
		JsonMapper jsonMapper = new JsonMapper();
		try {
			return jsonMapper.writeValueAsString(obj);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "{}";
	}

	/**
	 * <b>json格式转换为对象</b>
	 */
	public static Object parseToObject(String json,Class argclass){
		//创建JSON对象
		JsonMapper jsonMapper = new JsonMapper();
		try {
			return jsonMapper.readValue(json,argclass);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}