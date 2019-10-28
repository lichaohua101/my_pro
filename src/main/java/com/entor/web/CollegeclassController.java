package com.entor.web;


import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Collegeclass;
import com.entor.entity.User;
import com.entor.service.ICollegeclassService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Controller
public class CollegeclassController {
	
	@Autowired
	private ICollegeclassService collegeclassService;
	
	// 有什么学院
	@RequestMapping("/queryAllCollege")
	private String queryCollege(Model model) {
		List<Collegeclass> list = collegeclassService.queryCollege();
		model.addAttribute("list1", list);
		return "admin/collegeclass/college";
	}
	// 学院里有哪些班级
	@RequestMapping("/queryCollegeClass")
	private String queryClass(HttpServletRequest request, Model model) {
		String college = request.getParameter("collegeName");
		List<Collegeclass> list = collegeclassService.queryClass(college);
		model.addAttribute("list2", list);
		return "admin/collegeclass/college";
	}
	//删除学院collegeName
	@RequestMapping("/deleteCollege")
	private String deleteCollege(HttpServletRequest request, Model model) {
		String college = request.getParameter("collegeName");
		collegeclassService.deleteCollege(college);
		return "redirect:queryAllCollege";
	}
	//修改学院
	@RequestMapping("/updateCollege")
	private String updateCollege(HttpServletRequest request, Model model) {
		String college = request.getParameter("collegeName");
		model.addAttribute("college", college);
		return "admin/collegeclass/updateCollege";
	}
	//修改学院Form
	@RequestMapping("/updateCollegeF")
	private String updateCollegeF(HttpServletRequest request, Model model) {
		String college = request.getParameter("college");
		String upCollege = request.getParameter("upCollege");
		System.out.println(college+"---"+upCollege);
		collegeclassService.updateCollege(college, upCollege);
		return "redirect:queryAllCollege";
	}
	//查询班级的学生
	@RequestMapping("/queryCollegeClassUser")
	public String queryCollegeClass(int id,HttpServletRequest request,Model model) {
		id =Integer.parseInt(request.getParameter("id"));
		List<User> list = collegeclassService.queryCollegeClassUser(id);
		model.addAttribute("list", list);
		return "admin/user/user";
	}
	//验证学院是否存在
	@RequestMapping("/checkCollege")
	private int checkCollege(HttpServletRequest request) {
		int msg = 1;
		List<Collegeclass> list = collegeclassService.queryCollege();
		String college = request.getParameter("collegName");
		for (Collegeclass c : list) {
			if (c.getCollege()==college) {
				msg=1;
			}
		}
		return msg;
	}
	//验证班级是否存在
	@RequestMapping("/checkCollegeClass")
	private int checkCollegeClass(HttpServletRequest request) {
		int msg = 1;
		return msg;
	}
	//添加班级addCollegeClass
	@RequestMapping("/addCollegeClass")
	private String addCollegeClass(Collegeclass collegeclass, HttpServletRequest request) {
		collegeclassService.insert(collegeclass);
		return "redirect:queryAllCollege";
	}
}

