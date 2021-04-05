package com.guo.department.dao;

import com.guo.pojo.entity.department.Course;
import com.guo.pojo.entity.department.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：课程信息实体类接口
 *
 * @ClassName CourseDao
 * @Description 课程信息实体类接口
 * @Author 郭佳
 * @Date 2021/3/25 18:03
 * @Version 1.0
 */
@Repository
public interface CourseDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: java.util.List<com.guo.pojo.entity.Course.Course>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<Course> findListByQuery(Course query) throws Exception;

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(Course entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(Course entity) throws Exception;


}