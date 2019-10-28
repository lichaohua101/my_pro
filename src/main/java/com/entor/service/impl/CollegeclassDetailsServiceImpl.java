package com.entor.service.impl;

import com.entor.entity.Collegeclass;
import com.entor.entity.CollegeclassDetails;
import com.entor.entity.UserDetails;
import com.entor.mapper.CollegeclassDetailsMapper;
import com.entor.mapper.UserDetailsMapper;
import com.entor.service.ICollegeclassDetailsService;
import com.entor.service.IUserDetailsService;
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
public class CollegeclassDetailsServiceImpl extends ServiceImpl<CollegeclassDetailsMapper, CollegeclassDetails> implements ICollegeclassDetailsService {

	@Autowired
	private CollegeclassDetailsMapper CCDM;
	
	
	
}
