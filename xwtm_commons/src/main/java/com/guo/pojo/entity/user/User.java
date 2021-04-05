package com.guo.pojo.entity.user;

import com.guo.base.pojo.entity.baseEntity;
import com.guo.pojo.entity.department.Course;
import com.guo.pojo.entity.department.Department;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName User
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 20:25
 * @Version 1.0
 */
public class User extends baseEntity {
	private static final long serialVersionUID = -4010682307308809612L;
	private String id;                            //主键
	private String name;                          //用户姓名
	private String cellphone;                     //手机号码
	private String password;                      //密码
	private String idCard;                        //身份证号码
	private String avatar;                        //用户头像
	private String email;                         //电子邮件
	private String education;                     //学历
	private String address;                       //家庭住址
	private Integer sex;                           //性别
	private Department department;                //系别
	private Role role;                            //角色信息
	private List<Course> courseList;              //课程信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}