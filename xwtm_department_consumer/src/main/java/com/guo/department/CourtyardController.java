package com.guo.department;

import com.guo.base.controller.baseController;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.department.Courtyard;
import com.guo.pojo.entity.user.User;
import com.guo.transport.department.CourtyardTransport;
import com.guo.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类描述：院校信息信息控制层
 *
 * @ClassName CourtyardController
 * @Description 院校信息信息控制层
 * @Author 郭佳
 * @Date 2021/3/20 22:19
 * @Version 1.0
 */

@RestController("courtyardController")
@RequestMapping("/courtyard")
public class CourtyardController extends baseController {

	@Autowired
	private CourtyardTransport courtyardTransport;
	@Autowired
	private UserTransport userTransport;


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
	public ResponseVo<Object> getCourtyardById(@PathVariable("id") String id) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(courtyardTransport.getCourtyardById(id));
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
	 * 通过查询条件查询对象分页信息
	 *
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard, java.lang.Integer, java.lang.Integer]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVo<Courtyard> getPageVoByQuery(@RequestBody Courtyard query, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(courtyardTransport.getPageVoByQuery(new QueryVo<>(query, new PageVo<>(pageNum, pageSize))));
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
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/query")
	public ResponseVo<Courtyard> getCourtyardListByQuery(@RequestBody Courtyard query) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(courtyardTransport.getListByQuery(query));
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
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/save")
	public ResponseVo<Courtyard> saveCourtyard(@RequestBody Courtyard Courtyard) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User userByToken = userTransport.getUserByToken(token);
			if (userByToken != null) {
				Courtyard.setCreateUser(userByToken.getId());
				if (courtyardTransport.save(Courtyard)) {
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
	 * @Param: [com.guo.pojo.entity.Courtyard.Courtyard]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.Courtyard.Courtyard>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/update")
	public ResponseVo<Courtyard> updateCourtyard(@RequestBody Courtyard Courtyard) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				if (courtyardTransport.update(Courtyard)) {
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
}