package com.guo.workload.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.workload.WorkLoad;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import com.guo.workload.dao.WorkLoadDao;
import com.guo.workload.service.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：工作量信息业务逻辑层接口实现类
 *
 * @ClassName WorkLoadServiceImpl
 * @Description 工作量信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("workLoadService")
@Transactional
public class WorkLoadServiceImpl implements WorkLoadService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private WorkLoadDao workLoadDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoad.WorkLoad
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public WorkLoad getWorkLoadById(String id) throws Exception {
		WorkLoad query = new WorkLoad();
		query.setId(id);
		List<WorkLoad> listByQuery = workLoadDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<WorkLoad> getPageVoByQuery(WorkLoad query, PageVo<WorkLoad> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<WorkLoad> list = workLoadDao.findListByQuery(query);
		List<WorkLoad> lists = workLoadDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<WorkLoad>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<WorkLoad> getListByQuery(WorkLoad query) throws Exception {
		return workLoadDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(WorkLoad entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (workLoadDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(WorkLoad entity) throws Exception {
		if (workLoadDao.update(entity) > 0){
			return true;
		}
		return false;
	}

}