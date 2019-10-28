package com.entor.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Classroom;
import com.entor.service.IClassroomService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Controller
public class ClassroomController {
	
	@Autowired
	private IClassroomService classroomService;
	//查询所有实验室
	@RequestMapping("/queryAllClassRoom")
	public String queryAllClassRoom(Model model) {
		List<Classroom> list = classroomService.queryAllClassRoom();
		model.addAttribute("list", list);
		return "admin/classroom/classRoom";
	}
	//修改一個实验室
	@RequestMapping("/updateclassRoom")
	public String updateclassRoom(int id,HttpServletRequest request,Model model) {
		id=Integer.parseInt(request.getParameter("id"));
		Classroom classroom =  classroomService.selectById(id);
		model.addAttribute("classRoom", classroom);
		return "admin/classroom/updateClassRoom";
	}
	//修改一個實驗室
	@RequestMapping("/updateclassRoomF")
	public String updateclassRoomF(Classroom classroom) {
		classroomService.updateById(classroom);
		return "redirect:queryAllClassRoom";
	}
	//添加一個實驗室
	@RequestMapping("/addclassRoom")
	public String addclassRoom(Classroom classroom) {
		classroomService.insert(classroom);
		return "redirect:queryAllClassRoom";
	}
	//添加一個實驗室
	@RequestMapping("/deleteclassRoom")
	public String deleteclassRoom(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		classroomService.deleteById(id);
		return "redirect:queryAllClassRoom";
	}
}
