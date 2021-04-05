package com.guo.pojo.entity.user;

import com.guo.base.pojo.entity.baseEntity;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName role
 * @Description 用户角色实体类信息
 * @Author 郭佳
 * @Date 2021/3/20 21:08
 * @Version 1.0
 */
public class Role extends baseEntity {
	private static final long serialVersionUID = -2994016673228262150L;
	private String id;               //主键
	private String name;             //角色信息
	private String code;             //编码信息
	private List<Menu> menuList;     //菜单列表

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}