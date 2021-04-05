package com.guo.department.dao;

import com.guo.pojo.entity.department.CourseType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类描述：课程类型信息实体类接口
 *
 * @ClassName CourseTypeDao
 * @Description 课程类型信息实体类接口
 * @Author 郭佳
 * @Date 2021/3/25 18:03
 * @Version 1.0
 */
@Repository
public interface CourseTypeDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: java.util.List<com.guo.pojo.entity.CourseType.CourseType>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<CourseType> findListByQuery(CourseType query) throws Exception;

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(CourseType entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(CourseType entity) throws Exception;

	List<CourseType> getListByParent(Map<String,Object> lists) throws Exception;


}