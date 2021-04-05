package com.guo.user.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.enums.enumStatus;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.vo.UserLoginVo;
import com.guo.user.dao.UserDao;
import com.guo.user.service.UserService;
import com.guo.util.*;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public User getUserById(String id) throws Exception {
		User query = new User();
		query.setId(id);
		List<User> listByQuery = userDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.user.User, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<User> getPageVoByQuery(User query, PageVo<User> pageVo) throws Exception {
		Page page = PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<User> list = userDao.findListByQuery(query);
		List<User> lists = userDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<User>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: java.util.List<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<User> getListByQuery(User query) throws Exception {
		return userDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(User entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (userDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(User entity) throws Exception {
		if (userDao.update(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public ResponseVo getUserLogin(String cellphone,String password) throws Exception {
		if (ValidationUtil.CheckCellphone(cellphone) && ValidationUtil.CheckPassword(password)){
			password = MD5Util.encrypt(password);
			User query = new User();
			query.setCellphone(cellphone);
			List<User> listByQuery = userDao.findListByQuery(query);
			System.out.println(listByQuery);
			if (listByQuery != null && !listByQuery.isEmpty()){
				User user = listByQuery.get(0);
				if (user.getPassword().equals(password)){
					if (user.getStatus().equals(enumStatus.STATUS_ENABLE.getCode())){
						String token = TokenUtil.createToken(user.getId());
						System.out.println("token>="+token);
						redisUtil.saveToRedis(token,user);
						return ResponseVo.getSuccessResponse(token);
					}else {
						return ResponseVo.getErrorResponse("该用户已被禁用");
					}
				} else{
					return ResponseVo.getErrorResponse("请填写正确的信息");
				}
			} else {
				return ResponseVo.getErrorResponse("该用户不存在");
			}
		} else {
			return ResponseVo.getErrorResponse("请填写正确的信息");
		}
	}

	@Override
	public User getUserByToken(String token) throws Exception {
		if(TokenUtil.verifyToken(token) != null){
			User user = (User) redisUtil.getFromRedis(token,User.class);
			return user;
		}
		return null;
	}

	/**
	 * 根据手机号码查询对象信息
	 * @Description: 根据手机号码查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@Override
	public User findUserByCellphone(String cellphone) throws Exception {
		User query = new User();
		query.setCellphone(cellphone);
		List<User> listByQuery = userDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}
}