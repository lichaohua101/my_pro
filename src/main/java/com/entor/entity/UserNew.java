package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@TableName("user_new")
public class UserNew extends Model<UserNew> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer uid;
	private Integer age;
    /**
     * 专业
     */
	private String major;
    /**
     * 地址
     */
	private String address;
    /**
     * 电话
     */
	private String phone;
    /**
     * 班级
     */
	private Integer collegeclassId;
    /**
     * 实验室
     */
	private Integer classroomId;


	public Integer getId() {
		return id;
	}

	public UserNew setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUid() {
		return uid;
	}

	public UserNew setUid(Integer uid) {
		this.uid = uid;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public UserNew setAge(Integer age) {
		this.age = age;
		return this;
	}

	public String getMajor() {
		return major;
	}

	public UserNew setMajor(String major) {
		this.major = major;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public UserNew setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserNew setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public Integer getCollegeclassId() {
		return collegeclassId;
	}

	public UserNew setCollegeclassId(Integer collegeclassId) {
		this.collegeclassId = collegeclassId;
		return this;
	}

	public Integer getClassroomId() {
		return classroomId;
	}

	public UserNew setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
		return this;
	}

	public static final String ID = "id";

	public static final String UID = "uid";

	public static final String AGE = "age";

	public static final String MAJOR = "major";

	public static final String ADDRESS = "address";

	public static final String PHONE = "phone";

	public static final String COLLEGECLASSID = "collegeclassId";

	public static final String CLASSROOMID = "classroomId";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserNew{" +
			", id=" + id +
			", uid=" + uid +
			", age=" + age +
			", major=" + major +
			", address=" + address +
			", phone=" + phone +
			", collegeclassId=" + collegeclassId +
			", classroomId=" + classroomId +
			"}";
	}
}
