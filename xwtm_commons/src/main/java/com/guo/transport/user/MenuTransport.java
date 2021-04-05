package com.guo.transport.user;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.pojo.entity.user.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName MenuTransport
 * @Description 菜单功能传输层接口
 * @Author 郭佳
 * @Date 2021/2/23 21:25
 * @Versionm 1.0
 */
@FeignClient(name = "xwtm-system-provider")
@RequestMapping("/menu/transport")
public interface MenuTransport {
	/**
	 * @Description: 根据查询对象，分页对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu, com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>]
	 * @return: com.guo.base.pojo.vo.PageVo<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/page")
	PageVo<Menu> getPageVoByQuery(@RequestBody QueryVo<Menu> queryVo)  throws Exception;

	/**
	 * @Description: 根据查询对象查询列表
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/list")
	List<Menu> getListByQuery(@RequestBody Menu query) throws Exception;

	/**
	 * @Description: 根据主键进行查询
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Menu
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@GetMapping("/id")
	Menu getById(@RequestParam String id) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/save")
	boolean save(@RequestBody Menu query) throws Exception;

	/**
	 * @Description: 修改对象信息
	 * @Param: [com.guo.pojo.entity.Menu]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/2/23
	 */
	@PostMapping("/update")
	boolean update(@RequestBody Menu query) throws Exception;


	/**
	 * @Description: 获取给定用户的菜单列表
	 * @Param: [java.lang.String]
	 * @return: java.util.List<com.guo.pojo.entity.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/2/28
	 */
	@PostMapping("/menulist")
	List<Menu> getLoginMenu(@RequestParam String token) throws Exception;

	@PostMapping("/menu")
	List<Menu> getMenuList() throws Exception;
}