package com.guo.department.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.department.Department;

import java.util.List;

/**
 * 类描述：系别信息业务逻辑层接口
 *
 * @ClassName DepartmentService
 * @Description 系别信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface DepartmentService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Department.Department
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	Department getDepartmentById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Department.Department, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<Department> getPageVoByQuery(Department query,PageVo<Department> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: java.util.List<com.guo.pojo.entity.Department.Department>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<Department> getListByQuery(Department query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(Department entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(Department entity) throws Exception;


}