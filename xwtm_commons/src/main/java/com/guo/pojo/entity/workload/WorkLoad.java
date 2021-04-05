package com.guo.pojo.entity.workload;

import com.guo.base.pojo.entity.baseEntity;
import com.guo.pojo.entity.department.ClassGrade;
import com.guo.pojo.entity.department.Course;
import com.guo.pojo.entity.department.Courtyard;
import com.guo.pojo.entity.department.Department;
import com.guo.pojo.entity.user.User;

import java.util.List;

/**
 * 类描述：工作量实体类
 *
 * @ClassName Workload
 * @Description 工作量实体类
 * @Author 郭佳
 * @Date 2021/3/28 9:22
 * @Version 1.0
 */
public class WorkLoad extends baseEntity {
	private static final long serialVersionUID = -7406588033076646057L;
	private String id;                             //主键
	private Integer classNum;                      //班级人数
	private String remark;                         //备注信息
	private String year;                           //工作年份
	private String period;                         //学时
	private WorkLoadType workLoadType;             //工作量类型
	private ClassGrade classGrade;                 //班级信息
	private Course course;                         //课程信息
	private Department department;                 //系别信息
	private Courtyard courtyard;                   //院校信息
	private WorkLoadMethods workLoadMethods;       //授课方式
	private User user;                             //对应教师

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

	public WorkLoadType getWorkLoadType() {
		return workLoadType;
	}

	public void setWorkLoadType(WorkLoadType workLoadType) {
		this.workLoadType = workLoadType;
	}

	public ClassGrade getClassGrade() {
		return classGrade;
	}

	public void setClassGrade(ClassGrade classGrade) {
		this.classGrade = classGrade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Courtyard getCourtyard() {
		return courtyard;
	}

	public void setCourtyard(Courtyard courtyard) {
		this.courtyard = courtyard;
	}

	public WorkLoadMethods getWorkLoadMethods() {
		return workLoadMethods;
	}

	public void setWorkLoadMethods(WorkLoadMethods workLoadMethods) {
		this.workLoadMethods = workLoadMethods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}