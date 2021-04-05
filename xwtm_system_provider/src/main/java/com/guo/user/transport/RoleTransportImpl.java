package com.guo.user.transport;

import com.guo.base.pojo.vo.PageVo;
import com.guo.base.pojo.vo.QueryVo;
import com.guo.base.pojo.vo.ResponseVo;
import com.guo.pojo.entity.user.Role;
import com.guo.transport.user.RoleTransport;
import com.guo.transport.user.RoleTransport;
import com.guo.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述：用户角色信息传输层接口实现类
 *
 * @ClassName RoleTransportImpl
 * @Description 用户角色信息传输层接口实现类
 * @Author 郭佳
 * @Date 2021/3/20 22:10
 * @Version 1.0
 */
@RestController("RoleTransport")
@RequestMapping("/role/transport")
public class RoleTransportImpl implements RoleTransport {

	@Autowired
	private RoleService roleService;

	/**
	 * @Description: 根据id获取对象信息
	 * @Param: [java.lang.String]
	 * @return: com.guo.pojo.entity.Role.Role
	 * @Author: 郭佳
	 * @Date: 2021/3/20
	 */
	@Override
	@PostMapping("/id")
     public Role getRoleById(@RequestParam String id) throws Exception {
		return roleService.getRoleById(id);
	}

	/**
	 * @Description: 通过查询条件查询对象分页信息
	 * @Param: [com.guo.pojo.entity.Role.Role, com.guo.base.pojo.vo.PageVo]
	 * @return: com.guo.base.pojo.vo.PageVo<java.lang.Object>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/queryvo")
	@Override
	public PageVo<Role> getPageVoByQuery(@RequestBody QueryVo<Role> queryVo) throws Exception{
		return roleService.getPageVoByQuery(queryVo.getQuery(),queryVo.getPageVo());
	}

	/**
	 * @Description: 根据查询条件查询对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: java.util.List<com.guo.pojo.entity.Role.Role>
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/query")
	@Override
	public List<Role> getListByQuery(@RequestBody Role query) throws Exception{
		return roleService.getListByQuery(query);
	}

	/**
	 * @Description: 保存对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody Role entity) throws Exception{
		return roleService.save(entity);
	}

	/**
	 * @Description: 更新对象信息
	 * @Param: [com.guo.pojo.entity.Role.Role]
	 * @return: boolean
	 * @Author: 郭佳
	 * @Date: 2021/3/21
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody Role entity) throws Exception{
		return roleService.update(entity);
	}
}