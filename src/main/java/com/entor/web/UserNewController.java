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
	
	//修改個人信息
	@RequestMapping("/updateUserNew")
	public String updateUserNew(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		UserNew userNew = userNewService.selectById(id);
		model.addAttribute("userNew", userNew);
		return "admin/user/updateUserNew"; 
	}
	//修改個人信息
	@RequestMapping("/updateUserNewF")
	public String updateUserNewF(UserNew userNew) {
		userNewService.updateById(userNew);
		System.out.println("修改为"+userNew);
		return "admin/index";
	}
	
}
