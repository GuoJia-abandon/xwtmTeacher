package com.guo.department.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.department.Course;
import com.guo.pojo.entity.department.CourseType;

import java.util.List;

/**
 * 类描述：课程类型信息业务逻辑层接口
 *
 * @ClassName CourseTypeService
 * @Description 课程类型信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface CourseTypeService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.CourseType.CourseType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	CourseType getCourseTypeById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<CourseType> getPageVoByQuery(CourseType query,PageVo<CourseType> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: java.util.List<com.guo.pojo.entity.CourseType.CourseType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<CourseType> getListByQuery(CourseType query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(CourseType entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(CourseType entity) throws Exception;

	List<CourseType> getListByParent() throws Exception;


}