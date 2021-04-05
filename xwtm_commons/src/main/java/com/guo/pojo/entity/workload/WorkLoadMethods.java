package com.guo.pojo.entity.workload;

import com.guo.base.pojo.entity.baseEntity;

/**
 * 类描述：授课方式实体类信息
 *
 * @ClassName WorkLoadMethods
 * @Description 授课方式实体类信息
 * @Author 郭佳
 * @Date 2021/3/27 18:16
 * @Version 1.0
 */
public class WorkLoadMethods extends baseEntity {
	private static final long serialVersionUID = -29300526698676167L;
	private String id;                     //主键
	private String text;                   //文本信息
	private String code;                   //编码信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}