package com.guo.user.dao;

import com.guo.pojo.entity.user.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：用户角色信息持久层接口
 *
 * @ClassName RoleDao
 * @Description 用户角色信息持久层接口
 * @Author 郭佳
 * @Date 2021/3/23 21:10
 * @Version 1.0
 */
@Repository
public interface RoleDao {


	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: java.util.List<com.guo.pojo.entity.Role.Role>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<Role> findListByQuery(Role query);

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(Role entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(Role entity) throws Exception;


}