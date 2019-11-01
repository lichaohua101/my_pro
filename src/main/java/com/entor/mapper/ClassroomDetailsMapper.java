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
	 * 查询一个实验室的的 使用过的记录
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM classroom_details WHERE classRoomId=#{id} AND Apply =2 ORDER BY loginTime desc")
	public List<ClassroomDetails> queryclassRoomDOver(int id);
	/**
	 * 查询一个实验室的的 时间安排
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM classroom_details WHERE classRoomId=#{id} AND Apply =1 ORDER BY loginTime desc")
	public List<ClassroomDetails> queryclassRoomDYES(int id);
	
	/**
	 * 查询一个实验室的的 申请
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM classroom_details WHERE classRoomId=#{id} AND Apply =0 ORDER BY loginTime desc")
	public List<ClassroomDetails> queryclassRoomDNO(int id);
	/**
	 * 班级 使用实验室 过的记录
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM classroom_details WHERE SYSDATE() > exitTime and Apply = 2 AND collegeId=#{id}")
	public List<ClassroomDetails> queryClassRoomDByCollege(int id);
}