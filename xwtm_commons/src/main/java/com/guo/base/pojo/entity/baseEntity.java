package com.guo.base.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：
 *
 * @ClassName baseEntity
 * @Description 基础实体类信息
 * @Author 郭佳
 * @Date 2021/3/20 19:49
 * @Version 1.0
 */
public class baseEntity implements Serializable {
	private static final long serialVersionUID = -6911224261658410604L;
	private Integer status;                //状态
	private String createUser;             //创建人
	private Date createTime;               //创建时间
	private String updateUser;             //修改者
	private Date updateTime;               //更新时间

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}