package com.guo.workload.dao;
import com.guo.pojo.entity.workload.WorkLoadMethods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：授课方式信息持久层接口
 *
 * @ClassName WorkLoadMethodsDao
 * @Description 授课方式类型信息持久层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:57
 * @Version 1.0
 */
@Repository
public interface WorkLoadMethodsDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	 List<WorkLoadMethods> findListByQuery(WorkLoadMethods query);

	 /**
	  * @Description: 保存信息
	  * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int save(WorkLoadMethods entity) throws Exception;

	 /**
	  * @Description: 更新信息
	  * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int update(WorkLoadMethods entity) throws Exception;

}