package com.guo.workload.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.workload.WorkLoadMethods;
import com.guo.transport.workload.WorkLoadMethodsTransport;
import com.guo.workload.service.WorkLoadMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：授课方式传输层接口实现类
 *
 * @ClassName WorkLoadMethodsTransportImpl
 * @Description 授课方式传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("workLoadMethodsTransport")
@RequestMapping("/workLoadMethods/transport")
public class WorkLoadMethodsTransportImpl implements WorkLoadMethodsTransport {

	@Autowired
	private WorkLoadMethodsService workLoadMethodsService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public WorkLoadMethods getWorkLoadMethodsById(@RequestParam String id) throws Exception {
		return workLoadMethodsService.getWorkLoadMethodsById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<WorkLoadMethods> getPageVoByQuery(@RequestBody QueryVo<WorkLoadMethods> queryVo) throws Exception{
		return workLoadMethodsService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<WorkLoadMethods> getListByQuery(@RequestBody WorkLoadMethods query) throws Exception{
		return workLoadMethodsService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody WorkLoadMethods entity) throws Exception{
		return workLoadMethodsService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadMethods.WorkLoadMethods]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody WorkLoadMethods entity) throws Exception{
		return workLoadMethodsService.update(entity);
	}

}