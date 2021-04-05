package com.guo.workload;

import com.guo.base.controller.baseController;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.entity.workload.WorkLoad;
import com.guo.pojo.entity.workload.WorkLoadType;
import com.guo.pojo.vo.WorkLoadVo;
import com.guo.transport.department.ClassGradeTransport;
import com.guo.transport.department.CourseTransport;
import com.guo.transport.department.CourtyardTransport;
import com.guo.transport.department.DepartmentTransport;
import com.guo.transport.user.UserTransport;
import com.guo.transport.workload.WorkLoadMethodsTransport;
import com.guo.transport.workload.WorkLoadTransport;
import com.guo.transport.workload.WorkLoadTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.security.PublicKey;

/**
 * 类描述：工作量信息控制层
 *
 * @ClassName WorkLoadController
 * @Description 工作量信息控制层
 * @Author 郭佳
 * @Date 2021/3/20 22:19
 * @Version 1.0
 */

@RestController("workLoadController")
@RequestMapping("/workLoad")
public class WorkloadController extends baseController {

	@Autowired
	private WorkLoadTransport workLoadTransport;
	@Autowired
	private UserTransport userTransport;
	@Autowired
	private WorkLoadTypeTransport workLoadTypeTransport;
	@Autowired
	private ClassGradeTransport classGradeTransport;
	@Autowired
	private CourseTransport courseTransport;
	@Autowired
	private DepartmentTransport departmentTransport;
	@Autowired
	private CourtyardTransport courtyardTransport;
	@Autowired
	private WorkLoadMethodsTransport workLoadMethodsTransport;


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
	public ResponseVo<Object> getWorkLoadById(@PathVariable("id") String id) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(workLoadTransport.getWorkLoadById(id));
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
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad, java.lang.Integer, java.lang.Integer]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVo<WorkLoad> getPageVoByQuery(@RequestBody WorkLoad query, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(workLoadTransport.getPageVoByQuery(new QueryVo<>(query, new PageVo<>(pageNum, pageSize))));
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
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/query")
	public ResponseVo<WorkLoad> getWorkLoadListByQuery(@RequestBody WorkLoad query) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				return ResponseVo.getSuccessResponse(workLoadTransport.getListByQuery(query));
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
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/save")
	public ResponseVo<WorkLoad> saveWorkLoad(@RequestBody WorkLoadVo workLoadvo) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User userByToken = userTransport.getUserByToken(token);
			if (userByToken != null) {
				WorkLoad workLoad = new WorkLoad();
				//保存工作量类型信息
				workLoad.setWorkLoadType(workLoadTypeTransport.getWorkLoadTypeById(workLoadvo.getWorkLoadType()));
				//保存班级信息
				workLoad.setClassGrade(classGradeTransport.getClassGradeById(workLoadvo.getClassGrade()));
				//保存课程信息
				workLoad.setCourse(courseTransport.getCourseById(workLoadvo.getCourse()));
				//保存系别信息
				workLoad.setDepartment(departmentTransport.getDepartmentById(workLoadvo.getDepartment()));
				//保存院校信息
				workLoad.setCourtyard(courtyardTransport.getCourtyardById(workLoadvo.getCourtyard()));
				//保存授课方式
				workLoad.setWorkLoadMethods(workLoadMethodsTransport.getWorkLoadMethodsById(workLoadvo.getWorkLoadMethods()));
				//保存备注信息
				workLoad.setRemark(workLoadvo.getRemark());
				workLoad.setYear(workLoadvo.getYear());
				workLoad.setPeriod(workLoadvo.getPeriod());
				workLoad.setClassNum(workLoadvo.getClassNum());
				workLoad.setUser(userTransport.getUserById(userByToken.getId()));
				workLoad.setCreateUser(userByToken.getId());
				if (workLoadTransport.save(workLoad)) {
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
	 * @Param: [com.guo.pojo.entity.WorkLoad.WorkLoad]
	 * @return: com.guo.base.pojo.vo.ResponseVo<com.guo.pojo.entity.WorkLoad.WorkLoad>
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/update")
	public ResponseVo<WorkLoad> updateWorkLoad(@RequestBody WorkLoad workLoad) throws Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			User user = userTransport.getUserByToken(token);
			if (user != null) {
				if (workLoadTransport.update(workLoad)) {
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