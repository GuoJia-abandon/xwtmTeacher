package com.guo.pojo.entity.user;

import com.guo.base.pojo.entity.baseEntity;

import java.util.List;

/**
 * 类描述：菜单实体类信息
 *
 * @ClassName menu
 * @Description 菜单实体类信息
 * @Author 郭佳
 * @Date 2021/3/20 21:12
 * @Version 1.0
 */
public class Menu extends baseEntity {
	private static final long serialVersionUID = -7465238978334793178L;
	private String id;                     //主键
	private String component;              //文本信息
	private String path;                    //菜单链接
	private String icon;                   //菜单图标
	private String name;                   //菜单名称
	private List<Menu> children;           //子级菜单
	private Menu parent;                   //父级菜单

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
}