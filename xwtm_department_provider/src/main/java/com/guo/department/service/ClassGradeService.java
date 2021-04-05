package com.guo.department.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.department.ClassGrade;

import java.util.List;

/**
 * 类描述：班级信息业务逻辑层接口
 *
 * @ClassName ClassGradeService
 * @Description 班级信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface ClassGradeService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.ClassGrade.ClassGrade
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	ClassGrade getClassGradeById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<ClassGrade> getPageVoByQuery(ClassGrade query,PageVo<ClassGrade> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: java.util.List<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<ClassGrade> getListByQuery(ClassGrade query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(ClassGrade entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(ClassGrade entity) throws Exception;


}