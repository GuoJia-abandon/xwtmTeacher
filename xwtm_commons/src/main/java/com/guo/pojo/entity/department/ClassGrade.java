package com.guo.pojo.entity.department;

import com.guo.base.pojo.entity.baseEntity;

import java.util.List;

/**
 * 类描述：班级信息实体类
 *
 * @ClassName Class
 * @Description 班级信息实体类
 * @Author 郭佳
 * @Date 2021/3/25 17:22
 * @Version 1.0
 */
public class ClassGrade extends baseEntity {
	private static final long serialVersionUID = -1542656259644956423L;
	private String id;                           //主键
	private String text;                         //文本信息
	private String code;                         //编码信息
	private Integer classNum;                    //班级人数
	private Department department;               //系别信息
	private List<Course> coursesList;            //课程信息集合

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

	public Integer getClassNum() {
		return classNum;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Course> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<Course> coursesList) {
		this.coursesList = coursesList;
	}
}