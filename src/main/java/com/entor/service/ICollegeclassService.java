package com.entor.service;

import com.entor.entity.Collegeclass;
import com.entor.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
public interface ICollegeclassService extends IService<Collegeclass> {
	/**
	 * 有什么学院
	 * @return
	 */
	public List<Collegeclass> queryCollege();
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	public List<Collegeclass> queryClass(String college);
	/**
	 * 删除学院
	 * @param college
	 */
	public void deleteCollege(String college);
	/**
	 * 修改学院
	 * @param college
	 */
	public void updateCollege(String college,String upCollege);
	/**
	 * 一个班级的全部学生
	 * @param id
	 * @return
	 */
	public List<User> queryCollegeClassUser(int id);
	
}
