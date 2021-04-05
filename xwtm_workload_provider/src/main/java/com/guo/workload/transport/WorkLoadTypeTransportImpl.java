package com.guo.workload.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.workload.service.WorkLoadTypeService;
import com.guo.pojo.entity.workload.WorkLoadType;
import com.guo.transport.workload.WorkLoadTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：工作量类型信息传输层接口实现类
 *
 * @ClassName WorkLoadTypeTransportImpl
 * @Description 工作量类型信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("workLoadTypeTransport")
@RequestMapping("/workLoadType/transport")
public class WorkLoadTypeTransportImpl implements WorkLoadTypeTransport {

	@Autowired
	private WorkLoadTypeService workLoadTypeService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoadType.WorkLoadType
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public WorkLoadType getWorkLoadTypeById(@RequestParam String id) throws Exception {
		return workLoadTypeService.getWorkLoadTypeById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<WorkLoadType> getPageVoByQuery(@RequestBody QueryVo<WorkLoadType> queryVo) throws Exception{
		return workLoadTypeService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoadType.WorkLoadType>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<WorkLoadType> getListByQuery(@RequestBody WorkLoadType query) throws Exception{
		return workLoadTypeService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody WorkLoadType entity) throws Exception{
		return workLoadTypeService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoadType.WorkLoadType]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody WorkLoadType entity) throws Exception{
		return workLoadTypeService.update(entity);
	}

}