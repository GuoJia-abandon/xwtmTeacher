package com.guo.pojo.vo;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @ClassName UserLoginVo
 * @Description 用户登录信息视图类
 * @Author 郭佳
 * @Date 2021/3/22 16:45
 * @Version 1.0
 */
public class UserLoginVo implements Serializable {
	private static final long serialVersionUID = 3153820217887431635L;
	private String cellphone;                     //手机号码
	private String password;                      //密码

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
}