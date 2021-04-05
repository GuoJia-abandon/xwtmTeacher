package com.guo.user.dao;

import com.guo.pojo.entity.user.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类描述：用户菜单信息持久层接口
 *
 * @ClassName MenuDao
 * @Description 用户菜单信息持久层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:57
 * @Version 1.0
 */
@Repository
public interface MenuDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.Menu.Menu]
	 * @return: java.util.List<com.guo.pojo.entity.Menu.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	 List<Menu> findListByQuery(Menu query);

	/**
	 * @Description: 根据用户角色信息查询用户菜单列表
	 * @Param: [java.util.Map<java.lang.String,java.lang.Object>]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<Menu> findMenuListByRoleAndParent(Map<String, Object> queryMap) throws Exception;

	 /**
	  * @Description: 保存信息
	  * @Param: [com.guo.pojo.entity.Menu.Menu]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int save(Menu entity) throws Exception;

	 /**
	  * @Description: 更新信息
	  * @Param: [com.guo.pojo.entity.Menu.Menu]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int update(Menu entity) throws Exception;

}