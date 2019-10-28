package com.entor.service;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
public interface IUserService extends IService<User> {
	
	/**
	 * 添加一个用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 删除一个用户
	 * @param id
	 */
	public void deleteById(int id);
	/**
	 * 修改一个用户
	 * @param user
	 */
	public void update(User user);
	/**
	 * 查询一个用户
	 * @param id
	 * @return
	 */
	public User queryById(int id);
	/**
	 * 帐号查用户
	 * @param username
	 * @return
	 */
	public User queryUserByUsername(String username);
	/**
	 * 查询所有老师
	 * @return
	 */
	public List<User> queryAllTeacher();
	
}
