package edu.gdut.imis.ssmtest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.gdut.imis.ssmtest.model.User;
import edu.gdut.imis.ssmtest.service.UserService;

/**
 * 处理用户请求Controller
 */
@Controller
public class UserController {
	
	/*
	 * 自动注入UserService
	 */
	@Autowired
	private UserService userService;
	
	//登录
	@RequestMapping("/login")
	public String login(User user,Model model,HttpSession session){
		User loginUser = userService.selectLogin(user);
		if(loginUser!=null){
			session.setAttribute("user", loginUser);
			return "redirect:alluser";
		}else{
			model.addAttribute("message", "username or password is wrong!");
			return "loginform";
		}
	}
	
	//退出
	@RequestMapping("/loginout")
	public String loginout(HttpSession session){
		session.invalidate();
		return "loginform";
	}
	
	//查询所有用户
	@RequestMapping("/alluser")
	public String selectAllUser(HttpServletRequest request){
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	//跳转至新增用户页面
	@RequestMapping("toadduser")
	public String toAddUserPage(){
		return "adduser";
	}
		
	//新增用户
	@RequestMapping("/adduser")
	public String addUser(User user,HttpServletRequest request){
		userService.addUser(user);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	//跳转至更新用户页面
	@RequestMapping("toupdateuser")
	public String toUpdateUser(@Param("id") Integer id,HttpServletRequest request,Model model){
		model.addAttribute("user_id", id);
		return "updateuser";
	}
	
	//更新用户
	@RequestMapping("updateuser")
	public String toUpdateUser(@ModelAttribute("form")User user,HttpServletRequest request){
		userService.updateUser(user);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	//跳转至更新用户页面
	@RequestMapping("deleteuser")
	public String deleteUser(@Param("id") Integer id,HttpServletRequest request){
		userService.deleteUser(id);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
}
