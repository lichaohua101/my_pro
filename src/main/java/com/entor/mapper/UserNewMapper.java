package com.entor.mapper;

import com.entor.entity.UserNew;

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
public interface UserNewMapper extends BaseMapper<UserNew> {

	/**
	 * 查找用户的个人信息
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM user_new where user_new.uid=#{id}")
	public UserNew queryByUid(int id);
}