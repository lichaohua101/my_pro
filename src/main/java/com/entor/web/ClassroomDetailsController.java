package com.entor.web;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.entor.entity.ClassroomDetails;
import com.entor.entity.User;
import com.entor.service.IClassroomDetailsService;
import com.entor.service.IUserService;

import cn.hutool.core.date.DateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Controller
public class ClassroomDetailsController {
	
	@Autowired
	private IClassroomDetailsService classroomDetailsService;
	@Autowired
	private IUserService userService;
	
	//查询一个实验室的的 申请
	@RequestMapping("/queryclassRoomDNO")
	public String queryclassRoomDNO(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		List<ClassroomDetails> list = classroomDetailsService.queryclassRoomDNO(id);
		model.addAttribute("list", list);
		return "admin/classroom/trueApply";
	}
	//查询一个实验室的的 时间安排queryclassRoomDYES
	@RequestMapping("/queryclassRoomDYES")
	public String queryclassRoomDYES(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		List<ClassroomDetails> list = classroomDetailsService.queryclassRoomDYES(id);
		model.addAttribute("list", list);
		return "admin/classroom/classRoomD";
	}
	//添加申请
	@RequestMapping("/addApply")
	public String addApply() {
		return "admin/classroom/apply";
	}
	//添加一条实验室的记录
	@RequestMapping("/addclassRoomD")
	public String addclassRoomD(ClassroomDetails cDetails,HttpServletRequest request) throws ParseException {
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		System.out.println("当前用户"+ user);
		
		
		String login = request.getParameter("loginTimeD");
		String exit = request.getParameter("exitTimeD");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (login!="") {
			Date l = sdf.parse(login);
			cDetails.setLoginTime(l); 
		}else {
			cDetails.setLoginTime(null); 
		}
		if (exit!="") {
			Date e = sdf.parse(exit);
			cDetails.setExitTime(e);
		}else {
			cDetails.setExitTime(null);
		}
		System.out.println(cDetails);
		classroomDetailsService.insert(cDetails);
		if (user.getRid()==2) {
			return "admin/index";
		}
		if (cDetails.getApply()!=1) {
			return "redirect:queryclassRoomDNO?id="+cDetails.getClassRoomId();
		}else {
			return "redirect:queryclassRoomDYES?id="+cDetails.getClassRoomId();
		}
	}
	//删除实验室的一条记录
	@RequestMapping("/deleteclassRoomD")
	public String deleteclassRoomD(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		ClassroomDetails cDetails = classroomDetailsService.selectById(id);
		classroomDetailsService.deleteById(id);
		if (cDetails.getApply()!=1) {
			return "redirect:queryclassRoomDNO?id="+cDetails.getClassRoomId();
		}else {
			return "redirect:queryclassRoomDYES?id="+cDetails.getClassRoomId();
		}
	}
	//修改实验室的申请   updateclassRoomDApply
	@RequestMapping("/updateclassRoomDApply")
	public String updateclassRoomDApply(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		ClassroomDetails cDetails = classroomDetailsService.selectById(id);
		cDetails.setApply(1);
		classroomDetailsService.updateById(cDetails);
		System.out.println(cDetails);
		return "redirect:queryclassRoomDNO?id="+cDetails.getClassRoomId();
	}
	//修改实验室的一条数据updateclassRoomDApply
	@RequestMapping("/updateclassRoomD")
	public String updateclassRoom(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		ClassroomDetails cDetails = classroomDetailsService.selectById(id);
		model.addAttribute("CCD", cDetails);
		return "admin/classroom/updateClassRoomD";
	}
	//修改实验室的一条数据  2019-10-29T01:00
	@RequestMapping("/updateclassRoomDF")
	public String updateclassRoomDF(ClassroomDetails cDetails,HttpServletRequest request) throws ParseException {
		System.out.println(cDetails);
		String login = request.getParameter("loginTimeD");
		String exit = request.getParameter("exitTimeD");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (login!="") {
			Date l = sdf.parse(login);
			cDetails.setLoginTime(l); 
		}
		if (exit!="") {
			Date e = sdf.parse(exit);
			cDetails.setExitTime(e);
		}
		classroomDetailsService.updateById(cDetails);
		return "redirect:queryclassRoomDYES?id="+cDetails.getClassRoomId();  
	}
	
	
}
