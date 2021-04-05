package com.guo.workload.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.workload.WorkLoad;

import java.util.List;

/**
 * 类描述：工作量信息业务逻辑层接口
 *
 * @ClassName WorkLoadService
 * @Description 工作量信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface WorkLoadService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoad.WorkLoad
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	WorkLoad getWorkLoadById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<WorkLoad> getPageVoByQuery(WorkLoad query,PageVo<WorkLoad> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<WorkLoad> getListByQuery(WorkLoad query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(WorkLoad entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(WorkLoad entity) throws Exception;



}