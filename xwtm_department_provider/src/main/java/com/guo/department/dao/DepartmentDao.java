package com.guo.department.dao;

import com.guo.pojo.entity.department.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：系别信息实体类接口
 *
 * @ClassName DepartmentDao
 * @Description 系别信息实体类接口
 * @Author 郭佳
 * @Date 2021/3/25 18:03
 * @Version 1.0
 */
@Repository
public interface DepartmentDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: java.util.List<com.guo.pojo.entity.Department.Department>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<Department> findListByQuery(Department query) throws Exception;

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(Department entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(Department entity) throws Exception;


}