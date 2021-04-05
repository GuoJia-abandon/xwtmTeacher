package com.guo.department.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.department.service.ClassGradeService;
import com.guo.pojo.entity.department.ClassGrade;
import com.guo.transport.department.ClassGradeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：班级信息信息传输层接口实现类
 *
 * @ClassName ClassGradeTransportImpl
 * @Description 班级信息信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("classGradeTransport")
@RequestMapping("/classgrade/transport")
public class ClassGradeTransportImpl implements ClassGradeTransport {

	@Autowired
	private ClassGradeService classGradeService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.ClassGrade.ClassGrade
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public ClassGrade getClassGradeById(@RequestParam String id) throws Exception {
		return classGradeService.getClassGradeById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<ClassGrade> getPageVoByQuery(@RequestBody QueryVo<ClassGrade> queryVo) throws Exception{
		return classGradeService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: java.util.List<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<ClassGrade> getListByQuery(@RequestBody ClassGrade query) throws Exception{
		return classGradeService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody ClassGrade entity) throws Exception{
		return classGradeService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody ClassGrade entity) throws Exception{
		return classGradeService.update(entity);
	}
}