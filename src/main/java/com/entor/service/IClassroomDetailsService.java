package com.entor.service;

import com.entor.entity.ClassroomDetails;

import java.util.List;


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
	 * 查询一个实验室的的 时间安排
	 */
	public List<ClassroomDetails> queryclassRoomD(int id);
	
}
