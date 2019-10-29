package com.entor.service.impl;

import com.entor.entity.ClassroomDetails;
import com.entor.mapper.ClassroomDetailsMapper;
import com.entor.service.IClassroomDetailsService;
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
public class ClassroomDetailsServiceImpl extends ServiceImpl<ClassroomDetailsMapper, ClassroomDetails> implements IClassroomDetailsService {

	@Autowired
	private ClassroomDetailsMapper classroomDetailsMapper;	
	
	/**
	 *  查询一个实验室的的 时间安排
	 */
	@Override
	public List<ClassroomDetails> queryclassRoomD(int id) {
		return classroomDetailsMapper.queryclassRoomD(id);
	}
	
}
