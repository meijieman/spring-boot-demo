package com.major.demo.controller;

import com.major.demo.entiy.Response;
import com.major.demo.entiy.SysUser;
import com.major.demo.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public Response saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("major" + new Date());
		user.setNickname("hick " + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return Response.success("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public Response updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return Response.success("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public Response deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return Response.success("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public Response queryUserById(String userId) {
		
		return Response.success(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public Response queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return Response.success(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public Response queryUserListPaged(Integer page) {

		if (page == null) {
			page = 1;
		}

		int pageSize = 10;

		SysUser user = new SysUser();
		// 添加查询条件
//		user.setNickname("lee");

		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

		return Response.success(userList);
	}

	@RequestMapping("/queryUserByIdCustom")
	public Response queryUserByIdCustom(String userId) {

		return Response.success(userService.queryUserByIdCustom(userId));
	}

	@RequestMapping("/saveUserTransactional")
	public Response saveUserTransactional() {

		String userId = sid.nextShort();

		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());

		userService.saveUserTransactional(user);

		return Response.success("保存成功");
	}
}
