package com.guo.workload.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.workload.WorkLoadMethods;

import java.util.List;

/**
 * 类描述：授课方式类型信息业务逻辑层接口
 *
 * @ClassName WorkLoadMethodsService
 * @Description 授课方式类型信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface WorkLoadMethodsService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	WorkLoadMethods getWorkLoadMethodsById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<WorkLoadMethods> getPageVoByQuery(WorkLoadMethods query,PageVo<WorkLoadMethods> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<WorkLoadMethods> getListByQuery(WorkLoadMethods query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(WorkLoadMethods entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(WorkLoadMethods entity) throws Exception;



}