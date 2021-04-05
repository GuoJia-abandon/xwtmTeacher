package com.guo.workload.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.workload.dao.WorkLoadTypeDao;
import com.guo.workload.service.WorkLoadTypeService;
import com.guo.pojo.entity.workload.WorkLoadType;
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
 * 类描述：课程类型信息业务逻辑层接口实现类
 *
 * @ClassName WorkLoadTypeServiceImpl
 * @Description 课程类型信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("workLoadTypeService")
@Transactional
public class WorkLoadTypeServiceImpl implements WorkLoadTypeService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private WorkLoadTypeDao workLoadTypeDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadType.WorkLoadType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public WorkLoadType getWorkLoadTypeById(String id) throws Exception {
		WorkLoadType query = new WorkLoadType();
		query.setId(id);
		List<WorkLoadType> listByQuery = workLoadTypeDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<WorkLoadType> getPageVoByQuery(WorkLoadType query, PageVo<WorkLoadType> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<WorkLoadType> list = workLoadTypeDao.findListByQuery(query);
		List<WorkLoadType> lists = workLoadTypeDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<WorkLoadType>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadType.WorkLoadType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<WorkLoadType> getListByQuery(WorkLoadType query) throws Exception {
		return workLoadTypeDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(WorkLoadType entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (workLoadTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(WorkLoadType entity) throws Exception {
		if (workLoadTypeDao.update(entity) > 0){
			return true;
		}
		return false;
	}

}