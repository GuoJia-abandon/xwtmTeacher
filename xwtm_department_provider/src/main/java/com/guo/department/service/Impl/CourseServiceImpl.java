package com.guo.department.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.department.service.CourseService;
import com.guo.pojo.entity.department.Course;
import com.guo.department.dao.CourseDao;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * 类描述：课程信息业务逻辑层接口实现类
 *
 * @ClassName CourseServiceImpl
 * @Description 课程信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Course.Course
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public Course getCourseById(String id) throws Exception {
		Course query = new Course();
		query.setId(id);
		List<Course> listByQuery = courseDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Course.Course, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<Course> getPageVoByQuery(Course query, PageVo<Course> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<Course> list = courseDao.findListByQuery(query);
		List<Course> lists = courseDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<Course>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: java.util.List<com.guo.pojo.entity.Course.Course>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<Course> getListByQuery(Course query) throws Exception {
		return courseDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(Course entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (courseDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(Course entity) throws Exception {
		if (courseDao.update(entity) > 0){
			return true;
		}
		return false;
	}
}