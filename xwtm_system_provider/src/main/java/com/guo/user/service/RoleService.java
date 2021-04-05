package com.guo.user.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.Role;

import java.util.List;

/**
 * 类描述：用户角色信息业务逻辑层接口
 *
 * @ClassName RoleService
 * @Description 用户角色信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface RoleService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Role.Role
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	Role getRoleById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Role.Role, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<Role> getPageVoByQuery(Role query,PageVo<Role> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: java.util.List<com.guo.pojo.entity.Role.Role>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<Role> getListByQuery(Role query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(Role entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(Role entity) throws Exception;


}