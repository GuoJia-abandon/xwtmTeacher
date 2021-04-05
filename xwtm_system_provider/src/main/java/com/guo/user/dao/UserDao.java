package com.guo.user.dao;

import com.guo.pojo.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：用户信息持久层接口
 *
 * @ClassName UserDao
 * @Description 用户信息持久层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:57
 * @Version 1.0
 */
@Repository
public interface UserDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: java.util.List<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	 List<User> findListByQuery(User query);

	 /**
	  * @Description: 保存信息
	  * @Param: [com.guo.pojo.entity.user.User]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int save(User entity) throws Exception;

	 /**
	  * @Description: 更新信息
	  * @Param: [com.guo.pojo.entity.user.User]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int update(User entity) throws Exception;

}