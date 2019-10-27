package com.entor.service.impl;

import com.entor.entity.Collegeclass;
import com.entor.entity.User;
import com.entor.mapper.CollegeclassMapper;
import com.entor.service.ICollegeclassService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Service
public class CollegeclassServiceImpl extends ServiceImpl<CollegeclassMapper, Collegeclass> implements ICollegeclassService {
	
	@Autowired
	private CollegeclassMapper collegeclassMapper;
	
	/**
	 * 有什么学院
	 * @return
	 */
	@Override
	public List<Collegeclass> queryCollege() {
		return collegeclassMapper.queryCollege();
	}
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	@Override
	public List<Collegeclass> queryClass(String college) {
		return collegeclassMapper.queryClass(college);
	}
	/**
	 * 删除学院
	 * @param college
	 */
	@Override
	public void deleteCollege(String college) {
		Wrapper<Collegeclass> wrapper = new  EntityWrapper<Collegeclass>();
		wrapper.eq(Collegeclass.COLLEGE, college);
		collegeclassMapper.delete(wrapper);
	}
	/**
	 * 修改学院
	 * @param college
	 */
	@Override
	public void updateCollege(String college,String upCollege) {
		collegeclassMapper.updateCollege(college, upCollege);
	}
	/**
	 * 一个班级的全部学生
	 * @param id
	 * @return
	 */
	@Override
	public List<User> queryCollegeClassUser(int id) {
		return collegeclassMapper.queryCollegeClassUser(id);
	}
	
}
