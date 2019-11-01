package com.entor.service;

import com.entor.entity.ClassroomDetails;

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
public interface IClassroomDetailsService extends IService<ClassroomDetails> {
	
	/**
	 * 查询一个实验室的的 使用过的记录
	 */
	public List<ClassroomDetails> queryclassRoomDOver(int id);
	/**
	 * 查询一个实验室的的 时间安排
	 */
	public List<ClassroomDetails> queryclassRoomDYES(int id);
	/**
	 * 查询一个实验室的的 申请
	 */
	public List<ClassroomDetails> queryclassRoomDNO(int id);
	/**
	 * 班级 使用实验室 过的记录
	 * @param id
	 * @return
	 */
	public List<ClassroomDetails> queryClassRoomDByCollege(int id);
}
