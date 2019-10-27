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
public class Reward extends Model<Reward> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 奖励个名字
     */
	private String name;


	public Integer getId() {
		return id;
	}

	public Reward setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Reward setName(String name) {
		this.name = name;
		return this;
	}

	public static final String ID = "id";

	public static final String NAME = "name";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Reward{" +
			", id=" + id +
			", name=" + name +
			"}";
	}
}
