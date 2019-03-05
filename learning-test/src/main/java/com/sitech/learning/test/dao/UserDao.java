package com.sitech.learning.test.dao;

import com.sitech.learning.test.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserDao
 * Author:   Childwanwan
 * Date:     2019/3/4 15:33
 * Description: 用户表dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Mapper
public interface UserDao {
	/**
	 * 所有技术User，返回List<User>
	 *
	 * @return
	 */
	List<UserVo> queryUser();

	/**
	 * 所有项目经理User，返回List<User>
	 *
	 * @return
	 */
	List<UserVo> queryUserManager();

	/**
	 * 登入
	 *
	 * @return
	 */
	UserVo queryUserByLogin(UserVo userVo);


}
