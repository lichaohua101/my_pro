package com.entor.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.UserNew;
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
public class UserNewController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserNewService userNewService;
	
	//修改用户信息
	@RequestMapping("/updateUserNew")
	public String updateUserNew(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		UserNew userNew = userNewService.queryByUid(id);
		System.out.println("个人信息"+userNew);
		model.addAttribute("userNew", userNew);
		return "admin/user/updateUserNew"; 
	}
	@RequestMapping("/updateUserNewF")
	public String updateUserNewF(UserNew userNew) {
		System.out.println("修改为"+userNew);
		userNewService.updateUserNew(userNew);
		return "admin/index";
	}
	
}
