package com.guo.pojo.entity.department;

import com.guo.base.pojo.entity.baseEntity;

import java.util.List;

/**
 * 类描述：院校信息
 *
 * @ClassName Courtyard
 * @Description 院校信息
 * @Author 郭佳
 * @Date 2021/3/25 17:19
 * @Version 1.0
 */
public class Courtyard extends baseEntity {
	private static final long serialVersionUID = -1745122625163266894L;
	private String id;                       //主键
	private String text;                     //文本信息
	private String code;                     //编码信息
	private List<Department> departmentsLists;    //系别信息

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

	public List<Department> getDepartmentsLists() {
		return departmentsLists;
	}

	public void setDepartmentsLists(List<Department> departmentsLists) {
		this.departmentsLists = departmentsLists;
	}
}