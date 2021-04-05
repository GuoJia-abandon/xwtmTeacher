package com.guo.user.service.Impl;
import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.user.Role;
import com.guo.user.dao.RoleDao;
import com.guo.user.service.RoleService;
import com.guo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * 类描述：用户角色信息业务逻辑层接口实现类
 *
 * @ClassName RoleServiceImpl
 * @Description 用户角色信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Role.Role
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public Role getRoleById(String id) throws Exception {
		Role query = new Role();
		query.setId(id);
		List<Role> listByQuery = roleDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Role.Role, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<Role> getPageVoByQuery(Role query, PageVo<Role> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<Role> list = roleDao.findListByQuery(query);
		List<Role> lists = roleDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<Role>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: java.util.List<com.guo.pojo.entity.Role.Role>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<Role> getListByQuery(Role query) throws Exception {
		return roleDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(Role entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (roleDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(Role entity) throws Exception {
		if (roleDao.update(entity) > 0){
			return true;
		}
		return false;
	}
}