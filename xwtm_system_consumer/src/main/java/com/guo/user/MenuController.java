package com.guo.user;

import com.guo.base.controller.baseController;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.Menu;
import com.guo.pojo.entity.user.Menu;
import com.guo.pojo.entity.user.User;
import com.guo.transport.user.MenuTransport;
import com.guo.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类描述：
 *
 * @ClassName MenuController
 * @Description 菜单控制层
 * @Author 郭佳
 * @Date 2021/3/24 20:35
 * @Version 1.0
 */
@RestController("menuController")
@RequestMapping("/menu")
@CrossOrigin
public class MenuController extends baseController {

	@Autowired
	private MenuTransport menuTransport;
	@Autowired
	private UserTransport userTransport;

	@GetMapping("/menuList")
	public ResponseVo<Menu> getMenuListByQuery() throws Exception {
		return ResponseVo.getSuccessResponse(menuTransport.getMenuList());
	}
	
	/**
	 * @Description: 通过token获取角色菜单信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.user.Menu>
	 * @Author: 郭佳
	 * @Date: 2021/3/24
	 */
	@GetMapping("/loginList")
	public ResponseVo<Menu> getListByToken( String token) throws Exception{
		return ResponseVo.getSuccessResponse(menuTransport.getLoginMenu(token));
	}
}