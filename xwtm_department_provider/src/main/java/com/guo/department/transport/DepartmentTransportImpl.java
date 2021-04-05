package com.guo.department.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.department.service.DepartmentService;
import com.guo.pojo.entity.department.Department;
import com.guo.transport.department.DepartmentTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：系别信息信息传输层接口实现类
 *
 * @ClassName DepartmentTransportImpl
 * @Description 系别信息信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("departmentTransport")
@RequestMapping("/department/transport")
public class DepartmentTransportImpl implements DepartmentTransport {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Department.Department
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public Department getDepartmentById(@RequestParam String id) throws Exception {
		return departmentService.getDepartmentById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Department.Department, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<Department> getPageVoByQuery(@RequestBody QueryVo<Department> queryVo) throws Exception{
		return departmentService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: java.util.List<com.guo.pojo.entity.Department.Department>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<Department> getListByQuery(@RequestBody Department query) throws Exception{
		return departmentService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody Department entity) throws Exception{
		return departmentService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Department.Department]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody Department entity) throws Exception{
		return departmentService.update(entity);
	}
}