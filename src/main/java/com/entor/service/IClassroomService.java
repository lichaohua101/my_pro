package com.entor.service;

import com.entor.entity.Classroom;

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
public interface IClassroomService extends IService<Classroom> {
	
	/**
	 * 查询所有实验室
	 */
	public List<Classroom> queryAllClassRoom();
	
}
