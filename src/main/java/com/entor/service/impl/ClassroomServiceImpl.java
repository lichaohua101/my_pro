package com.entor.service.impl;

import com.entor.entity.Classroom;
import com.entor.mapper.ClassroomMapper;
import com.entor.service.IClassroomService;
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
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {
	
	@Autowired
	private ClassroomMapper classroomMapper;
	
	/**
	 * 查询所有实验室
	 */
	@Override
	public List<Classroom> queryAllClassRoom() {
		return classroomMapper.selectList(null);
	}
	
}
