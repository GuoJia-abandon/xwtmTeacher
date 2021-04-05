package com.guo.user.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.user.Menu;
import com.guo.pojo.entity.user.Role;
import com.guo.pojo.entity.user.User;
import com.guo.user.dao.MenuDao;
import com.guo.user.service.MenuService;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 *
 * @ClassName MenuServiceImpl
 * @Description 菜单信息业务层接口实现类
 * @Author 郭佳
 * @Date 2021/2/23 21:09
 * @Version 1.0
 */
@Service("menuServiceImpl")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public PageVo<Menu> getPageVoByQuery(Menu query, PageVo<Menu> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
		List<Menu> list = menuDao.findListByQuery(query);
		List<Menu> lists = menuDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil().parseFromPageInfoToPageVO(list, pageVo);
		return pageVo;
	}

	@Override
	public List<Menu> getListByQuery(Menu query) throws Exception {
		return menuDao.findListByQuery(query);
	}

	@Override
	public Menu getById(String id) throws Exception {
		Menu query = new Menu();
		query.setId(id);
		List<Menu> listByQuery = menuDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()) {
			return listByQuery.get(0);
		}
		return null;
	}

	@Override
	public boolean save(Menu query) throws Exception {
		query.setId(idGenerator.createId());
		if (menuDao.save(query) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Menu query) throws Exception {
		if (menuDao.update(query) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Menu> getLoginMenuList(String token) throws Exception {
		List<Menu> menuList = new ArrayList<Menu>();
		//根据token获取当前用户信息
		User user =  (User) redisUtil.getFromRedis(token, User.class);
		if (user != null) {
			//用户已经登录，获取该用户的角色信息
			Role role = user.getRole();
			System.out.println("role"+"------"+role);
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("role", role.getId());
			queryMap.put("parent", null);
			//查询一级菜单列表
			menuList = menuDao.findMenuListByRoleAndParent(queryMap);
			//循环一级菜单，获取二级菜单
			for (Menu first : menuList) {
				queryMap.put("parent", first.getId());
				List<Menu> children = menuDao.findMenuListByRoleAndParent(queryMap);
				first.setChildren(children);
			}
		}
		return menuList;
	}

	@Override
	public List<Menu> getMenuList() throws Exception {
		List<Menu> menuList = new ArrayList<Menu>();
		//根据token获取当前用户信息
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("parent", null);
			//查询一级菜单列表
			menuList = menuDao.findMenuListByRoleAndParent(queryMap);
		//循环一级菜单，获取二级菜单
			for (Menu first : menuList) {
				queryMap.put("parent", first.getId());
				List<Menu> children = menuDao.findMenuListByRoleAndParent(queryMap);
				System.out.println("chile的撒大");
				System.out.println(children);
				first.setChildren(children);
		}
		return menuList;
	}
}