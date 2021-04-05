package com.guo.department;

import com.guo.base.controller.baseController;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.department.ClassGrade;
import com.guo.pojo.entity.user.User;
import com.guo.transport.department.ClassGradeTransport;
import com.guo.transport.user.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类描述：班级信息信息控制层
 *
 * @ClassName ClassGradeController
 * @Description 班级信息信息控制层
 * @Author 郭佳
 * @Date 2021/3/20 22:19
 * @Version 1.0
 */

@RestController("classGradeController")
@RequestMapping("/class")
public class ClassGradeController extends baseController {

	@Autowired
	private ClassGradeTransport classGradeTransport;
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
	public ResponseVo<Object> getClassGradeById(@PathVariable("id") String id) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(classGradeTransport.getClassGradeById(id));
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
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade, java.lang.Integer, java.lang.Integer]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVo<ClassGrade> getPageVoByQuery(@RequestBody ClassGrade query, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(classGradeTransport.getPageVoByQuery(new QueryVo<>(query, new PageVo<>(pageNum, pageSize))));
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
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/query")
	public ResponseVo<ClassGrade> getClassGradeListByQuery(@RequestBody ClassGrade query) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(classGradeTransport.getListByQuery(query));
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
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/save")
	public ResponseVo<ClassGrade> saveClassGrade(@RequestBody ClassGrade ClassGrade) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User userByToken = userTransport.getUserByToken(token);
			if (userByToken != null) {
				ClassGrade.setCreateUser(userByToken.getId());
				if (classGradeTransport.save(ClassGrade)) {
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
	 * @Param: [com.guo.pojo.entity.ClassGrade.ClassGrade]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.ClassGrade.ClassGrade>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/update")
	public ResponseVo<ClassGrade> updateClassGrade(@RequestBody ClassGrade ClassGrade) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				if (classGradeTransport.update(ClassGrade)) {
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