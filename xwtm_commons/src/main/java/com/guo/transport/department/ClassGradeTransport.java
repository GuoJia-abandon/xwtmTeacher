package com.guo.transport.department;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.department.ClassGrade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
/**
 * 类描述：班级信息信息传输层接口
 *
 * @ClassName ClassGradeTransport
 * @Description 班级信息信息传输层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:28
 * @Version 1.0
 */
@FeignClient(name = "xwtm-department-provider")
@RequestMapping("/classgrade/transport")
public interface ClassGradeTransport {

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.ClassGrade.ClassGrade
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@PostMapping("/id")
	ClassGrade getClassGradeById(@RequestParam String id) throws Exception;


	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	PageVo<ClassGrade> getPageVoByQuery(@RequestBody QueryVo<ClassGrade> queryVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: java.util.List<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	List<ClassGrade> getListByQuery(@RequestBody ClassGrade query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	boolean save(@RequestBody ClassGrade entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	boolean update(@RequestBody ClassGrade entity) throws Exception;

}