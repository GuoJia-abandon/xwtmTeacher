package com.guo.department.service.Impl;

import com.github.pagehelper.PageHelper;
import com.guo.base.pojo.vo.PageVo;
import com.guo.department.dao.ClassGradeDao;
import com.guo.department.service.ClassGradeService;
import com.guo.pojo.entity.department.ClassGrade;
import com.guo.util.IdGenerator;
import com.guo.util.PageUtil;
import com.guo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类描述：班级信息业务逻辑层接口实现类
 *
 * @ClassName ClassGradeServiceImpl
 * @Description 班级信息业务逻辑层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:08
 * @Version 1.0
 */
@Service("classGradeService")
@Transactional
public class ClassGradeServiceImpl implements ClassGradeService {

	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private ClassGradeDao ClassGradeDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.ClassGrade.ClassGrade
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	public ClassGrade getClassGradeById(String id) throws Exception {
		ClassGrade query = new ClassGrade();
		query.setId(id);
		List<ClassGrade> listByQuery = ClassGradeDao.findListByQuery(query);
		if (listByQuery != null && !listByQuery.isEmpty()){
			return listByQuery.get(0);
		}
		return null;
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public PageVo<ClassGrade> getPageVoByQuery(ClassGrade query, PageVo<ClassGrade> pageVo) throws Exception {
		PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
		List<ClassGrade> list = ClassGradeDao.findListByQuery(query);
		List<ClassGrade> lists = ClassGradeDao.findListByQuery(null);
		long totalcount  = lists.size();
		pageVo.setTotalCount(totalcount);
		new PageUtil<ClassGrade>().parseFromPageInfoToPageVO(list,pageVo);
		return pageVo;
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: java.util.List<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public List<ClassGrade> getListByQuery(ClassGrade query) throws Exception {
		return ClassGradeDao.findListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean save(ClassGrade entity) throws Exception {
		entity.setId(idGenerator.createId());
		if (ClassGradeDao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@Override
	public boolean update(ClassGrade entity) throws Exception {
		if (ClassGradeDao.update(entity) > 0){
			return true;
		}
		return false;
	}
}