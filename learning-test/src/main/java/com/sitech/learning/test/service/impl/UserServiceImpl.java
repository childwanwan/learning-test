package com.sitech.learning.test.service.impl;

import com.sitech.learning.test.dao.UserDao;
import com.sitech.learning.test.service.IUserService;
import com.sitech.learning.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Childwanwan
 * Date:     2019/3/4 15:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UserServiceImpl
implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserVo> queryUser() {
		//System.out.println("userDao:"+userDao.toString());
		return userDao.queryUser();
	}

	@Override
	public List<UserVo> queryUserManager() {
		return userDao.queryUserManager();
	}

	@Override
	public UserVo queryUserByLogin(UserVo userVo) {
		return userDao.queryUserByLogin(userVo);
	}
}
