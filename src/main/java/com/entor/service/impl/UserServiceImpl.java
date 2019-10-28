package com.entor.service.impl;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;
import com.entor.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	
	/**
	 * 帐号查用户
	 * @param username
	 * @return
	 */
	@Override
	public User queryUserByUsername(String username) {
		Wrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq(User.USERNAME, username);
		return selectOne(wrapper);
	}
	/**
	 * 查询所有老师
	 * @return
	 */
	@Override
	public List<User> queryAllTeacher() {
		Wrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq(User.RID, 3);
		return selectList(wrapper);
	}
	
}
