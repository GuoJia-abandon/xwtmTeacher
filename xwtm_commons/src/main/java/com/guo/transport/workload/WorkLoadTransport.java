package com.guo.transport.workload;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.workload.WorkLoad;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 类描述：工作量信息传输层接口
 *
 * @ClassName WorkLoadTransport
 * @Description 工作量信息传输层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:28
 * @Version 1.0
 */
@FeignClient(name = "xwtm-workload-provider")
@RequestMapping("/workLoad/transport")
public interface WorkLoadTransport {

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.WorkLoad.WorkLoad
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@PostMapping("/id")
	WorkLoad getWorkLoadById(@RequestParam String id) throws Exception;


	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	PageVo<WorkLoad> getPageVoByQuery(@RequestBody QueryVo<WorkLoad> queryVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: java.util.List<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	List<WorkLoad> getListByQuery(@RequestBody WorkLoad query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	boolean save(@RequestBody WorkLoad entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	boolean update(@RequestBody WorkLoad entity) throws Exception;
}