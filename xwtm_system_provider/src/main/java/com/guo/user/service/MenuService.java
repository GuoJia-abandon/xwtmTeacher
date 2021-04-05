package com.guo.user.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.user.Menu;

import java.util.List;

/**
 * 类描述：
 *
 * @Description 菜单信息业务层接口
 * @Author 郭佳
 * @Date 2021/3/20
 * @Version 1.0
 */
public interface MenuService {
	
	/** 
	 * @Description: 根据查询对象，分页对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu, com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>]
	 * @return: com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	PageVo<Menu> getPageVoByQuery(Menu query , PageVo<Menu> pageVo)  throws Exception;

	/** 
	 * @Description: 根据查询对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	List<Menu> getListByQuery(Menu query) throws Exception;

	/** 
	 * @Description: 根据主键进行查询
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Menu
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	Menu getById(String id) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	boolean save(Menu query) throws Exception;

	/**
	 * @Description: 修改对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	boolean update(Menu query) throws Exception;

	/**
	 * @Description: 获取给定用户的菜单列表
	 * @Param: [java.lang.String]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/28
	 */
	List<Menu> getLoginMenuList(String token) throws Exception;

	List<Menu> getMenuList() throws Exception;
}