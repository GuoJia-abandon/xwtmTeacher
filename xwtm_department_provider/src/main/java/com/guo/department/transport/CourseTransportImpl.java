package com.guo.department.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.department.Course;
import com.guo.transport.department.CourseTransport;
import com.guo.department.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：课程信息信息传输层接口实现类
 *
 * @ClassName CourseTransportImpl
 * @Description 课程信息信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("courseTransport")
@RequestMapping("/course/transport")
public class CourseTransportImpl implements CourseTransport {

	@Autowired
	private CourseService courseService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Course.Course
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public Course getCourseById(@RequestParam String id) throws Exception {
		return courseService.getCourseById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Course.Course, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<Course> getPageVoByQuery(@RequestBody QueryVo<Course> queryVo) throws Exception{
		return courseService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: java.util.List<com.guo.pojo.entity.Course.Course>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<Course> getListByQuery(@RequestBody Course query) throws Exception{
		return courseService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody Course entity) throws Exception{
		return courseService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Course.Course]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody Course entity) throws Exception{
		return courseService.update(entity);
	}
}