package com.entor.web;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.entor.entity.ClassroomDetails;
import com.entor.service.IClassroomDetailsService;

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
	
	//查询一个实验室的的 时间安排
	@RequestMapping("/queryclassRoomD")
	public String queryclassRoomD(int id,HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		List<ClassroomDetails> list = classroomDetailsService.queryclassRoomD(id);
		model.addAttribute("list", list);
		return "admin/classroom/classRoomD";
	}
	//添加一条实验室的记录
	@RequestMapping("/addclassRoomD")
	public String addclassRoomD(ClassroomDetails cDetails,HttpServletRequest request) throws ParseException {
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
		System.out.println(cDetails);
		classroomDetailsService.insert(cDetails);
		return "redirect:queryAllClassRoom";
	}
	//删除实验室的一条记录
	@RequestMapping("/deleteclassRoomD")
	public String deleteclassRoomD(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		classroomDetailsService.deleteById(id);
		return "redirect:queryAllClassRoom";
	}
	//修改实验室的一条数据
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
		return "redirect:queryclassRoomD?id="+cDetails.getClassRoomId();  
	}
	
	
}
