package com.guo.pojo.entity.department;

import com.guo.base.pojo.entity.baseEntity;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * 类描述：课程类型实体类
 *
 * @ClassName CourseType
 * @Description 课程类型实体类
 * @Author 郭佳
 * @Date 2021/3/26 11:11
 * @Version 1.0
 */
public class CourseType extends baseEntity {
	private static final long serialVersionUID = -8114959415322714045L;
	private String id;                        //主键
	private String text;                      //文本信息
	private String code;                      //编码信息
	private CourseType parent;                //父级课程类型
	private List<CourseType> courseTypeLists; //子级课程类型

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

	public CourseType getParent() {
		return parent;
	}

	public void setParent(CourseType parent) {
		this.parent = parent;
	}

	public List<CourseType> getCourseTypeLists() {
		return courseTypeLists;
	}

	public void setCourseTypeLists(List<CourseType> courseTypeLists) {
		this.courseTypeLists = courseTypeLists;
	}
}