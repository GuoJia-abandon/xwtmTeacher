package com.guo.transport.user;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.vo.UserLoginVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName UserTransport
 * @Description 用户信息传输层接口
 * @Author 郭佳
 * @Date 2021/3/20 20:28
 * @Version 1.0
 */
@FeignClient(name = "xwtm-system-provider")
@RequestMapping("/user/transport")
public interface UserTransport {

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@PostMapping("/id")
	User getUserById(@RequestParam String id) throws Exception;


	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.user.User, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	PageVo<User> getPageVoByQuery(@RequestBody QueryVo<User> queryVo) throws Exception;

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: java.util.List<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	List<User> getListByQuery(@RequestBody User query) throws Exception;

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	boolean save(@RequestBody User entity) throws Exception;

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	boolean update(@RequestBody User entity) throws Exception;

	/**
	 * @Description: 用户登录
	 * @Param: [com.guo.pojo.vo.UserLoginVo]
	 * @return: com.guo.base.pojo.vo.ResponseVo
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	@PostMapping("/userLogin")
	ResponseVo getUserLogin(@RequestBody UserLoginVo userLoginVo) throws Exception;

	/**
	 * @Description: 通过token获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/token")
	User getUserByToken(@RequestParam String token) throws Exception;

	/**
	 * 根据手机号码查询对象信息
	 * @Description: 根据手机号码查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/cellphone")
	User findUserByCellphone(@RequestParam String cellphone) throws Exception;
}