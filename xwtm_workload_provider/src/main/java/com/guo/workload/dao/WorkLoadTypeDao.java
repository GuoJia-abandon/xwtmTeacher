package com.guo.workload.dao;
import com.guo.pojo.entity.workload.WorkLoadType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：工作量类型信息持久层接口
 *
 * @ClassName WorkLoadTypeDao
 * @Description 工作量类型信息持久层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:57
 * @Version 1.0
 */
@Repository
public interface WorkLoadTypeDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadType.WorkLoadType>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	 List<WorkLoadType> findListByQuery(WorkLoadType query);

	 /**
	  * @Description: 保存信息
	  * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int save(WorkLoadType entity) throws Exception;

	 /**
	  * @Description: 更新信息
	  * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	  * @return: int
	  * @Author: 郭佳
	  * @Date: 2021/3/20
	  */
	 int update(WorkLoadType entity) throws Exception;

}