package com.guo.workload.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.workload.WorkLoadType;
import java.util.List;

/**
 * 类描述：工作量类型信息业务逻辑层接口
 *
 * @ClassName WorkLoadTypeService
 * @Description 工作量类型信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface WorkLoadTypeService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadType.WorkLoadType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	WorkLoadType getWorkLoadTypeById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<WorkLoadType> getPageVoByQuery(WorkLoadType query,PageVo<WorkLoadType> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadType.WorkLoadType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<WorkLoadType> getListByQuery(WorkLoadType query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(WorkLoadType entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(WorkLoadType entity) throws Exception;



}