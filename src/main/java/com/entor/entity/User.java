package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户的帐号(学号)
     */
	private String username;
    /**
     * 用户的密码
     */
	private String password;
    /**
     * 角色id
     */
	private Integer rid;
    /**
     * 用户名
     */
	private String user;
    /**
     * 0 不在线， 1 在线
     */
	private Integer online;


	public Integer getId() {
		return id;
	}

	public User setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Integer getRid() {
		return rid;
	}

	public User setRid(Integer rid) {
		this.rid = rid;
		return this;
	}

	public String getUser() {
		return user;
	}

	public User setUser(String user) {
		this.user = user;
		return this;
	}

	public Integer getOnline() {
		return online;
	}

	public User setOnline(Integer online) {
		this.online = online;
		return this;
	}

	public static final String ID = "id";

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";

	public static final String RID = "rid";

	public static final String USER = "user";

	public static final String ONLINE = "online";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			", id=" + id +
			", username=" + username +
			", password=" + password +
			", rid=" + rid +
			", user=" + user +
			", online=" + online +
			"}";
	}
}
