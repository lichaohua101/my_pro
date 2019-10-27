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
@TableName("collegeclass_details")
public class CollegeclassDetails extends Model<CollegeclassDetails> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 班级
     */
	private Integer collegeCId;
    /**
     * 用户
     */
	private Integer userId;


	public Integer getId() {
		return id;
	}

	public CollegeclassDetails setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getCollegeCId() {
		return collegeCId;
	}

	public CollegeclassDetails setCollegeCId(Integer collegeCId) {
		this.collegeCId = collegeCId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public CollegeclassDetails setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public static final String ID = "id";

	public static final String COLLEGECID = "collegeCId";

	public static final String USERID = "userId";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CollegeclassDetails{" +
			", id=" + id +
			", collegeCId=" + collegeCId +
			", userId=" + userId +
			"}";
	}
}
