package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("classroom_details")
public class ClassroomDetails extends Model<ClassroomDetails> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 被使用房间的Id
     */
	private Integer classRoomId;
    /**
     * 开始使用时间
     */
	private Date loginTime;
    /**
     * 结束使用时间
     */
	private Date exitTime;
    /**
     * 带课的老师
     */
	private Integer teacherId;
    /**
     * 使用的班级
     */
	private Integer collegeId;


	public Integer getId() {
		return id;
	}

	public ClassroomDetails setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getClassRoomId() {
		return classRoomId;
	}

	public ClassroomDetails setClassRoomId(Integer classRoomId) {
		this.classRoomId = classRoomId;
		return this;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public ClassroomDetails setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
		return this;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public ClassroomDetails setExitTime(Date exitTime) {
		this.exitTime = exitTime;
		return this;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public ClassroomDetails setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
		return this;
	}

	public Integer getCollegeId() {
		return collegeId;
	}

	public ClassroomDetails setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
		return this;
	}

	public static final String ID = "id";

	public static final String CLASSROOMID = "classRoomId";

	public static final String LOGINTIME = "loginTime";

	public static final String EXITTIME = "exitTime";

	public static final String TEACHERID = "teacherId";

	public static final String COLLEGEID = "collegeId";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ClassroomDetails{" +
			", id=" + id +
			", classRoomId=" + classRoomId +
			", loginTime=" + loginTime +
			", exitTime=" + exitTime +
			", teacherId=" + teacherId +
			", collegeId=" + collegeId +
			"}";
	}
}
