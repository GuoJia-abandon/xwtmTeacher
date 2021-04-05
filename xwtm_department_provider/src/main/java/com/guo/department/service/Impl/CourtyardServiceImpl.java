package com.guo.department.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.department.dao.CourtyardDao;
import com.guo.department.service.CourtyardService;
import com.guo.pojo.entity.department.Courtyard;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：院校信息业务逻辑层接口实现类
 *
 * @ClassName CourtyardServiceImpl
 * @Description 院校信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("courtyardService")
@Transactional
public class CourtyardServiceImpl implements CourtyardService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private CourtyardDao courtyardDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Courtyard.Courtyard
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public Courtyard getCourtyardById(String id) throws Exception {
		Courtyard query = new Courtyard();
		query.setId(id);
		List<Courtyard> listByQuery = courtyardDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<Courtyard> getPageVoByQuery(Courtyard query, PageVo<Courtyard> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<Courtyard> list = courtyardDao.findListByQuery(query);
		List<Courtyard> lists = courtyardDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<Courtyard>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: java.util.List<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<Courtyard> getListByQuery(Courtyard query) throws Exception {
		return courtyardDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(Courtyard entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (courtyardDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(Courtyard entity) throws Exception {
		if (courtyardDao.update(entity) > 0){
			return true;
		}
		return false;
	}
}