package com.guo.workload.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.workload.WorkLoadMethods;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import com.guo.workload.dao.WorkLoadMethodsDao;
import com.guo.workload.service.WorkLoadMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：授课方式业务逻辑层接口实现类
 *
 * @ClassName WorkLoadMethodsServiceImpl
 * @Description 授课方式业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("WorkLoadMethodsService")
@Transactional
public class WorkLoadMethodsServiceImpl implements WorkLoadMethodsService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private WorkLoadMethodsDao workLoadMethodsDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public WorkLoadMethods getWorkLoadMethodsById(String id) throws Exception {
		WorkLoadMethods query = new WorkLoadMethods();
		query.setId(id);
		List<WorkLoadMethods> listByQuery = workLoadMethodsDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<WorkLoadMethods> getPageVoByQuery(WorkLoadMethods query, PageVo<WorkLoadMethods> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<WorkLoadMethods> list = workLoadMethodsDao.findListByQuery(query);
		List<WorkLoadMethods> lists = workLoadMethodsDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<WorkLoadMethods>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<WorkLoadMethods> getListByQuery(WorkLoadMethods query) throws Exception {
		return workLoadMethodsDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(WorkLoadMethods entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (workLoadMethodsDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(WorkLoadMethods entity) throws Exception {
		if (workLoadMethodsDao.update(entity) > 0){
			return true;
		}
		return false;
	}

}