package com.entor.service;

import com.entor.entity.UserNew;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
public interface IUserNewService extends IService<UserNew> {
	
	/**
	 * 添加用户的个人信息
	 * @param userNew
	 */
	public void addUserNew(UserNew userNew);
	/**
	 * 修改用户的个人信息
	 * @param userNew
	 */
	public void updateUserNew(UserNew userNew);
	/**
	 * 查找用户的个人信息
	 * @param id
	 * @return
	 */
	public UserNew queryByUid(int id);
}
