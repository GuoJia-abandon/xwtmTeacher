package com.guo.department.service;

import com.guo.base.pojo.vo.PageVo;
import com.guo.pojo.entity.department.Courtyard;

import java.util.List;

/**
 * 类描述：院校信息业务逻辑层接口
 *
 * @ClassName CourtyardService
 * @Description 课院校信息业务逻辑层接口
 * @Author 郭佳
 * @Date 2021/3/20 21:54
 * @Version 1.0
 */
public interface CourtyardService {
	/** 
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Courtyard.Courtyard
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	Courtyard getCourtyardById(String id) throws Exception;

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	PageVo<Courtyard> getPageVoByQuery(Courtyard query,PageVo<Courtyard> pageVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: java.util.List<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	List<Courtyard> getListByQuery(Courtyard query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean save(Courtyard entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	boolean update(Courtyard entity) throws Exception;


}