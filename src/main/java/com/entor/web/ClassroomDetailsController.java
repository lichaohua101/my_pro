package com.entor.web;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
		for (ClassroomDetails c : list) {
			System.out.println(c);
		}
		model.addAttribute("list", list);
		return "admin/classroom/classRoomD";
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
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginTime = request.getParameter("loginTimeD");
		Date lDate = sdf.parse(loginTime);
		System.out.println(loginTime);
		System.out.println(lDate);*/
		System.out.println(cDetails);
		classroomDetailsService.updateById(cDetails);
		return "redirect:queryclassRoomD?id="+cDetails.getClassRoomId();  
	}
}
