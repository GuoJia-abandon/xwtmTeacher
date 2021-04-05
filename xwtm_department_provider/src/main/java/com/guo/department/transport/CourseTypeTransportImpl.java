package com.guo.department.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.department.service.CourseTypeService;
import com.guo.pojo.entity.department.CourseType;
import com.guo.transport.department.CourseTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：课程信息信息传输层接口实现类
 *
 * @ClassName CourseTypeTransportImpl
 * @Description 课程信息信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("courseTypeTransport")
@RequestMapping("/courseType/transport")
public class CourseTypeTransportImpl implements CourseTypeTransport {

	@Autowired
	private CourseTypeService courseTypeService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.CourseType.CourseType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public CourseType getCourseTypeById(@RequestParam String id) throws Exception {
		return courseTypeService.getCourseTypeById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<CourseType> getPageVoByQuery(@RequestBody QueryVo<CourseType> queryVo) throws Exception{
		return courseTypeService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: java.util.List<com.guo.pojo.entity.CourseType.CourseType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<CourseType> getListByQuery(@RequestBody CourseType query) throws Exception{
		return courseTypeService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody CourseType entity) throws Exception{
		return courseTypeService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.CourseType.CourseType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody CourseType entity) throws Exception{
		return courseTypeService.update(entity);
	}

	@PostMapping("/CourseTypeLists")
	@Override
	public List<CourseType> getListByParent() throws Exception{
		return courseTypeService.getListByParent();
	}
}