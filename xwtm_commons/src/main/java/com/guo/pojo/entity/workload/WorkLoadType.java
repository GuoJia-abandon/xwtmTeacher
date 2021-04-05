package com.guo.pojo.entity.workload;

import com.guo.base.pojo.entity.baseEntity;

/**
 * 类描述：工作量类型实体类
 *
 * @ClassName WorkLoadType
 * @Description 工作量类型实体类
 * @Author 郭佳
 * @Date 2021/3/26 18:40
 * @Version 1.0
 */
public class WorkLoadType extends baseEntity {
	private static final long serialVersionUID = -5377046336153715430L;
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