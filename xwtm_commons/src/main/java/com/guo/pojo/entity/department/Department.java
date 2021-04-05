package com.guo.pojo.entity.department;

import com.guo.base.pojo.entity.baseEntity;

import java.util.List;

/**
 * 类描述：系别信息
 *
 * @ClassName Department
 * @Description 系别信息
 * @Author 郭佳
 * @Date 2021/3/25 17:21
 * @Version 1.0
 */
public class Department extends baseEntity {
	private static final long serialVersionUID = -3284604813294770027L;
	private String id;                           //主键
	private String text;                         //文本信息
	private String code;                         //编码信息
  	private Courtyard courtyard;                 //对应院校信息
	private List<ClassGrade> classGradesLists;   //对应班级集合

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

	public Courtyard getCourtyard() {
		return courtyard;
	}

	public void setCourtyard(Courtyard courtyard) {
		this.courtyard = courtyard;
	}

	public List<ClassGrade> getClassGradesLists() {
		return classGradesLists;
	}

	public void setClassGradesLists(List<ClassGrade> classGradesLists) {
		this.classGradesLists = classGradesLists;
	}
}