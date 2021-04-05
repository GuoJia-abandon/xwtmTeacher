package com.guo.pojo.vo;

import com.guo.pojo.entity.department.ClassGrade;
import com.guo.pojo.entity.department.Course;
import com.guo.pojo.entity.department.Courtyard;
import com.guo.pojo.entity.department.Department;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.entity.workload.WorkLoadMethods;
import com.guo.pojo.entity.workload.WorkLoadType;

import java.io.Serializable;

/**
 * 类描述：工作量视图实体类
 *
 * @ClassName WorkLoadVo
 * @Description 工作量视图实体类
 * @Author 郭佳
 * @Date 2021/3/28 12:18
 * @Version 1.0
 */
public class WorkLoadVo implements Serializable {
	private static final long serialVersionUID = 8873091452576080867L;
	private String id;                             //主键
	private Integer classNum;                      //班级人数
	private String remark;                         //备注信息
	private String year;                           //工作年份
	private String period;                         //学时
	private String workLoadType;                   //工作量类型
	private String classGrade;                     //班级信息
	private String course;                         //课程信息
	private String department;                     //系别信息
	private String courtyard;                      //院校信息
	private String workLoadMethods;                //授课方式
	private String user;                           //对应教师

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getClassNum() {
		return classNum;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getWorkLoadType() {
		return workLoadType;
	}

	public void setWorkLoadType(String workLoadType) {
		this.workLoadType = workLoadType;
	}

	public String getClassGrade() {
		return classGrade;
	}

	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourtyard() {
		return courtyard;
	}

	public void setCourtyard(String courtyard) {
		this.courtyard = courtyard;
	}

	public String getWorkLoadMethods() {
		return workLoadMethods;
	}

	public void setWorkLoadMethods(String workLoadMethods) {
		this.workLoadMethods = workLoadMethods;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}