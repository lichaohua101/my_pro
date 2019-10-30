package com.entor.web;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.Collegeclass;
import com.entor.entity.Role;
import com.entor.entity.User;
import com.entor.entity.UserNew;
import com.entor.service.ICollegeclassService;
import com.entor.service.IRoleService;
import com.entor.service.IUserNewService;
import com.entor.service.IUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ICollegeclassService collegeclassService;
	@Autowired 
	private IUserNewService userNewService;
	@Autowired
	private IRoleService roleService;
	
	// 跳转到登录页面
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	// 通过帐号 验证登录
	@RequestMapping("/loginCheck")
	public String loginCheck(String username, String password, Map<String, Object> map) {
		System.out.println("明文密码" + password);
		// 加密，加盐，防止编译的密码相同而被破解
		SimpleHash hash = new SimpleHash("md5", password, "123", 2);
		String enpassword = hash.toHex();
		System.out.println("经过md5方式加密并经过2次盐“123”的密文密码" + enpassword);
		UsernamePasswordToken token = new UsernamePasswordToken(username, enpassword);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			// 后台首页
			return "redirect:/adminIndex";
		} catch (Exception e) {
			map.put("msg", "账号或者密码错误");
			return "redirect:/login";
		}
	}
	//跳转到后台
	@RequestMapping("/adminIndex")
	public String adminIndex() {
		return "admin/index";
	}
	// 注销(admin,user)
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login";
	}
	// 跳转到用户注册页面checkUsername
	@RequestMapping("/userRegister")
	public String userRegister() {
		return "user/studentRegister";
	}

	// 跳转到用户注册页面checkUsername
	@RequestMapping("/AdminRegister")
	public String AdminRegister() {
		return "user/teacherRegister";
	}
	// 校验学号是否已经别注册
	@RequestMapping("/checkUsername")
	@ResponseBody
	public int checkUsername(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map)
			throws IOException {
		String username = request.getParameter("username");
		User user = userService.queryUserByUsername(username);
		int msg = 1;
		System.out.println(username);
		if (user == null) {
			msg = 0;
		}
		return msg;
	}
	// 添加一个用户
	@RequestMapping("/addUser")
	public String addUser(User user) {
		// 注册加密
		SimpleHash hash = new SimpleHash("md5", user.getPassword(), "123", 2);
		String enpassword = hash.toHex();
		user.setPassword(enpassword);
		userService.insert(user);
		return "redirect:/login";
	}
	//删除一个用户
	@RequestMapping("/deleteUserById")
	public String deleteUserById(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		userService.deleteById(id);
		return "redirect:/queryCollegeClassUser";
	}
	//修改一个用户
	@RequestMapping("/updateUserById")
	public String updateUserById(int id,HttpServletRequest request,Model model) {
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		return "admin/user/updateUser";
	}
	//修改一个用户
	@RequestMapping("/updateUserByIdF")
	public String updateUserByIdF(User user,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(user);
		userService.updateById(user);
		//查询班级
		Collegeclass collegeclass = collegeclassService.queryCCByUId(user.getId());
		System.out.println(collegeclass);
		return "redirect:queryAllCollege";
	}
	//查询所有老师
	@RequestMapping("/queryAllTeacher")
	public String queryAllTeacher(Model model) {
		List<User> list = userService.queryAllTeacher();
		model.addAttribute("list", list);
		return "admin/user/teacher";
	}
	//精确查询、个人资料修改
	@RequestMapping("/queryUserNewByUsername")
	public String queryUserByUsername(Model model,HttpServletRequest request) {
		String username = request.getParameter("username");
		User user = userService.queryUserByUsername(username);
		if (user==null) { 
			return "redirect:adminIndex";
		}else {
			UserNew userNew = userNewService.queryByUid(user.getId());
			if (userNew==null) {
				return "admin/user/addUserNew";
			}
			model.addAttribute("userNew", userNew);
			return "admin/user/userNew";
		}
		
	}
	//写入用户的详细信息
	@RequestMapping("/addUserNewF")
	public String addUserNewF(UserNew userNew) {
		System.out.println(userNew);
		userNewService.insert(userNew);
		return "redirect:adminIndex";
	}
	
}
