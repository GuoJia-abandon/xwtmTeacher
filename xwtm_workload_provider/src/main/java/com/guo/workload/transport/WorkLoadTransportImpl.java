package com.guo.workload.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.workload.WorkLoad;
import com.guo.transport.workload.WorkLoadTransport;
import com.guo.workload.service.WorkLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：工作量信息传输层接口实现类
 *
 * @ClassName WorkLoadTransportImpl
 * @Description 工作量信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("workLoadTransport")
@RequestMapping("/workLoad/transport")
public class WorkLoadTransportImpl implements WorkLoadTransport {

	@Autowired
	private WorkLoadService workLoadService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoad.WorkLoad
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public WorkLoad getWorkLoadById(@RequestParam String id) throws Exception {
		return workLoadService.getWorkLoadById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<WorkLoad> getPageVoByQuery(@RequestBody QueryVo<WorkLoad> queryVo) throws Exception{
		return workLoadService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<WorkLoad> getListByQuery(@RequestBody WorkLoad query) throws Exception{
		return workLoadService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody WorkLoad entity) throws Exception{
		return workLoadService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody WorkLoad entity) throws Exception{
		return workLoadService.update(entity);
	}

}