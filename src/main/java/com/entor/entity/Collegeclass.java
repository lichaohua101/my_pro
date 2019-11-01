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
 * @since 2019-11-01
 */
public class Collegeclass extends Model<Collegeclass> {

    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 学院名字
     */
	private String college;
    /**
     * 班级名字
     */
	private String className;
    /**
     * 老师id
     */
	private Integer teacherId;
    /**
     * 奖励
     */
	private Integer rewardID;
    /**
     * 班级使用时长
     */
	private Integer Duration;
    /**
     * 使用实验室的次数
     */
	private Integer times;


	public Integer getId() {
		return id;
	}

	public Collegeclass setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCollege() {
		return college;
	}

	public Collegeclass setCollege(String college) {
		this.college = college;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public Collegeclass setClassName(String className) {
		this.className = className;
		return this;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public Collegeclass setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
		return this;
	}

	public Integer getRewardID() {
		return rewardID;
	}

	public Collegeclass setRewardID(Integer rewardID) {
		this.rewardID = rewardID;
		return this;
	}

	public Integer getDuration() {
		return Duration;
	}

	public Collegeclass setDuration(Integer Duration) {
		this.Duration = Duration;
		return this;
	}

	public Integer getTimes() {
		return times;
	}

	public Collegeclass setTimes(Integer times) {
		this.times = times;
		return this;
	}

	public static final String ID = "id";

	public static final String COLLEGE = "college";

	public static final String CLASSNAME = "className";

	public static final String TEACHERID = "teacherId";

	public static final String REWARDID = "rewardID";

	public static final String DURATION = "Duration";

	public static final String TIMES = "times";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Collegeclass{" +
			", id=" + id +
			", college=" + college +
			", className=" + className +
			", teacherId=" + teacherId +
			", rewardID=" + rewardID +
			", Duration=" + Duration +
			", times=" + times +
			"}";
	}
}
