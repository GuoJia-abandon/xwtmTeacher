package com.guo.user.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.user.Menu;
import com.guo.transport.user.MenuTransport;
import com.guo.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName MenuTransportImpl
 * @Description 菜单功能传输层接口实现类
 * @Author 郭佳
 * @Date 2021/2/23 21:32
 * @Version 1.0
 */
@RestController("menuTransportImpl")
@RequestMapping("/menu/transport")
public class MenuTransportImpl implements MenuTransport {

	@Autowired
	private MenuService service;

	/**
	 * @Description: 根据查询对象，分页对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu, com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>]
	 * @return: com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/page")
	@Override
	public PageVo<Menu> getPageVoByQuery(@RequestBody QueryVo<Menu> queryVo)  throws Exception{
		return service.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/list")
	@Override
	public List<Menu> getListByQuery(@RequestBody Menu query) throws Exception{
		return service.getListByQuery(query);
	}

	/**
	 * @Description: 根据主键进行查询
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Menu
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@GetMapping("/id")
	@Override
	public Menu getById(@RequestParam String id) throws Exception{
		return service.getById(id);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody Menu query) throws Exception{
		return service.save(query);
	}

	/**
	 * @Description: 修改对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody Menu query) throws Exception{
		return service.update(query);
	}

	/**
	 * @Description: 获取给定用户的菜单列表
	 * @Param: [java.lang.String]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/28
	 */
	@PostMapping("/menulist")
	@Override
	public List<Menu> getLoginMenu(@RequestParam String token) throws Exception{
		return service.getLoginMenuList(token);
	}

	@PostMapping("/menu")
	@Override
	public List<Menu> getMenuList() throws Exception{
		return service.getMenuList();
	}

}