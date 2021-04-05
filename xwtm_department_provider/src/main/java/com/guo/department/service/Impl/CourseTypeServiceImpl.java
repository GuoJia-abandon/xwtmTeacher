package com.guo.department.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.department.dao.CourseTypeDao;
import com.guo.department.service.CourseTypeService;
import com.guo.pojo.entity.department.CourseType;
import com.guo.pojo.entity.user.Menu;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.aspectj.weaver.ast.Var;
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
 * @ClassName CourseTypeServiceImpl
 * @Description 课程类型信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("CourseTypeService")
@Transactional
public class CourseTypeServiceImpl implements CourseTypeService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private CourseTypeDao courseTypeDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.CourseType.CourseType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public CourseType getCourseTypeById(String id) throws Exception {
		CourseType query = new CourseType();
		query.setId(id);
		List<CourseType> listByQuery = courseTypeDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<CourseType> getPageVoByQuery(CourseType query, PageVo<CourseType> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<CourseType> list = courseTypeDao.findListByQuery(query);
		List<CourseType> lists = courseTypeDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<CourseType>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: java.util.List<com.guo.pojo.entity.CourseType.CourseType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<CourseType> getListByQuery(CourseType query) throws Exception {
		return courseTypeDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(CourseType entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (courseTypeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(CourseType entity) throws Exception {
		if (courseTypeDao.update(entity) > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<CourseType> getListByParent() throws Exception {
		List<CourseType> listByParent = new ArrayList<>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("parent",null);
		 listByParent = courseTypeDao.getListByParent(queryMap);
		System.out.println("");
		for (CourseType first : listByParent) {
			queryMap.put("parent",first.getId());
			List<CourseType> children= courseTypeDao.getListByParent(queryMap);
			first.setCourseTypeLists(children);
		}
		return listByParent;
	}

}