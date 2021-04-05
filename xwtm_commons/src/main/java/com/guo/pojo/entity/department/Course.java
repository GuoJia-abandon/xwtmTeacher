package com.guo.pojo.entity.department;

import com.guo.base.pojo.entity.baseEntity;
import com.guo.pojo.entity.user.User;

import java.util.List;

/**
 * 类描述：课程信息实体类
 *
 * @ClassName Course
 * @Description 课程信息实体类
 * @Author 郭佳
 * @Date 2021/3/25 17:25
 * @Version 1.0
 */
public class Course extends baseEntity {
	private static final long serialVersionUID = 3589126055963741872L;
	private String id;                           //主键
	private String text;                         //文本信息
	private String code;                         //编码信息
	private User user;                           //教师信息
	private CourseType courseType;               //课程类型
	private Department department;               //系别信息
	private List<ClassGrade> classGradeLists;    //班级信息集合

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<ClassGrade> getClassGradeLists() {
		return classGradeLists;
	}

	public void setClassGradeLists(List<ClassGrade> classGradeLists) {
		this.classGradeLists = classGradeLists;
	}
}