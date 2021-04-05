package com.guo.user;

import com.guo.base.controller.baseController;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.vo.UserLoginVo;
import com.guo.transport.user.UserTransport;
import com.guo.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类描述：用户信息控制层
 *
 * @ClassName UserController
 * @Description 用户信息控制层
 * @Author 郭佳
 * @Date 2021/3/20 22:19
 * @Version 1.0
 */
@RestController("userController")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true")
public class UserController extends baseController {

	@Autowired
	private UserTransport userTransport;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * 用户登录
	 *
	 * @Description: 用户登录
	 * @Param: [com.guo.pojo.vo.UserLoginVo]
	 * @return: com.guo.base.pojo.vo.ResponseVo
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	@PostMapping("/userLogin")
	public ResponseVo userLogin(@RequestBody UserLoginVo userLoginVo) throws Exception {
		return userTransport.getUserLogin(userLoginVo);
	}

	/**
	 * 根据id查询对象信息
	 *
	 * @Description: 根据id查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.base.pojo.vo.ResponseVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	@GetMapping("/{id}")
	public ResponseVo<Object> getUserById(@PathVariable("id") String id) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(userTransport.getUserById(id));
			} else {
				//返回用户未登录信息
				return ResponseVo.getNologinResponse("用户未登录");
			}
		} else {
			//返回用户未登录信息
			return ResponseVo.getNologinResponse("用户未登录");
		}
	}

	/**
	 * 根据token查询对象信息
	 *
	 * @Description: 根据token查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.base.pojo.vo.ResponseVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	@GetMapping("/token")
	public ResponseVo<Object> getUserByToken( String token) throws Exception {
		return ResponseVo.getSuccessResponse(userTransport.getUserByToken(token));
	}

	/**
	 * 通过查询条件查询对象分页信息
	 *
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.user.User, java.lang.Integer, java.lang.Integer]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	@CrossOrigin(allowCredentials = "true")
	public ResponseVo<User> getPageVoByQuery(@RequestBody User query, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(userTransport.getPageVoByQuery(new QueryVo<>(query, new PageVo<>(pageNum, pageSize))));
			} else {
				//返回用户未登录信息
				return ResponseVo.getNologinResponse("用户未登录");
			}
		} else {
			//返回用户未登录信息
			return ResponseVo.getNologinResponse("用户未登录");
		}
	}

	/**
	 * 通过条件查询对象信息
	 *
	 * @Description: 通过条件查询对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/query")
	public ResponseVo<User> getUserListByQuery(@RequestBody User query) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(userTransport.getListByQuery(query));
			} else {
				//返回用户未登录信息
				return ResponseVo.getNologinResponse("用户未登录");
			}
		} else {
			//返回用户未登录信息
			return ResponseVo.getNologinResponse("用户未登录");
		}
	}

	/**
	 * 保存对象信息
	 *
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/save")
	public ResponseVo<User> saveUser(@RequestBody User user) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User userByToken = userTransport.getUserByToken(token);
			if (userByToken != null) {
				user.setCreateUser(userByToken.getId());
				if (userTransport.save(user)) {
					return ResponseVo.getSuccessResponse("保存成功");
				} else {
					return ResponseVo.getErrorResponse("保存失败");
				}
			} else {
				//返回用户未登录信息
				return ResponseVo.getNologinResponse("用户未登录");
			}
		} else {
			//返回用户未登录信息
			return ResponseVo.getNologinResponse("用户未登录");
		}
	}

	/**
	 * 更新对象信息
	 *
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/update")
	public ResponseVo<User> updateUser(@RequestBody User user) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User userByToken = userTransport.getUserByToken(token);
			if (userByToken != null) {
				if (userTransport.update(user)) {
					return ResponseVo.getSuccessResponse("更新成功");
				} else {
					return ResponseVo.getErrorResponse("更新失败");
				}
			} else {
				//返回用户未登录信息
				return ResponseVo.getNologinResponse("用户未登录");
			}
		} else {
			//返回用户未登录信息
			return ResponseVo.getNologinResponse("用户未登录");
		}
	}

	/**
	 * @Description: 注销用户
	 * @Param: []
	 * @return: com.guo.base.pojo.vo.ResponseVo
	 * @Author: 郭佳
	 * @Date: 2021/4/1
	 */
	@GetMapping("/logout")
	public ResponseVo loggoutUser() throws Exception{
		return ResponseVo.getSuccessResponse(50002);
	}

	@GetMapping("/getId")
	public String getId() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 30; i++) {
			sb.append(idGenerator.createId());
			sb.append("\t\t\t\t\n");
		}
		return sb.toString();
	}
}