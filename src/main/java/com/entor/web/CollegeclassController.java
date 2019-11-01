package com.entor.web;


import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.ClassroomDetails;
import com.entor.entity.Collegeclass;
import com.entor.entity.User;
import com.entor.service.IClassroomDetailsService;
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
	@Autowired
	private IClassroomDetailsService CRDS;
	//学院所有 班级奖励
	@RequestMapping("/rewardCollege")
	public String rewardCollege(Model model,HttpServletRequest request) {
		String college = request.getParameter("college");
		List<Collegeclass> list = collegeclassService.queryClass(college);
		List<ClassroomDetails> listC = null;
		
		for (Collegeclass collegeclass : list) {
			//获取次数
			listC = CRDS.queryClassRoomDByCollege(collegeclass.getId());
			collegeclass.setTimes(listC.size());
			//获取时长
			double hour = 0;
			for (ClassroomDetails classroomDetails : listC) {
				Date aDate = classroomDetails.getLoginTime();
				Date bDate = classroomDetails.getExitTime();
				if (aDate==null||bDate==null) {
					break;
				}
				long login = aDate.getTime();
				long exit = bDate.getTime();
				long diff;
			        if (login < exit) {
			            diff = exit - login;
			        } else {
			            diff = login - exit;
			        }
			    hour = (diff / (60 * 60 * 1000));
			}
			collegeclass.setDuration((int) hour);
		}
		//排序
		Collections.sort(list, new Comparator<Collegeclass>(){
            /*
             * int compare(Person p1, Person p2) 返回一个基本类型的整型，
             * 返回负数表示：p1 小于p2，
             * 返回0 表示：p1和p2相等，
             * 返回正数表示：p1大于p2
             */
			@Override
            public int compare(Collegeclass p1, Collegeclass p2) {
                //按照Person的年龄进行升序排列
                if(p1.getTimes() < p2.getTimes()){
                    return 1;
                }
                if(p1.getTimes() == p2.getTimes()){
                    return 0;
                }
                return -1;
            }
        });
		//
		model.addAttribute("list", list);
		return "admin/collegeclass/sumCollege";
	}
	//班级 使用过在实验室
	@RequestMapping("/sumClass")
	public String sumClass(Model model,HttpServletRequest request) {
		//获取班级Id
		int id = Integer.parseInt(request.getParameter("banji"));
		List<ClassroomDetails> list = CRDS.queryClassRoomDByCollege(id);
		int times = list.size();
		model.addAttribute("times", times);
		model.addAttribute("list", list);
		return "admin/collegeclass/sumClass";
	}
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
	//添加班级addCollegeClass
	@RequestMapping("/addCollegeClass")
	private String addCollegeClass(Collegeclass collegeclass, HttpServletRequest request) {
		collegeclassService.insert(collegeclass);
		return "redirect:queryAllCollege";
	}
	//查询班级信息
	@RequestMapping("/queryCollegeClassById")
	private String queryCollegeClassById(int id, HttpServletRequest request,Model model) {
		id = Integer.parseInt(request.getParameter("id"));
		Collegeclass collegeclass = collegeclassService.selectById(id);
		model.addAttribute("cc", collegeclass);
		return "admin/collegeclass/collegeClass";
	}
	//修改班级信息
	@RequestMapping("/updatecollegeClassById")
	public String updatecollegeClassById(Model model,HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Collegeclass collegeclass = collegeclassService.selectById(id);
		model.addAttribute("cc", collegeclass);
		return "admin/collegeclass/upcollegeClass";
	}
	//修改班级信息
	@RequestMapping("/updatecollegeClassByIdF")
	public String updatecollegeClassByIdF(Collegeclass collegeclass) {
		collegeclassService.updateById(collegeclass);
		return "redirect:queryCollegeClassById?id="+collegeclass.getId();
	}
	//删除班级collegeName=厨师
	@RequestMapping("/deleteCollegeClassById")
	public String deleteCollegeClassById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Collegeclass collegeclass = collegeclassService.selectById(id);
		String name = collegeclass.getCollege();
		collegeclassService.deleteById(id);
		return "redirect:queryAllCollege";
	}
	//验证学院是否存在
	@RequestMapping("/checkCollege")
	private int checkCollege(HttpServletRequest request) {
		int msg = 1;
		List<Collegeclass> list = collegeclassService.queryCollege();
		String college = request.getParameter("collegName");
		for (Collegeclass c : list) {
			System.out.println(c);
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
}

