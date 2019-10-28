package com.entor.mapper;

import com.entor.entity.Collegeclass;
import com.entor.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author LiChaoHua
 * @since 2019-10-27
 */
@Mapper
public interface CollegeclassMapper extends BaseMapper<Collegeclass> {

	/**
	 * 有什么学院
	 * @return
	 */
	@Select("select * FROM collegeclass GROUP BY college ORDER BY id")
	public List<Collegeclass> queryCollege();
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	@Select("SELECT * FROM collegeclass where  college = #{college} ")
	public List<Collegeclass> queryClass(String college);
	/**
	 * 修改学院名字
	 * @param college
	 * @param upCollege
	 */
	@Update("UPDATE collegeclass cc SET  cc.college = #{upCollege} WHERE cc.college = #{college}")
	public void updateCollege(@Param(value = "college") String college,@Param(value = "upCollege") String upCollege);
	/**
	 * 一个班级的全部学生
	 * @param id
	 * @return
	 */
	@Select("SELECT u.* FROM collegeclass_details ccd ,`user` u WHERE u.id=ccd.userId and ccd.collegeCId= #{id}")
	public List<User> queryCollegeClassUser(int id);
	/**
	 * 通过用户Id 查 用户的班级
	 * @param id
	 * @return
	 */
	@Select("SELECT collegeclass.* FROM collegeclass ,collegeclass_details  WHERE collegeclass_details.collegeCId=collegeclass.id and collegeclass_details.userId= #{id}")
	public Collegeclass queryCCByUId(int id);
}