package com.guo.department.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.department.service.CourtyardService;
import com.guo.pojo.entity.department.Courtyard;
import com.guo.transport.department.CourtyardTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：院校信息传输层接口实现类
 *
 * @ClassName CourtyardTransportImpl
 * @Description 院校信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("courtyardTransport")
@RequestMapping("/courtyard/transport")
public class CourtyardTransportImpl implements CourtyardTransport {

	@Autowired
	private CourtyardService courtyardService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Courtyard.Courtyard
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public Courtyard getCourtyardById(@RequestParam String id) throws Exception {
		return courtyardService.getCourtyardById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<Courtyard> getPageVoByQuery(@RequestBody QueryVo<Courtyard> queryVo) throws Exception{
		return courtyardService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: java.util.List<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<Courtyard> getListByQuery(@RequestBody Courtyard query) throws Exception{
		return courtyardService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody Courtyard entity) throws Exception{
		return courtyardService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody Courtyard entity) throws Exception{
		return courtyardService.update(entity);
	}
}