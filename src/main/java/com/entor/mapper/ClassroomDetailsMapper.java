package com.entor.mapper;

import com.entor.entity.ClassroomDetails;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Mapper
public interface ClassroomDetailsMapper extends BaseMapper<ClassroomDetails> {
	
	/**
	 * 查询一个实验室的的 时间安排
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM classroom_details crd WHERE crd.classRoomId=#{id} ORDER BY crd.loginTime desc")
	public List<ClassroomDetails> queryclassRoomD(int id);
	
}