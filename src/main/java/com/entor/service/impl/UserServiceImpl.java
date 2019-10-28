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
	 * 添加一个用户
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		userMapper.insert(user);
	}
	/**
	 * 删除一个用户
	 * @param id
	 */
	@Override
	public void deleteById(int id) {
		userMapper.deleteById(id);
	}
	/**
	 * 修改一个用户
	 * @param user
	 */
	@Override
	public void update(User user) {
		userMapper.updateById(user);
	}
	/**
	 * 查询一个用户
	 * @param id
	 * @return
	 */
	@Override
	public User queryById(int id) {
		return userMapper.selectById(id);
	}
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
