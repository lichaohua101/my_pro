package com.entor.service.impl;

import com.entor.entity.UserNew;
import com.entor.mapper.UserNewMapper;
import com.entor.service.IUserNewService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

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
public class UserNewServiceImpl extends ServiceImpl<UserNewMapper, UserNew> implements IUserNewService {
	
	@Autowired
	private UserNewMapper userNewMapper;
	
	/**
	 * 添加用户的个人信息
	 * @param userNew
	 */
	@Override
	public void addUserNew(UserNew userNew) {
		userNewMapper.insert(userNew);
	}
	/**
	 * 修改用户的个人信息
	 * @param userNew
	 */
	@Override
	public void updateUserNew(UserNew userNew) {
		userNewMapper.updateById(userNew);
	}
	/**
	 * 查找用户的个人信息
	 * @param id
	 * @return
	 */
	@Override
	public UserNew queryByUid(int id) {
		return userNewMapper.queryByUid(id);
	}
	
}
