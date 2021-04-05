package com.guo.department.dao;

import com.guo.pojo.entity.department.ClassGrade;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：班级信息实体类接口
 *
 * @ClassName ClassGradeDao
 * @Description 班级信息实体类接口
 * @Author 郭佳
 * @Date 2021/3/25 18:03
 * @Version 1.0
 */
@Repository
public interface ClassGradeDao {

	/**
	 * @Description: 根据条件查询列表信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: java.util.List<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	List<ClassGrade> findListByQuery(ClassGrade query) throws Exception;

	/**
	 * @Description: 保存信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int save(ClassGrade entity) throws Exception;

	/**
	 * @Description: 更新信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: int
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	int update(ClassGrade entity) throws Exception;


}