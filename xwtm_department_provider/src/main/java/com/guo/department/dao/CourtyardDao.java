package com.guo.department.dao;

import com.guo.pojo.entity.department.Courtyard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：院级信息实体类接口
 *
 * @ClassName CourtyardDao
 * @Description 院级信息实体类接口
 * @Author 郭佳
 * @Date 2021/3/25 18:03
 * @Version 1.0
 */
@Repository
public interface CourtyardDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: java.util.List<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<Courtyard> findListByQuery(Courtyard query) throws Exception;

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(Courtyard entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(Courtyard entity) throws Exception;


}