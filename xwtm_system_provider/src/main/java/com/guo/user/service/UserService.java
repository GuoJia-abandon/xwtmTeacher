package com.guo.user.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.vo.UserLoginVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName UserService
 * @Description 用户业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */

public interface UserService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	User getUserById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.user.User, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<User> getPageVoByQuery(User query,PageVo<User> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: java.util.List<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<User> getListByQuery(User query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(User entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(User entity) throws Exception;

	/** 
	 * @Description: 用户登录
	 * @Param: [com.guo.pojo.vo.UserLoginVo]
	 * @return: com.guo.base.pojo.vo.ResponseVo
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	ResponseVo getUserLogin(String cellphone,String password) throws Exception;

	/** 
	 * @Description: 通过token获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	User getUserByToken(String token) throws Exception;

	/**
	 * 根据手机号码查询对象信息
	 * @Description: 根据手机号码查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	User findUserByCellphone(String cellphone) throws Exception;
}