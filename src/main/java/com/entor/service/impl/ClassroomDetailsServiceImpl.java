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
	 *  查询一个实验室的的 使用过的记录
	 */
	@Override
	public List<ClassroomDetails> queryclassRoomDOver(int id) {
		return classroomDetailsMapper.queryclassRoomDOver(id);
	}
	/**
	 *  查询一个实验室的的 时间安排
	 */
	@Override
	public List<ClassroomDetails> queryclassRoomDYES(int id) {
		return classroomDetailsMapper.queryclassRoomDYES(id);
	}
	/**
	 *  查询一个实验室的的 申请
	 */
	@Override
	public List<ClassroomDetails> queryclassRoomDNO(int id) {
		return classroomDetailsMapper.queryclassRoomDNO(id);
	}
	/**
	 * 班级 使用实验室 过的记录
	 * @param id
	 * @return
	 */
	@Override
	public List<ClassroomDetails> queryClassRoomDByCollege(int id) {
		return classroomDetailsMapper.queryClassRoomDByCollege(id);
	}
	
}
