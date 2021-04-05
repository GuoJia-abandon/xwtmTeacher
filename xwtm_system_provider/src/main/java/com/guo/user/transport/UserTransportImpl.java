package com.guo.user.transport;
import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.User;
import com.guo.pojo.vo.UserLoginVo;
import com.guo.transport.user.UserTransport;
import com.guo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 类描述：
 *
 * @ClassName UserTransportImpl
 * @Description 用户信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("userTransport")
@RequestMapping("/user/transport")
public class UserTransportImpl implements UserTransport {

	@Autowired
	private UserService userService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public User getUserById(@RequestParam String id) throws Exception {
		return userService.getUserById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.user.User, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<User> getPageVoByQuery(@RequestBody QueryVo<User> queryVo) throws Exception{
		return userService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: java.util.List<com.guo.pojo.entity.user.User>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<User> getListByQuery(@RequestBody User query) throws Exception{
		return userService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody User entity) throws Exception{
		return userService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.user.User]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody User entity) throws Exception{
		return userService.update(entity);
	}

	/**
	 * @Description: 用户登录
	 * @Param: [com.guo.pojo.vo.UserLoginVo]
	 * @return: com.guo.base.pojo.vo.ResponseVo
	 * @Author: 郭佳
	 * @Date: 2021/3/22
	 */
	@PostMapping("/userLogin")
	@Override
	public ResponseVo getUserLogin(@RequestBody UserLoginVo userLoginVo) throws Exception {
		return userService.getUserLogin(userLoginVo.getCellphone(),userLoginVo.getPassword());
	}

	/**
	 * @Description: 通过token获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/token")
	@Override
	public User getUserByToken(@RequestParam String token) throws Exception{
		return userService.getUserByToken(token);
	}

	/**
	 * 根据手机号码查询对象信息
	 * @Description: 根据手机号码查询对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.user.User
	 * @Author: 郭佳
	 * @Date: 2021/3/23
	 */
	@PostMapping("/cellphone")
	@Override
	public User findUserByCellphone(@RequestParam String cellphone) throws Exception{
		return userService.findUserByCellphone(cellphone);
	}

}