package com.guo.department.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.department.dao.DepartmentDao;
import com.guo.department.service.DepartmentService;
import com.guo.pojo.entity.department.Department;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：系别信息业务逻辑层接口实现类
 *
 * @ClassName DepartmentServiceImpl
 * @Description 系别信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Department.Department
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public Department getDepartmentById(String id) throws Exception {
		Department query = new Department();
		query.setId(id);
		List<Department> listByQuery = departmentDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Department.Department, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<Department> getPageVoByQuery(Department query, PageVo<Department> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<Department> list = departmentDao.findListByQuery(query);
		List<Department> lists = departmentDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<Department>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: java.util.List<com.guo.pojo.entity.Department.Department>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<Department> getListByQuery(Department query) throws Exception {
		return departmentDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(Department entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (departmentDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(Department entity) throws Exception {
		if (departmentDao.update(entity) > 0){
			return true;
		}
		return false;
	}
}